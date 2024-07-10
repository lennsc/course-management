package courseManagement.course;

import java.util.List;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseType;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class CourseTableView extends TableView<Course> {

	public CourseTableView() {
		super(Course.class, "Kurse", List.of("Titel", "Kurstyp", "Voraussetzungen"));
		
		addButton.addActionListener(e -> {
			Course course = CourseManagementFactory.eINSTANCE.createIntroductory();
			CourseTypeSelectionView view = new CourseTypeSelectionView(repository, course, CrudAction.CREATE);
			view.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Course course = repository.findByIndex(rowIndex);
		CourseEditView courseEditView = new CourseEditView(repository, course, CrudAction.UPDATE);
		courseEditView.openDialog();
	}

	@Override
	protected void updateTable(List<Course> courses) {
		Object[][] dataVector = new Object[courses.size()][2];
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			dataVector[i][0] = course.getTitle();
			dataVector[i][1] = course.getCourseType().getLiteral();
			if (course.getCourseType() == CourseType.ADVANCED) {
				dataVector[i][2] = getPrereqsLabels((Advanced) course);
			} else {
				dataVector[i][2] = "";
			}
		}
		setDataVector(dataVector);
	}
	
	private String getPrereqsLabels(Advanced advanced) {
		StringBuilder courseNames = new StringBuilder();
		String prefix = "";
		for (Course prereq : advanced.getPrereqs()) {
			courseNames.append(prefix);
			prefix = ", ";
			courseNames.append(prereq.getLabel());
		}
		return courseNames.toString();
	}
}
