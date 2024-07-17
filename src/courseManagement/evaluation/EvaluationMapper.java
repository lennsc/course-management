package courseManagement.evaluation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import courseManagement.Evaluation;
import courseManagement.Grade;

public interface EvaluationMapper {
	
	List<Evaluation> selectAllEvaluations();
	
	Evaluation selectEvaluation(int id);
	
	void insertEvaluation(@Param("studentId") int studentId, @Param("courseId") int courseId, @Param("value") Grade value);
	
	void updateEvaluation(@Param("id") int id, @Param("studentId") int studentId, @Param("courseId") int courseId, @Param("value") Grade value);
	
	void deleteEvaluation(int id);
	
}
