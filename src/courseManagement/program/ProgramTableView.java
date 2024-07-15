package courseManagement.program;

import java.util.List;

import courseManagement.CourseManagementFactory;
import courseManagement.Program;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class ProgramTableView extends TableView<Program>{

	public ProgramTableView() {
		super(Program.class, "Program", List.of("Label", "Courseset"));
		
		addButton.addActionListener(e -> {
		    Program program = CourseManagementFactory.eINSTANCE.createProgram();
		    ProgramEditView programEditView = new ProgramEditView(repository, program, CrudAction.CREATE);
		    programEditView.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Program program = repository.findByIndex(rowIndex);
		ProgramEditView programDetailsView = new ProgramEditView(repository, program, CrudAction.CREATE);
		programDetailsView.openDialog();
	}

	@Override
	protected void updateTable(List<Program> programs) {
		Object[][] dataVector = new Object[programs.size()][2];
		for (int i = 0; i < programs.size(); i++) {
			Program program = programs.get(i);
			dataVector[i][0] = program.getLabel();
			dataVector[i][1] = program.getCourses();
		}
		setDataVector(dataVector);
		
	}

}
