package courseManagement.course;

import java.util.List;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class CourseTableView extends TableView<Course> {

	/**
	 * Create a new course table view.
	 */
	public CourseTableView() {
		super(new CourseDao(), "Kurse", List.of("Titel", "Kurstyp", "Voraussetzungen"));

		addButton.addActionListener(e -> {
			Course course = CourseManagementFactory.eINSTANCE.createIntroductory();
			CourseTypeSelectionView view = new CourseTypeSelectionView(repository, course, CrudAction.CREATE);
			view.openDialog();
		});
	}

	/**
	 * Handle table row click
	 */
	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Course course = repository.findByIndex(rowIndex);
		CourseEditView courseEditView = new CourseEditView(repository, course, CrudAction.UPDATE);
		courseEditView.openDialog();
	}

	/**
	 * Handle updating table contents on repository action
	 * 
	 * @param courses List of updated courses from repository
	 */
	@Override
	protected void updateTable(List<Course> courses) {
		Object[][] dataVector = new Object[courses.size()][3];
		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			dataVector[i][0] = course.getTitle();
			dataVector[i][1] = course.getCourseType().getLiteral();
			if (course instanceof Advanced) {
				dataVector[i][2] = getPrereqsLabels((Advanced) course);
			} else {
				dataVector[i][2] = "";
			}
		}
		setDataVector(dataVector);
	}

	/**
	 * Get labels of the courses stored in the prereqs list of an advanced course.
	 * 
	 * @param advanced
	 * @return String containing a comma-separated list of course labels
	 */
	private String getPrereqsLabels(Advanced advanced) {
		StringBuilder courseNames = new StringBuilder();
		String prefix = "";
		for (Course prereq : advanced.getPrereqs()) {
			courseNames.append(prefix);
			prefix = ", ";
			courseNames.append(prereq.getTitle());
		}
		return courseNames.toString();
	}
}
