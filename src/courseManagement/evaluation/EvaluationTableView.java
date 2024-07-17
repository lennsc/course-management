package courseManagement.evaluation;

import java.util.List;

import courseManagement.CourseManagementFactory;
import courseManagement.Evaluation;
import courseManagement.utils.CrudAction;
import courseManagement.utils.TableView;

@SuppressWarnings("serial")
public class EvaluationTableView extends TableView<Evaluation> {

	public EvaluationTableView() {
		super(new EvaluationDao(), "Kursbewertungen", List.of("Student", "Kurs", "Bewertung"));
		
		addButton.addActionListener(e -> {
			Evaluation evaluation = CourseManagementFactory.eINSTANCE.createEvaluation();
			EvaluationEditView view = new EvaluationEditView(repository, evaluation, CrudAction.CREATE);
			view.openDialog();
		});
	}

	@Override
	protected void onClickRowAction() {
		int rowIndex = table.getSelectedRow();
		Evaluation evaluation = repository.findByIndex(rowIndex);
		EvaluationEditView view = new EvaluationEditView(repository, evaluation, CrudAction.UPDATE);
		view.openDialog();
	}

	@Override
	protected void updateTable(List<Evaluation> entities) {
		Object[][] dataVector = new Object[entities.size()][3];
		for (int i = 0; i < entities.size(); i++) {
			Evaluation evaluation = entities.get(i);
			dataVector[i][0] = evaluation.getStudent().getName();
			dataVector[i][1] = evaluation.getCourse().getTitle();
			dataVector[i][2] = evaluation.getValue().getLiteral();
		}
		setDataVector(dataVector);
	}
}
