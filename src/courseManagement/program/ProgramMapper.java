package courseManagement.program;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import courseManagement.Program;

public interface ProgramMapper {

	List<Program> selectAllPrograms();
	
	Program selectProgram(int id);
	
	List<Integer> selectAllCourses(int programId);
	
	List<Integer> selectAllRequiredCourses(int programId);
	
	void insertProgram(Program program);
	
	void insertCourse(@Param("programId") int programId, @Param("courseId") int courseId);
	
	void insertRequiredCourse(@Param("programId") int programId, @Param("courseId") int courseId);
	
	void updateProgram(Program program);
	
	void deleteProgram(int id);
	
	void deleteCourses(int programId);
	
	void deleteRequiredCourses(int programId);
	
}
