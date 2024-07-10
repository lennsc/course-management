package courseManagement.utils;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public abstract class EditView extends View {

	protected JButton flowActionButton;
	protected JButton deleteButton;
	private JButton exitButton;
	private CrudAction crudAction;
	private FlowAction flowAction;

	/**
	 * Create a new details view.
	 * 
	 * @param title    Title of the view
	 * @param editMode Enum value indicating whether this view is used for creating
	 *                 or editing an entity (if used for creating an entity, the
	 *                 delete button is hidden)
	 */
	protected EditView(String title, CrudAction crudAction, FlowAction flowAction) {
		super(title);
		this.crudAction = crudAction;
		this.flowAction = flowAction;
		setLayout(new MigLayout("fillx, insets 10"));

		flowActionButton = new JButton(flowAction == FlowAction.NEXT ? "Weiter" : "Speichern");
		deleteButton = new JButton("Löschen");
		exitButton = new JButton("Abbrechen");

		exitButton.addActionListener(e -> close());
	}

	/**
	 * Close the window containing the view.
	 */
	protected void close() {
		Window window = SwingUtilities.getWindowAncestor(exitButton);
		if (window != null) {
			window.dispose();
		}
	}

	/**
	 * Add a label with standard top margin to the view.
	 * 
	 * @param text Text displayed in the label
	 */
	protected void addLabel(String text) {
		addLabel(text, false);
	}

	/**
	 * Add a label to the view.
	 * 
	 * @param text  Text displayed in the label.
	 * @param first Flag indicating whether this is the first label in the view (if
	 *              true, no top margin will be added)
	 */
	protected void addLabel(String text, boolean first) {
		if (first) {
			add(new JLabel(text), "wrap");
		} else {
			add(new JLabel(text), "gaptop 5, wrap");
		}
	}

	/**
	 * Add component to a row in the view. If another component is added after this
	 * component, it will be added in a new row.
	 * 
	 * @return component Component that is added to the view
	 */
	@Override
	public Component add(Component comp) {
		add(comp, "growx, wrap");
		return comp;
	}

	/**
	 * Adds a panel with buttons for save, exit and delete actions.
	 * 
	 * @implNote Call this method after adding any other components.
	 */
	protected void addActionButtons() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new MigLayout("fillx, insets 0"));
		if (crudAction == CrudAction.UPDATE && flowAction == FlowAction.SAVE) {
			buttonsPanel.add(deleteButton, "align left, sizegroup btn");
		}
		buttonsPanel.add(exitButton, "align right, split, sizegroup btn");
		buttonsPanel.add(flowActionButton, "align right, sizegroup btn");
		add(buttonsPanel, "gaptop 10, growx");
	}
}
