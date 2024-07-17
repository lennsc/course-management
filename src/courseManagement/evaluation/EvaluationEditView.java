package courseManagement.evaluation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import courseManagement.Course;
import courseManagement.Evaluation;
import courseManagement.Grade;
import courseManagement.Student;
import courseManagement.course.CourseDao;
import courseManagement.student.StudentDao;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.IdValueItem;
import courseManagement.utils.KeyValueItem;
import courseManagement.utils.KeyValueItemUtil;

@SuppressWarnings("serial")
public class EvaluationEditView extends EditView {
	
	private JComboBox<IdValueItem> studentComboBox;
	private JComboBox<IdValueItem> courseComboBox;
	private JComboBox<KeyValueItem> gradeComboBox;
	private GenericRepository<Evaluation> repository;
	private Evaluation evaluation;
	private CrudAction crudAction;
	private StudentDao studentDao;
	private CourseDao courseDao;

	protected EvaluationEditView(GenericRepository<Evaluation> repository, Evaluation evaluation, CrudAction crudAction) {
		super("Kursbewertung " + (crudAction == CrudAction.CREATE ? "erstellen" : "bearbeiten"), crudAction, FlowAction.SAVE);
		
		this.repository = repository;
		this.evaluation = evaluation;
		this.crudAction = crudAction;
		studentDao = new StudentDao();
		courseDao = new CourseDao();
		
		studentComboBox = new JComboBox<>(getStudentIdValueItems());
		if (crudAction == CrudAction.UPDATE) {
			studentComboBox.setSelectedItem(new IdValueItem(evaluation.getStudent().getId(), evaluation.getStudent().getName()));
		}
		addLabel("Student", true);
		add(studentComboBox);
		
		courseComboBox = new JComboBox<>(getCourseIdValueItems());
		if (crudAction == CrudAction.UPDATE) {
			courseComboBox.setSelectedItem(new IdValueItem(evaluation.getCourse().getId(), evaluation.getCourse().getTitle()));
		}
		addLabel("Kurs");
		add(courseComboBox);
		
		gradeComboBox = new JComboBox<>(KeyValueItemUtil.getKeyValueItems(Grade.values()));
		if (crudAction == CrudAction.UPDATE) {
			gradeComboBox.setSelectedItem(new KeyValueItem(evaluation.getValue().getName(), evaluation.getValue().getLiteral()));
		}
		addLabel("Bewertung");
		add(gradeComboBox);
		
		flowActionButton.addActionListener(e -> saveEvaluation());
		deleteButton.addActionListener(e -> deleteEvaluation());
		
		addActionButtons();
	}

	private void saveEvaluation() {
		Student selectedStudent = studentDao.findById(((IdValueItem) studentComboBox.getSelectedItem()).id());
		evaluation.setStudent(selectedStudent);
		Course selectedCourse = courseDao.findById(((IdValueItem) courseComboBox.getSelectedItem()).id());
		evaluation.setCourse(selectedCourse);
		Grade grade = Grade.valueOf(((KeyValueItem) gradeComboBox.getSelectedItem()).key());
		evaluation.setValue(grade);
		
		switch (crudAction) {
		case CREATE:
			repository.insert(evaluation);
			break;
		
		case UPDATE:
			repository.update(evaluation);
			break;
		}
		
		close();
	}
	
	private void deleteEvaluation() {
		repository.delete(evaluation);
		close();
	}

	private IdValueItem[] getStudentIdValueItems() {
		List<IdValueItem> idValueItems = new ArrayList<>();
		for (Student student : studentDao.findAll()) {
			idValueItems.add(new IdValueItem(student.getId(), student.getName()));
		}
		return idValueItems.toArray(new IdValueItem[0]);
	}
	
	private IdValueItem[] getCourseIdValueItems() {
		List<IdValueItem> idValueItems = new ArrayList<>();
		for (Course course : courseDao.findAll()) {
			idValueItems.add(new IdValueItem(course.getId(), course.getTitle()));
		}
		return idValueItems.toArray(new IdValueItem[0]);
	}
}
