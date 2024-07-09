package courseManagement.course;

import java.util.List;

import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseType;
import courseManagement.Introductory;
import courseManagement.utils.TableView;

public class CourseTableView extends TableView<Course> {

	public CourseTableView() {
		super(Course.class, "Kurse", List.of("Titel", "Kurstyp", "Voraussetzungen"));
		
		addButton.addActionListener(e -> {
			Introductory introductory = CourseManagementFactory.eINSTANCE.createIntroductory();
			// TODO: Implement CourseEditView
		});
		
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Course course = repository.findByIndex(rowIndex);
		// ...
	}

	@Override
	protected void updateTable(List<Course> courses) {
		Object[][] dataVector = new Object[courses.size()][2];
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			dataVector[i][0] = course.getTitle();
			dataVector[i][1] = course.getCourseType().getLiteral();
			if (course.getCourseType() == CourseType.ADVANCED) {
				dataVector[i][2] = ""; // TODO: Implement CSV list conversion
			} else {
				dataVector[i][2] = "";
			}
		}
		setDataVector(dataVector);
	}

}
