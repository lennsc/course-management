package courseManagement.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import courseManagement.Identifiable;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public abstract class TableView<T extends Identifiable> extends View {

	protected GenericRepository<T> repository;
	protected JTable table;
	protected JButton addButton;
	private DefaultTableModel tableModel;
	private Object[] columnIdentifiers;

	/**
	 * Create a new table view.
	 * 
	 * @param entityClass  Entity to create the view for
	 * @param title        Title of the view
	 * @param tableColumns List of column names
	 */
	protected TableView(Class<T> entityClass, String title, List<String> tableColumns) {
		super(title);
		setLayout(new MigLayout("fill", "", "[grow][]"));

		table = new JTable();
		table.setShowGrid(true);
		columnIdentifiers = tableColumns.toArray();
		initializeTableModel();
		repository = new GenericRepository<T>(entityClass, this::updateTable);
		addButton = new JButton("Hinzufügen");
		
		add(new JScrollPane(table), "grow, wrap");
		add(addButton, "right");
	}

	/**
	 * Abstract method to handle row click action. Subclasses should implement this
	 * method to define the action.
	 */
	protected abstract void onClickRowAction();

	/**
	 * Abstract method to handle updating the contents of the table.
	 */
	protected abstract void updateTable(List<T> entities);

	/**
	 * Set the table content.
	 * 
	 * @param dataVector
	 */
	protected void setDataVector(Object[][] dataVector) {
		tableModel.setDataVector(dataVector, columnIdentifiers);
	}

	/**
	 * Initialize the table model.
	 * 
	 * @param onRowClickAction
	 */
	private void initializeTableModel() {
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(tableModel);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					onClickRowAction();
				}
			}
		});
	}
}
