package courseManagement.program;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import courseManagement.Course;
import courseManagement.CourseManagementFactory;
import courseManagement.Program;
import courseManagement.course.CourseMapper;
import courseManagement.utils.GenericDao;

public class ProgramDao extends GenericDao<Program> {

	@Override
	public Program findById(int id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ProgramMapper mapper = session.getMapper(ProgramMapper.class);
			CourseMapper courseMapper = session.getMapper(CourseMapper.class);
			Program program = mapper.selectProgram(id);
			program.setCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
			program.setRequiredCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
			List<Integer> coursesIdList = mapper.selectAllCourses(id);
			for (int courseId : coursesIdList) {
				Course course = courseMapper.selectCourseById(courseId);
				program.getCourses().getElements().add(course);
			}
			List<Integer> requiredCoursesIdList = mapper.selectAllRequiredCourses(id);
			for (int courseId : requiredCoursesIdList) {
				Course course = courseMapper.selectCourseById(courseId);
				program.getRequiredCourses().getElements().add(course);
			}
			
			return program;
		}
	}

	@Override
	public List<Program> findAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ProgramMapper mapper = session.getMapper(ProgramMapper.class);
			CourseMapper courseMapper = session.getMapper(CourseMapper.class);
			List<Program> programs = mapper.selectAllPrograms();
			
			for (Program program : programs) {
				program.setCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
				program.setRequiredCourses(CourseManagementFactory.eINSTANCE.createCourseSet());
				List<Integer> coursesIdList = mapper.selectAllCourses(program.getId());
				for (int courseId : coursesIdList) {
					Course course = courseMapper.selectCourseById(courseId);
					program.getCourses().getElements().add(course);
				}
				List<Integer> requiredCoursesIdList = mapper.selectAllRequiredCourses(program.getId());
				for (int courseId : requiredCoursesIdList) {
					Course course = courseMapper.selectCourseById(courseId);
					program.getRequiredCourses().getElements().add(course);
				}
			}
			
			return mapper.selectAllPrograms();
		}
	}

	@Override
	public void insert(Program entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ProgramMapper mapper = session.getMapper(ProgramMapper.class);
			mapper.insertProgram(entity);
			
			for (Course course : entity.getCourses().getElements()) {
				mapper.insertCourse(entity.getId(), course.getId());
			}
			
			for (Course course : entity.getRequiredCourses().getElements()) {
				mapper.insertRequiredCourse(entity.getId(), course.getId());
			}
			
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void update(Program entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ProgramMapper mapper = session.getMapper(ProgramMapper.class);
			mapper.updateProgram(entity);
			
			mapper.deleteCourses(entity.getId());
			mapper.deleteRequiredCourses(entity.getId());
			
			for (Course course : entity.getCourses().getElements()) {
				mapper.insertCourse(entity.getId(), course.getId());
			}
			
			for (Course course : entity.getRequiredCourses().getElements()) {
				mapper.insertRequiredCourse(entity.getId(), course.getId());
			}
			
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void delete(Program entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ProgramMapper mapper = session.getMapper(ProgramMapper.class);
			mapper.deleteProgram(entity.getId());
			mapper.deleteCourses(entity.getId());
			mapper.deleteRequiredCourses(entity.getId());
			session.commit();
			notifyObservers();
		}		
	}
}
