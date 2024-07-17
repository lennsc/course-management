package courseManagement.program;

import java.util.List;

import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseSet;
import courseManagement.Program;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class ProgramTableView extends TableView<Program> {

	public ProgramTableView() {
		super(new ProgramDao(), "Programme", List.of("Name", "Pflichtkurse", "Wahlkurse"));
		
		addButton.addActionListener(e -> {
			Program program = CourseManagementFactory.eINSTANCE.createProgram();
			program.setCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
			program.setRequiredCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
			ProgramEditView view = new ProgramEditView(repository, program, CrudAction.CREATE);
			view.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Program selectedProgram = repository.findByIndex(rowIndex);
		ProgramEditView view = new ProgramEditView(repository, selectedProgram, CrudAction.UPDATE);
		view.openDialog();
	}

	@Override
	protected void updateTable(List<Program> entities) {
		Object[][] dataVector = new Object[entities.size()][3];
		for (int i = 0; i < entities.size(); i++) {
			Program program = entities.get(i);
			dataVector[i][0] = program.getLabel();
			dataVector[i][1] = getCourseTitles(program.getRequiredCourses());
			dataVector[i][2] = getCourseTitles(program.getCourses());
		}
		setDataVector(dataVector);
	}
	
	/**
	 * Get labels of the courses stored in a course set.
	 * 
	 * @param advanced
	 * @return String containing a comma-separated list of course labels
	 */
	private String getCourseTitles(CourseSet courseSet) {
		StringBuilder courseNames = new StringBuilder();
		String prefix = "";
		for (Course course : courseSet.getElements()) {
			courseNames.append(prefix);
			prefix = ", ";
			courseNames.append(course.getTitle());
		}
		return courseNames.toString();
	}
}
