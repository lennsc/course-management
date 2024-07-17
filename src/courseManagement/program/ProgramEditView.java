package courseManagement.program;

import javax.swing.JTextField;

import courseManagement.Course;
import courseManagement.Program;
import courseManagement.course.CourseDao;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;

@SuppressWarnings("serial")
public class ProgramEditView extends EditView {

	private JTextField labelField;
	private CheckboxPanel<Course> optionalCourseCheckboxPanel;
	private CheckboxPanel<Course> requiredCourseCheckboxPanel;
	private GenericRepository<Program> repository;
	private Program program;
	private CrudAction crudAction;
	private CourseDao courseDao;

	protected ProgramEditView(GenericRepository<Program> repository, Program program, CrudAction crudAction) {
		super("Programm " + (crudAction == CrudAction.CREATE ? "erstellen" : "bearbeiten"), crudAction,
				FlowAction.SAVE);

		this.repository = repository;
		this.program = program;
		this.crudAction = crudAction;
		courseDao = new CourseDao();

		labelField = new JTextField(program.getLabel());
		addLabel("Label", true);
		add(labelField);

		requiredCourseCheckboxPanel = new CheckboxPanel<Course>(courseDao.findAll(),
				program.getRequiredCourses().getElements(), (option) -> option.getTitle());
		addLabel("Pflichtkurse");
		add(requiredCourseCheckboxPanel);
		
		optionalCourseCheckboxPanel = new CheckboxPanel<Course>(courseDao.findAll(), program.getCourses().getElements(),
				(option) -> option.getTitle());
		addLabel("Wahlkurse");
		add(optionalCourseCheckboxPanel);

		flowActionButton.addActionListener(e -> saveProgram());
		deleteButton.addActionListener(e -> deleteProgram());
		addActionButtons();
	}

	private void saveProgram() {
		program.setLabel(labelField.getText());
		program.getCourses().getElements().clear();
		program.getCourses().getElements().addAll(optionalCourseCheckboxPanel.getSelectedOptions());
		program.getRequiredCourses().getElements().clear();
		program.getRequiredCourses().getElements().addAll(requiredCourseCheckboxPanel.getSelectedOptions());

		switch (crudAction) {
		case CREATE:
			repository.insert(program);
			break;

		case UPDATE:
			repository.update(program);
			break;
		}

		close();
	}

	private void deleteProgram() {
		repository.delete(program);
		close();
	}
}
