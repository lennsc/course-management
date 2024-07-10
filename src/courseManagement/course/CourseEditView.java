package courseManagement.course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTextField;
import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseType;
import courseManagement.Introductory;
import courseManagement.utils.CheckboxPanel;
import courseManagement.utils.CrudAction;
import courseManagement.utils.EditView;
import courseManagement.utils.FlowAction;
import courseManagement.utils.GenericRepository;

@SuppressWarnings("serial")
public class CourseEditView extends EditView {

	private JTextField labelField;
	private CheckboxPanel<Course> prereqsCheckboxPanel;
	private GenericRepository<Course> repository;
	private Course course;
	private CrudAction crudAction;
	private List<Course> exampleCourses;

	/**
	 * Create a new course edit view.
	 * 
	 * @param repository Reference to repository from course table view
	 * @param course
	 * @param crudAction
	 */
	public CourseEditView(GenericRepository<Course> repository, Course course, CrudAction crudAction) {
		super("Kurs " + (crudAction == CrudAction.CREATE ? "hinzufügen" : "bearbeiten") + " ("
				+ course.getCourseType().getLiteral() + ")", crudAction, FlowAction.SAVE);
		this.repository = repository;
		exampleCourses = getExampleCourses();
		this.course = course;
		this.crudAction = crudAction;

		labelField = new JTextField(course.getLabel());
		prereqsCheckboxPanel = new CheckboxPanel<>(exampleCourses);
		addLabel("Name", true);
		add(labelField);

		if (course instanceof Advanced) {
			List<Course> prereqs = ((Advanced) course).getPrereqs();
			prereqsCheckboxPanel.setSelectedOptions(getAllCourseDependencies(prereqs));
			addLabel("Voraussetzungen");
			add(prereqsCheckboxPanel);
		}

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

	/**
	 * Create a hierarchy of example courses.
	 * 
	 * @return List of example courses
	 */
	private List<Course> getExampleCourses() {
		Introductory ma1 = CourseManagementFactory.eINSTANCE.createIntroductory();
		ma1.setId(1);
		ma1.setTitle("Mathematik 1");
		ma1.setCourseType(CourseType.INTRODUCTORY);

		Introductory uf1 = CourseManagementFactory.eINSTANCE.createIntroductory();
		uf1.setId(2);
		uf1.setTitle("Grundlagen der Unternehmensführung 1");
		uf1.setCourseType(CourseType.INTRODUCTORY);

		Advanced ma2 = CourseManagementFactory.eINSTANCE.createAdvanced();
		ma2.setId(3);
		ma2.setTitle("Mathematik 2");
		ma2.setCourseType(CourseType.ADVANCED);
		ma2.getPrereqs().add(ma1);

		Advanced ma3 = CourseManagementFactory.eINSTANCE.createAdvanced();
		ma3.setId(4);
		ma3.setTitle("Mathematik 3");
		ma3.setCourseType(CourseType.ADVANCED);
		ma3.getPrereqs().add(ma2);

		return new ArrayList<>(List.of(ma1, uf1, ma2, ma3));
	}
}
