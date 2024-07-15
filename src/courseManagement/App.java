package courseManagement;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.formdev.flatlaf.FlatLightLaf;

import courseManagement.course.CourseTableView;
import courseManagement.program.ProgramTableView;
import courseManagement.students.StudentTableView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class App {

	public static App INSTANCE;
	private static final String WINDOW_TITLE = "Course Management";
	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FlatLightLaf.setup();
				INSTANCE = new App();
				INSTANCE.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application layout and show students view.
	 */
	private App() {
		frame = new JFrame();
		frame.setTitle(WINDOW_TITLE);
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu masterDataMenu = new JMenu("Stammdaten");
		menuBar.add(masterDataMenu);

		StudentTableView studentsTableView = new StudentTableView();
		JMenuItem studentsMenuItem = new JMenuItem("Studenten");
		studentsMenuItem.addActionListener(action -> studentsTableView.open());
		masterDataMenu.add(studentsMenuItem);
		
		ProgramTableView programTableView = new ProgramTableView();
		JMenuItem programMenuItem = new JMenuItem("Programme");
		programMenuItem.addActionListener(action -> programTableView.open());
		masterDataMenu.add(programMenuItem);
		
		CourseTableView courseTableView = new CourseTableView();
		JMenuItem coursesMenuItem = new JMenuItem("Kurse");
		coursesMenuItem.addActionListener(action -> courseTableView.open());
		masterDataMenu.add(coursesMenuItem);

		courseTableView.open(this);
		
	}

	/**
	 * Set the title of the application window.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		frame.setTitle(title + " - " + WINDOW_TITLE);
	}

	/**
	 * Set the content panel of the frame.
	 * 
	 * @param panel
	 */
	public void setContent(JPanel panel) {
		frame.setContentPane(panel);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * Open a modal dialog centered above the main application window.
	 * 
	 * @param dialog
	 */
	public void openDialog(JDialog dialog) {
		dialog.setLocationRelativeTo(frame);
		dialog.setResizable(false);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
}
