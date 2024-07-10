package courseManagement.course;

import java.util.Arrays;

import javax.swing.JComboBox;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseType;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class CourseTypeSelectionView extends EditView {
	
	private JComboBox<KeyValueItem> courseTypeComboBox;

	protected CourseTypeSelectionView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super("Kurstypen auswählen", crudAction, FlowAction.NEXT);
		courseTypeComboBox = new JComboBox<>(getCourseTypeKeyValueItems());
		courseTypeComboBox.setSelectedItem(new KeyValueItem(CourseType.INTRODUCTORY.getName(), CourseType.INTRODUCTORY.getLiteral()));
		
		flowActionButton.addActionListener(e -> {
			CourseType selectedCourseType = CourseType.valueOf(((KeyValueItem) courseTypeComboBox.getSelectedItem()).key());
			CourseEditView view;
			
			if (selectedCourseType == CourseType.ADVANCED) {
				Advanced advancedCourse = CourseManagementFactory.eINSTANCE.createAdvanced();
				advancedCourse.setId(course.getId());
				advancedCourse.setTitle(course.getTitle());
				advancedCourse.setCourseType(CourseType.ADVANCED);
				view = new CourseEditView(repository, advancedCourse, crudAction);
			} else {
				course.setCourseType(CourseType.INTRODUCTORY);
				view = new CourseEditView(repository, course, crudAction);
			}
			
			close();
			view.openDialog();
		});
		
		addLabel("Kurstyp");
		add(courseTypeComboBox);
		addActionButtons();
	}
	
	private KeyValueItem[] getCourseTypeKeyValueItems() {
		return Arrays.asList(CourseType.values()).stream()
				.map(value -> new KeyValueItem(value.getName(), value.getLiteral())).toArray(KeyValueItem[]::new);
	}
}
