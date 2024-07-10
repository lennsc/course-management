package courseManagement.students;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import courseManagement.CourseManagementFactory;
import courseManagement.Introductory;
import courseManagement.Semester;
import courseManagement.Student;
import courseManagement.Course;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.KeyValueItem;
import courseManagement.utils.KeyValueItemUtil;
import courseManagement.utils.GenericRepository;

@SuppressWarnings("serial")
public class StudentEditView extends EditView {

	private JTextField nameField;
	private JComboBox<KeyValueItem> semesterComboBox;
	private CheckboxPanel<Course> coursePanel;
	private GenericRepository<Student> repository;
	private Student student;
	private CrudAction crudAction;

	/**
	 * Create a student details panel.
	 * 
	 * @param repository Repository from StudentTableView
	 * @param student    Selected student from StudentTableView
	 * @param crudAction Enum value indicating whether a student object is created
	 *                   or updated
	 */
	public StudentEditView(GenericRepository<Student> repository, Student student, CrudAction crudAction) {
		super(crudAction == CrudAction.CREATE ? "Student hinzufügen" : "Student bearbeiten", crudAction, FlowAction.SAVE);
		this.repository = repository;
		this.crudAction = crudAction;
		this.student = student;

		nameField = new JTextField(student.getName());
		semesterComboBox = new JComboBox<>(KeyValueItemUtil.getKeyValueItems(Semester.values()));
		semesterComboBox.setSelectedItem(new KeyValueItem(student.getSemester().getName(), student.getSemester().getLiteral()));

		Introductory mathematik1 = CourseManagementFactory.eINSTANCE.createIntroductory();
		mathematik1.setTitle("Mathematik 1");
		Introductory mathematik2 = CourseManagementFactory.eINSTANCE.createIntroductory();
		mathematik2.setTitle("Mathematik 2");
		coursePanel = new CheckboxPanel<Course>(List.of(mathematik1, mathematik2), List.of(mathematik1));

		flowActionButton.addActionListener(e -> saveStudent());
		deleteButton.addActionListener(e -> deleteStudent());

		addLabel("Name", true);
		add(nameField);
		addLabel("Semester");
		add(semesterComboBox);
		addLabel("Kurse");
		add(coursePanel);
		addActionButtons();
	}

	/**
	 * Save student to database.
	 */
	private void saveStudent() {
		student.setName(nameField.getText());
		student.setSemester(Semester.valueOf(((KeyValueItem) semesterComboBox.getSelectedItem()).key()));
		switch (crudAction) {
			case CREATE:
				repository.insert(student);
				break;
	
			case UPDATE:
				repository.update(student);
				break;
		}
		close();
	}

	/**
	 * Delete student from database.
	 */
	private void deleteStudent() {
		// TODO: Implement user decision validation dialog to verify that the user
		// certainly wants to delete this entity
		repository.delete(student);
		close();
	}
}
