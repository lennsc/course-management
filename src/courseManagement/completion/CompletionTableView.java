package courseManagement.completion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import courseManagement.CourseManagementFactory;
import courseManagement.Result;
import courseManagement.Student;
import courseManagement.student.StudentDao;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class CompletionTableView extends TableView<Student> {
	
	private Map<Integer, Student> rowIndexStudentMap = new HashMap<>();
	private Map<Integer, Result> rowIndexResultMap = new HashMap<>();

	public CompletionTableView() {
		super(new StudentDao(), "Kurskomplettierungen", List.of("Student", "Kurs", "Note"));

		addButton.addActionListener(e -> {
			Student student = CourseManagementFactory.eINSTANCE.createStudent();
			Result result = CourseManagementFactory.eINSTANCE.createResult();
			CompletionEditView completionEditView = new CompletionEditView(repository, student, result, CrudAction.CREATE);
			completionEditView.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Student student = rowIndexStudentMap.get(rowIndex);
		Result result = rowIndexResultMap.get(rowIndex);
		CompletionEditView completionEditView = new CompletionEditView(repository, student, result, CrudAction.UPDATE);
		completionEditView.openDialog();
	}

	@Override
	protected void updateTable(List<Student> entities) {
		rowIndexResultMap.clear();	
		
		int items = 0;
		for (Student student : entities) {
			items += student.getTranscript().size();
		}
		
		Object[][] dataVector = new Object[items][3];
		
		int row = 0;
		for (Student student : entities) {
			if (!student.getTranscript().isEmpty()) {
				for (int i = 0; i < student.getTranscript().size(); i++) {
					Result result = student.getTranscript().get(i);
					dataVector[row][0] = student.getName();
					dataVector[row][1] = result.getKey().getTitle();
					dataVector[row][2] = result.getValue().getLiteral();
					rowIndexStudentMap.put(row, student);
					rowIndexResultMap.put(row, result);
					row++;
				}
			}
		}
		
		setDataVector(dataVector);
	}
}
