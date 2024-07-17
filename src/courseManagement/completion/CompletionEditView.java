package courseManagement.completion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;

import courseManagement.Course;
import courseManagement.Grade;
import courseManagement.Result;
import courseManagement.Student;
import courseManagement.course.CourseDao;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.IdValueItem;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class CompletionEditView extends EditView {

	private GenericRepository<Student> studentRepository;
	private JComboBox<KeyValueItem> gradeComboBox;
	private JComboBox<IdValueItem> courseComboBox;
	private JComboBox<IdValueItem> studentComboBox;
	private Student student;
	private Result result;
	private CrudAction crudAction;
	private CourseDao courseDao;

	protected CompletionEditView(GenericRepository<Student> studentRepository, Student student, Result result, CrudAction crudAction) {

		super(crudAction == CrudAction.CREATE ? "Kurskomplettierung hinzufügen" : "Kurskomplettierung bearbeiten",
				crudAction, FlowAction.SAVE);

		this.studentRepository = studentRepository;
		this.student = student;
		this.result = result;
		this.crudAction = crudAction;
		courseDao = new CourseDao();

		studentComboBox = new JComboBox<IdValueItem>(getStudentIdValueItems());
		if (crudAction == CrudAction.UPDATE) {
			studentComboBox.setSelectedItem(new IdValueItem(student.getId(), student.getName()));			
		}
		addLabel("Student", true);
		add(studentComboBox);

		courseComboBox = new JComboBox<>(getCourseIdValueItems());
		if (crudAction == CrudAction.UPDATE) {
			courseComboBox.setSelectedItem(new IdValueItem(result.getKey().getId(), result.getKey().getTitle()));			
		}
		addLabel("Kurs");
		add(courseComboBox);

		gradeComboBox = new JComboBox<>(getGradeKeyValueItems());
		gradeComboBox.setSelectedItem(new KeyValueItem(result.getValue().name(), result.getValue().getLiteral()));
		addLabel("Note");
		add(gradeComboBox);

		flowActionButton.addActionListener(e -> saveResult());
		deleteButton.addActionListener(e -> deleteResult());
		addActionButtons();
	}

	private void saveResult() {
		int courseId = ((IdValueItem) courseComboBox.getSelectedItem()).id();
		Course course = courseDao.findById(courseId);
		result.setKey(course);
		result.setValue(Grade.valueOf(((KeyValueItem) gradeComboBox.getSelectedItem()).key()));
		
		int selectedStudentId = ((IdValueItem) studentComboBox.getSelectedItem()).id();
		Student selectedStudent = studentRepository.findById(selectedStudentId);
		student = selectedStudent;
		
		switch (crudAction) {
		case CREATE:
			student.getTranscript().add(result);
			studentRepository.update(student);
			break;
			
		case UPDATE:
			for (int i = 0; i < student.getTranscript().size(); i++) {
				Result currentResult = student.getTranscript().get(i);
				if (currentResult.getId() == result.getId()) {
					student.getTranscript().set(i, result);
				}
			}
			studentRepository.update(student);
			break;
		}
		
		close();
	}

	private void deleteResult() {
		List<Result> updatedTranscript = new ArrayList<>();
		for (Result currentResult : student.getTranscript()) {
			if (currentResult.getId() != result.getId()) {
				updatedTranscript.add(currentResult);
			}
		}
		student.getTranscript().clear();
		student.getTranscript().addAll(updatedTranscript);
		studentRepository.update(student);
		close();
	}

	private IdValueItem[] getStudentIdValueItems() {
		List<IdValueItem> idValueItems = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			idValueItems.add(new IdValueItem(student.getId(), student.getName()));
		}
		return idValueItems.toArray(new IdValueItem[0]);
	}

	private IdValueItem[] getCourseIdValueItems() {
		List<IdValueItem> idValueItems = new ArrayList<>();
		CourseDao courseDao = new CourseDao();
		for (Course course : courseDao.findAll()) {
			idValueItems.add(new IdValueItem(course.getId(), course.getTitle()));
		}
		return idValueItems.toArray(new IdValueItem[0]);
	}

	private KeyValueItem[] getGradeKeyValueItems() {
		return Arrays.stream(Grade.values()).map(value -> new KeyValueItem(value.name(), value.getLiteral()))
				.toArray(KeyValueItem[]::new);
	}
}
