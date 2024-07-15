package courseManagement.completion;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import courseManagement.CourseManagementFactory;
import courseManagement.Course;
import courseManagement.Grade;
import courseManagement.Result;
import courseManagement.Student;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.KeyValueItem;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.IdValueItem;
 
@SuppressWarnings("serial")
public class CompletionEditView extends EditView {

    private JTextField studentField;
    private JTextField courseField;
    private JComboBox<KeyValueItem> gradeComboBox;
    private JComboBox<IdValueItem> courseComboBox;
    private JComboBox<IdValueItem> studentComboBox;
    private GenericRepository<Student> studentRepository;
    private GenericRepository<Course> courseRepository;
    private Student student;
    private Result result;
    private CrudAction crudAction;

    public CompletionEditView(GenericRepository<Student> studentRepository,GenericRepository<Course> courseRepository, Student student, Result result, CrudAction crudAction) {
        super(crudAction == CrudAction.CREATE ? "Kurskomplettierung hinzufügen" : "Kurskomplettierung bearbeiten", crudAction, FlowAction.SAVE);
        this.studentRepository = studentRepository;
        this.courseRepository=courseRepository;
        this.student = student;
        this.result = result;
        this.crudAction = crudAction;

        //studentField = new JTextField(student.getName());
        //courseField = new JTextField(result.getKey().getTitle());
        
        //Student ComboBox
        studentComboBox= new JComboBox<IdValueItem>(getStudentKeyValueItems());
        studentComboBox.setSelectedItem(new IdValueItem(student.getId(),student.getName()));
        // Kurs Combobox
        courseComboBox = new JComboBox<>(getCourseKeyValueItems());
        courseComboBox.setSelectedItem(new IdValueItem(result.getKey().getId(), result.getKey().getTitle()));
       
       
        //Grade Combobox
        gradeComboBox = new JComboBox<>(getGradeKeyValueItems());
        gradeComboBox.setSelectedItem(new KeyValueItem(result.getValue().name(), result.getValue().getLiteral()));

        flowActionButton.addActionListener(e -> saveResult());
        deleteButton.addActionListener(e -> deleteResult());

        addLabel("Student", true);
        add(studentComboBox);
        addLabel("Kurs", true);
        add(courseComboBox);
        addLabel("Note", true);
        add(gradeComboBox);
        addActionButtons();
        }
    /*
    private void saveResult() {
        result.setValue(Grade.valueOf(((KeyValueItem) gradeComboBox.getSelectedItem()).key()));
        switch (crudAction) {
            case CREATE:
                student.getTranscript().add(result);
                studentRepository.update(student);
                break;
            case UPDATE:
                studentRepository.update(student);
                break;
        }
        close();
    }

    private void deleteResult() {
        student.getTranscript().remove(result);
        studentRepository.update(student);
        close();
    }
    */
   private void saveResult() {
        result.setValue(Grade.valueOf(((KeyValueItem) gradeComboBox.getSelectedItem()).key()));
        switch (crudAction) {
            case CREATE:
                student.getTranscript().add(result);
                studentRepository.update(student);
                break;
            case UPDATE:
                studentRepository.update(student);
                break;
        }
        close();
    }

    private void deleteResult() {
        student.getTranscript().remove(result);
        studentRepository.update(student);
        close();
    }
     private IdValueItem[] getStudentKeyValueItems() {
        List<IdValueItem> idValueItems = new ArrayList<>();
        for(Student student: studentRepository.findAll() ) {
        	idValueItems.add(new IdValueItem(student.getId(),student.getName()));
        };
        return idValueItems.toArray(new IdValueItem[0]);
    }

    private IdValueItem[] getCourseKeyValueItems() {
		List<IdValueItem> idValueItems= new ArrayList<>();
	   for(Course course: courseRepository.findAll()) {
		   idValueItems.add(new IdValueItem(course.getId(), course.getTitle()));
	   };
	   return idValueItems.toArray(new IdValueItem[0]);
	}
	


    private KeyValueItem[] getGradeKeyValueItems() {
        return Arrays.stream(Grade.values())
                .map(value -> new KeyValueItem(value.name(), value.getLiteral()))
                .toArray(KeyValueItem[]::new);
    }
}