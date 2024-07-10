package courseManagement.course;

import java.util.Arrays;

import javax.swing.JComboBox;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseType;
import courseManagement.Introductory;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class CourseTypeSelectionView extends EditView {

	/**
	 * Create a new course type selection view.
	 * 
	 * @param repository Reference to the repository from the course table view.
	 * @param course
	 * @param crudAction
	 */
	protected CourseTypeSelectionView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super("Kurstypen auswählen", crudAction, FlowAction.NEXT);
		JComboBox<KeyValueItem> courseTypeComboBox = new JComboBox<>(getCourseTypeKeyValueItems());
		courseTypeComboBox.setSelectedItem(
				new KeyValueItem(CourseType.INTRODUCTORY.getName(), CourseType.INTRODUCTORY.getLiteral()));

		flowActionButton.addActionListener(e -> {
			CourseType selectedCourseType = CourseType
					.valueOf(((KeyValueItem) courseTypeComboBox.getSelectedItem()).key());
			CourseEditView view;

			if (selectedCourseType == CourseType.ADVANCED) {
				Advanced advancedCourse = CourseManagementFactory.eINSTANCE.createAdvanced();
				advancedCourse.setId(course.getId());
				advancedCourse.setTitle(course.getTitle());
				advancedCourse.setCourseType(CourseType.ADVANCED);
				view = new CourseEditView(repository, advancedCourse, crudAction);
			} else {
				Introductory introductoryCourse = CourseManagementFactory.eINSTANCE.createIntroductory();
				introductoryCourse.setId(course.getId());
				introductoryCourse.setTitle(course.getTitle());
				introductoryCourse.setCourseType(CourseType.INTRODUCTORY);
				view = new CourseEditView(repository, introductoryCourse, crudAction);
			}

			close();
			view.openDialog();
		});

		addLabel("Kurstyp");
		add(courseTypeComboBox);
		addActionButtons();
	}

	/**
	 * Create KeyValueItem objects for each value of the CourseType enum.
	 * 
	 * @implNote Intended as options list for JComboBox
	 * @return Array of CourseType values
	 */
	private KeyValueItem[] getCourseTypeKeyValueItems() {
		return Arrays.asList(CourseType.values()).stream()
				.map(value -> new KeyValueItem(value.getName(), value.getLiteral())).toArray(KeyValueItem[]::new);
	}
}
