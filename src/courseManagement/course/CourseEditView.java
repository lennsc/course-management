package courseManagement.course;

import java.util.List;
import javax.swing.JTextField;
import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;

@SuppressWarnings("serial")
public class CourseEditView extends EditView {

	private JTextField labelField;
	private CheckboxPanel<Course> prereqsCheckboxPanel;
	private GenericRepository<Course> repository;
	private Course course;
	private CrudAction crudAction;

	/**
	 * Create a new course edit view.
	 * 
	 * @param repository Reference to repository from course table view
	 * @param course
	 * @param crudAction Enum value indicating whether this form is used for
	 *                   creating or editing a course instance
	 */
	public CourseEditView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super("Kurs " + (crudAction == CrudAction.CREATE ? "hinzufügen" : "bearbeiten") + " ("
				+ course.getCourseType().getLiteral() + ")", crudAction, FlowAction.SAVE);

		this.repository = repository;
		this.course = course;
		this.crudAction = crudAction;
		labelField = new JTextField(course.getTitle());

		addLabel("Name", true);
		add(labelField);

		if (course instanceof Advanced) {
			List<Course> options = repository.findAll().stream()
					.filter(e -> !(e.getId() == course.getId()))
					.toList();
			List<Course> selectedOptions = ((Advanced) course).getPrereqs();
			prereqsCheckboxPanel = new CheckboxPanel<>(options, selectedOptions, (option) -> option.getTitle());

			addLabel("Voraussetzungen");
			add(prereqsCheckboxPanel);
		}

		flowActionButton.addActionListener(e -> saveCourse());
		deleteButton.addActionListener(e -> deleteCourse());

		addActionButtons();
	}

	private void saveCourse() {
		course.setTitle(labelField.getText());

		if (course instanceof Advanced) {
			((Advanced) course).getPrereqs().clear();
			((Advanced) course).getPrereqs().addAll(prereqsCheckboxPanel.getSelectedOptions());
		}

		switch (crudAction) {
		case CREATE:
			repository.insert(course);
			break;

		case UPDATE:
			repository.update(course);
			break;
		}

		close();
	}

	private void deleteCourse() {
		// TODO: Implement validation that (1) the user really wants to delete this
		// course and (2) that this course can be deleted safely in the current state
		repository.delete(course);
		close();
	}
}
