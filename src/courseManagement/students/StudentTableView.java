package courseManagement.students;

import courseManagement.CourseManagementFactory;
import courseManagement.Student;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

import java.util.List;

@SuppressWarnings("serial")
public class StudentTableView extends TableView<Student> {

	/**
	 * Create a new students table view.
	 */
	public StudentTableView() {
		super(Student.class, "Studenten", List.of("Name", "Semester"));

		addButton.addActionListener(e -> {
			Student student = CourseManagementFactory.eINSTANCE.createStudent();
			StudentEditView studentEditView = new StudentEditView(repository, student, CrudAction.CREATE);
			studentEditView.openDialog();
		});
	}

	/**
	 * Retrieve student represented by clicked table row and show edit dialog.
	 */
	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Student student = repository.findByIndex(rowIndex);
		StudentEditView studentDetailsView = new StudentEditView(repository, student, CrudAction.UPDATE);
		studentDetailsView.openDialog();
	}

	/**
	 * Update table content by creating a data vector representation of the entities
	 * and setting it as the table content.
	 */
	@Override
	protected void updateTable(List<Student> students) {
		Object[][] dataVector = new Object[students.size()][2];
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			dataVector[i][0] = student.getName();
			dataVector[i][1] = student.getSemester().getLiteral();
		}
		setDataVector(dataVector);
	}
}
