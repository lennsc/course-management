package courseManagement.course;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.utils.GenericDao;

public class CourseDao extends GenericDao<Course> {

    @Override
    public Course findById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            return mapper.selectCourseById(id);
        }
    }

    @Override
    public List<Course> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            return mapper.selectAllCourses();
        }
    }

    @Override
    public void insert(Course entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            insertCourseWithPrereqs(mapper, entity);
            session.commit();
            notifyObservers();
        }
    }
    
    private void insertCourseWithPrereqs(CourseMapper mapper, Course course) {
        if (course.getId() == 0) {
            mapper.insertCourse(course);
        }

        if (course instanceof Advanced) {
            Advanced advancedCourse = (Advanced) course;
            for (Course prereq : advancedCourse.getPrereqs()) {
                if (prereq.getId() == 0) {
                    mapper.insertCourse(prereq);
                }
                if (!mapper.coursePrereqExists(course.getId(), prereq.getId())) {
                    mapper.insertCoursePrereq(course.getId(), prereq.getId());
                }
            }
        }
    }

    @Override
    public void update(Course entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            mapper.updateCourse(entity);

            if (entity instanceof Advanced) {
                mapper.deleteCoursePrereqsByCourseId(entity.getId());
                Advanced advancedCourse = (Advanced) entity;
                for (Course prereq : advancedCourse.getPrereqs()) {
                    if (!mapper.coursePrereqExists(advancedCourse.getId(), prereq.getId())) {
                        mapper.insertCoursePrereq(advancedCourse.getId(), prereq.getId());
                    }
                }
            }

            session.commit();
            notifyObservers();
        }
    }

    @Override
    public void delete(Course entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            mapper.deleteCoursePrereqsByCourseId(entity.getId());
            mapper.deleteCourse(entity.getId());
            session.commit();
            notifyObservers();
        }
    }
}
