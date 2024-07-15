package courseManagement.course;

import java.util.List;

import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.Student;
import courseManagement.students.StudentEditView;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;
import ognl.Evaluation;

@SuppressWarnings("serial")
public class CourseEvaluationTableView extends TableView<Course>{

	public CourseEvaluationTableView() {
		super(Course.class, "Kurse", List.of("Titel", "Bewertung"));
		addButton.addActionListener(e -> {
			Course course = CourseManagementFactory.eINSTANCE.createIntroductory();
			CourseEvaluationEditView courseEvaluationEditView = new CourseEvaluationEditView(repository, course, CrudAction.CREATE);
			courseEvaluationEditView.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Course course = repository.findByIndex(rowIndex);
		CourseEvaluationEditView courseEvaluationEditView = new CourseEvaluationEditView(repository, course, CrudAction.UPDATE);
		courseEvaluationEditView.openDialog();
		
	}

	@Override
	protected void updateTable(List<Course> courses) {
		Object[][] dataVector = new Object[courses.size()][2];
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			dataVector[i][0] = course.getTitle();
			dataVector[i][1] = course.getEvaluation().getLiteral();
	}
		setDataVector(dataVector);
}
}
