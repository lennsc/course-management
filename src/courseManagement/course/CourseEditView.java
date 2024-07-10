package courseManagement.course;

import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseType;
import courseManagement.utils.CSVUtil;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class CourseEditView extends EditView {
	
	private JTextField labelField;
	private JComboBox<KeyValueItem> courseTypeComboBox;
	private CheckboxPanel<Course> prereqsCheckboxPanel;
	private GenericRepository<Course> repository;
	private Course course;
	private CrudAction crudAction;
	
	public CourseEditView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super(crudAction == CrudAction.CREATE ? "Kurs hinzufügen" : "Kurs bearbeiten", crudAction);
		this.repository = repository;
		this.course = course;
		this.crudAction = crudAction;
		
		labelField = new JTextField(course.getLabel());
		courseTypeComboBox = new JComboBox<>(getCourseTypeKeyValueItems());
		courseTypeComboBox.setSelectedItem(new KeyValueItem(CourseType.INTRODUCTORY.getName(), CourseType.INTRODUCTORY.getLiteral()));
		prereqsCheckboxPanel = new CheckboxPanel<Course>(repository.findAll());
		
		if (course.getCourseType() == CourseType.ADVANCED) {
			
		}
		
		courseTypeComboBox.addActionListener(e -> {
			CourseType selectedCourseType = CourseType.valueOf(((KeyValueItem) courseTypeComboBox.getSelectedItem()).key());
			renderForm(selectedCourseType);
		});
		
		renderForm(course.getCourseType());
	}
	
	private void renderForm(CourseType courseType) {
		addLabel("Label", true);
		add(labelField);
		addLabel("Kurstyp");
		add(courseTypeComboBox);
		if (courseType == CourseType.ADVANCED) {
			addLabel("Voraussetzungen");
			add(prereqsCheckboxPanel);
		}
	}
	
	private KeyValueItem[] getCourseTypeKeyValueItems() {
		return Arrays.asList(CourseType.values()).stream()
				.map(value -> new KeyValueItem(value.getName(), value.getLiteral())).toArray(KeyValueItem[]::new);
	}
}
