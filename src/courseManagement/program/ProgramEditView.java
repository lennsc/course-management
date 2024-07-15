package courseManagement.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseSet;
import courseManagement.CourseType;
import courseManagement.Introductory;
import courseManagement.Program;
import courseManagement.Student;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericDao;
import courseManagement.utils.GenericRepository;
import courseManagement.utils.KeyValueItem;

@SuppressWarnings("serial")
public class ProgramEditView extends EditView{
	private JTextField labelField;
	private JComboBox<Program> programComboBox;
	private CheckboxPanel<Course> courseCheckboxPanel;
	private GenericRepository<Program> repository;
	private Program program;
	private CrudAction crudAction;

	public ProgramEditView(GenericRepository<Program> repository, Program program, CrudAction crudAction) {
		super("Programm " + (crudAction == CrudAction.CREATE ? "hinzufügen" : "bearbeiten"), crudAction, FlowAction.SAVE);
		this.repository = repository;
		this.program = program;
		this.crudAction = crudAction;
		GenericDao<Course> courseDao = new GenericDao<>(Course.class);
		
		labelField = new JTextField(program.getLabel());
		courseCheckboxPanel = new CheckboxPanel<>(courseDao.findAll());
		
		addLabel("Name", true);
		add(labelField);
		addLabel("Kurse");
		add(courseCheckboxPanel);
		
		addActionButtons();
	}
	
	/**
	 * Get all dependencies for given courses by iterating over all courses and
	 * collecting their dependencies.
	 * 
	 * @param selectedCourses List of selected courses
	 * @return List of dependencies
	 */
	private List<Course> getAllCourseDependencies(List<Course> selectedCourses) {
		List<Course> allDependencies = new ArrayList<>();
		Set<Course> visitedCourses = new HashSet<>();

		for (Course course : selectedCourses) {
			collectDependencies(course, allDependencies, visitedCourses);
		}

		return allDependencies;
	}
	
	/**
	 * Collect direct and transitive dependencies for given course.
	 * 
	 * @param course
	 * @param allDependencies Reference to list containing all found dependencies
	 * @param visitedCourses  Set containing all courses which have already been
	 *                        processed
	 */
	private void collectDependencies(Course course, List<Course> allDependencies, Set<Course> visitedCourses) {
		if (visitedCourses.contains(course)) {
			return;
		}

		visitedCourses.add(course);

		if (!allDependencies.contains(course)) {
			allDependencies.add(course);
		}

		if (course instanceof Advanced) {
			Advanced advancedCourse = (Advanced) course;
			for (Course prereq : advancedCourse.getPrereqs()) {
				collectDependencies(prereq, allDependencies, visitedCourses);
			}
		}
	}
	
	private List<Program> getExamplePrograms() {
		Program sem1 = CourseManagementFactory.eINSTANCE.createProgram();
		sem1.setId(1);
		sem1.setLabel("Semester 1");
		sem1.setCourses(null);
		
		return new ArrayList<>(List.of(sem1));
		}
	
	
	
}


