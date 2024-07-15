package courseManagement.course;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;

import org.eclipse.emf.common.util.Enumerator;

import courseManagement.Course;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.IdValueItem;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class CourseEvaluationEditView extends EditView{
	private GenericRepository<Course> repository;
	private Course course;
	private CrudAction crudAction;
	private JComboBox<IdValueItem> courseComboBox;
	private JComboBox<KeyValueItem> evaluationComboBox;
	
	public CourseEvaluationEditView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super(crudAction == CrudAction.CREATE ? "Kursbewertung hinzufügen" : "Kursbewertung bearbeiten", crudAction, FlowAction.SAVE);
		this.repository =repository;
		this.course = course;
		this.crudAction = crudAction; 
		 // Kurs Combobox
        courseComboBox = new JComboBox<>(getCourseKeyValueItems());
        if (course != null) {
            courseComboBox.setSelectedItem(new KeyValueItem(course.getTitle(), String.valueOf(course.getId())));
        }

        // Bewertung Combobox
        evaluationComboBox = new JComboBox<>(getEvaluationKeyValueItems());
        if (course != null) {
            if (course.getEvaluation() != null) {
                evaluationComboBox.setSelectedItem(new KeyValueItem(course.getEvaluation().getName(), course.getEvaluation().getLiteral()));
            }
        }
        
        flowActionButton.addActionListener(e -> {
        	Course selectedCourse = getSelectedCourse(repository);
        	selectedCourse.setId(course.getId());
        	selectedCourse.setTitle(course.getTitle());
        	courseManagement.Evaluation selectedEvaluation = getSelectedEvaluation();
        	selectedCourse.setEvaluation(selectedEvaluation);
        	
        	CourseEvaluationEditView editView = new CourseEvaluationEditView(repository, course, crudAction);
            editView.openDialog();  // Methode zum Öffnen des Fensters
            close();
        }
        );
        
		addLabel("Kurs");
		add(courseComboBox);
		addLabel("Bewertung");
		add(evaluationComboBox);
		addActionButtons();
		}

	private IdValueItem[] getCourseKeyValueItems() {
		List<IdValueItem> idValueItems= new ArrayList<>();
	   for(Course course: repository.findAll()) {
		   idValueItems.add(new IdValueItem(course.getId(), course.getTitle()));
	   };
	   return idValueItems.toArray(new IdValueItem[0]);
	}
	/*
	 * private KeyValueItem[] getCourseTypeKeyValueItems() {
		return Arrays.asList(CourseType.values()).stream()
				.map(value -> new KeyValueItem(value.getName(), value.getLiteral())).toArray(KeyValueItem[]::new);
	}
	 */

   /* private KeyValueItem[] getEvaluationKeyValueItems() {
        // Verwende das automatisch generierte VALUES_ARRAY aus der Evaluation-Klasse
        return Arrays.stream(Evaluation.VALUES) 
                .map(evaluation -> new KeyValueItem(evaluation.getName(), evaluation.getLiteral()))
                .toArray(KeyValueItem[]::new);
    }
    
   */
    private KeyValueItem[] getEvaluationKeyValueItems() {
		return Arrays.asList(courseManagement.Evaluation.VALUES).stream()
				.map(value -> new KeyValueItem(((Component) value).getName(), ((Enumerator) value).getLiteral())).toArray(KeyValueItem[]::new);
	}

    public Course getSelectedCourse(GenericRepository<Course> repository) {
        IdValueItem selectedItem = (IdValueItem) courseComboBox.getSelectedItem();
        if (selectedItem == null) {
            return null;
        }
        int courseId = selectedItem.id();
        return repository.findById(courseId);  // Hole den Kurs anhand der ID
    }

    public courseManagement.Evaluation getSelectedEvaluation() {
        KeyValueItem selectedItem = (KeyValueItem) evaluationComboBox.getSelectedItem();
        if (selectedItem == null) {
            return null;
        }
        return courseManagement.Evaluation.fromString(selectedItem.key());  // Hole die Evaluation anhand des Literals
    }

}
