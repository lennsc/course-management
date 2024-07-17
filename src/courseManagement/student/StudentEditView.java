package courseManagement.student;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import courseManagement.Semester;
import courseManagement.Student;
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

		flowActionButton.addActionListener(e -> saveStudent());
		deleteButton.addActionListener(e -> deleteStudent());

		addLabel("Name", true);
		add(nameField);
		addLabel("Semester");
		add(semesterComboBox);
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
