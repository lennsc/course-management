package courseManagement.completion;

import java.util.List;

import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.Result;
import courseManagement.Student;
import courseManagement.utils.CrudAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class CompletionTableView extends TableView<Student> {
	private GenericRepository<Student> studentRepository;
    private GenericRepository<Course> courseRepository;


    public CompletionTableView() {
        super(Student.class, "Kurskomplettierungen", List.of("Student", "Kurs", "Note"));

        addButton.addActionListener(e -> {
            Student student = CourseManagementFactory.eINSTANCE.createStudent();
            Result result = CourseManagementFactory.eINSTANCE.createResult();
            CompletionEditView completionEditView = new CompletionEditView(studentRepository,courseRepository, student, result, CrudAction.CREATE);
            completionEditView.openDialog();
        });
    }

    @Override
    protected void onClickRowAction() {
        int rowIndex = table.getSelectedRow();
        Student student = repository.findByIndex(rowIndex);
        Result result = student.getTranscript().get(rowIndex); // Assuming the row index corresponds to the result
        CompletionEditView completionEditView = new CompletionEditView(studentRepository,courseRepository, student, result, CrudAction.UPDATE);
        completionEditView.openDialog();
    }

    @Override
    protected void updateTable(List<Student> students) {
        Object[][] dataVector = new Object[students.size()][3];
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            List<Result> transcript = student.getTranscript();
            for (int j = 0; j < transcript.size(); j++) {
                Result result = transcript.get(j);
                dataVector[i][0] = student.getName();
                dataVector[i][1] = result.getKey().getTitle();
                dataVector[i][2] = result.getValue().getLiteral();
            }
        }
        setDataVector(dataVector);
    }
}

