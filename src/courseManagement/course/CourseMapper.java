package courseManagement.course;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import courseManagement.Course;

public interface CourseMapper {
    
    Course selectCourseById(int id);
    
    List<Course> selectAllCourses();
    
    void insertCourse(Course course);
    
    void updateCourse(Course course);
    
    void insertCoursePrereq(@Param("courseId") int courseId, @Param("prereqId") int prereqId);
    
    void deleteCoursePrereq(@Param("courseId") int courseId, @Param("prereqId") int prereqId);
    
    List<Course> selectPrereqsByCourseId(int id);
    
    boolean coursePrereqExists(@Param("courseId") int courseId, @Param("prereqId") int prereqId);
    
    void deleteCoursePrereqsByCourseId(int id);
    
    void deleteCourse(int courseId);
    
}
