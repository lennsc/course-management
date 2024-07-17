package courseManagement.student;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import courseManagement.Grade;
import courseManagement.Student;

public interface StudentMapper {
	
	Student selectStudent(int id);
	
	List<Student> selectAllStudents();
	
	@Insert("INSERT INTO Student (Name, Semester) VALUES (#{name}, #{semester})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insertStudent(Student student);
	
	void insertResult(@Param("studentId") int studentId, @Param("courseId") int courseId, @Param("value") Grade value);
	
	@Update("UPDATE Student SET Name=#{name}, Semester=#{semester} WHERE Id=#{id}")
	void updateStudent(Student student);
	
	@Delete("DELETE FROM Student WHERE Id=#{id}")
	void deleteStudent(Student student);
	
	void deleteResults(int studentId);
}
