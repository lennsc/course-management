package courseManagement.utils;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;

import courseManagement.App;

@SuppressWarnings("serial")
public abstract class View extends JPanel {

	private String title;

	/**
	 * Create a new view.
	 * 
	 * @param title Title of the view
	 */
	protected View(String title) {
		this.title = title;
	}

	/**
	 * Open the view inside the main application window.
	 */
	public void open() {
		open(App.INSTANCE);
	}

	/**
	 * Open the view inside the main application window.
	 * 
	 * @param app Application instance
	 * @implNote Use this in the initial view setup to avoid loading delay.
	 */
	public void open(App app) {
		app.setTitle(title);
		app.setContent(this);
	}

	/**
	 * Open the view inside a new dialog with standard minimum size.
	 */
	public void openDialog() {
		openDialog(400, 0);
	}

	/**
	 * Open the view inside a new dialog with custom minimum size.
	 * 
	 * @param minimumWidth
	 * @param minimumHeight
	 */
	public void openDialog(int minimumWidth, int minimumHeight) {
		JDialog dialog = new JDialog();

		dialog.setTitle(title);
		dialog.setMinimumSize(new Dimension(minimumWidth, minimumHeight));
		dialog.add(this);
		dialog.pack();

		App.INSTANCE.openDialog(dialog);
	}
}
