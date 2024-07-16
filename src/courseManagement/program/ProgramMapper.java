package courseManagement.program;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import courseManagement.Program;

public interface ProgramMapper {
	@Select("SELECT * FROM Program WHERE Id =#{id}")
	Program selectProgram(int id);
	
	@Select("SELECT * FROM Program")
	List<Program> selectAllPrograms();
	
	@Select("INSERT INTO Program (Label, Courseset) VALUES (# {label}, #{courseset})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insertProgram(Program program);
	
	@Update("UPDATE Program SET Label=#{label}, Courseset = #{courseset} WHERE id = #{id}")
	void updateProgram(Program program);
	
	@Delete("DELETE FROM Program WHERE Id=#{id}")
	void deleteProgram(Program program);
}
