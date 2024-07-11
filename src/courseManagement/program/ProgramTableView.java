package courseManagement.program;

import java.util.List;

import courseManagement.Program;
import courseManagement.utils.TableView;

public class ProgramTableView extends TableView<Program> {

	protected ProgramTableView() {
		super(Program.class, "Programme", List.of("Name"));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onClickRowAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateTable(List<Program> entities) {
		// TODO Auto-generated method stub
		
	}
	
}
