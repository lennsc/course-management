package courseManagement.evaluation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import courseManagement.Evaluation;
import courseManagement.utils.GenericDao;

public class EvaluationDao extends GenericDao<Evaluation> {

	@Override
	public Evaluation findById(int id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EvaluationMapper mapper = session.getMapper(EvaluationMapper.class);
			return mapper.selectEvaluation(id);
		}
	}

	@Override
	public List<Evaluation> findAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EvaluationMapper mapper = session.getMapper(EvaluationMapper.class);
			return mapper.selectAllEvaluations();
		}
	}

	@Override
	public void insert(Evaluation entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EvaluationMapper mapper = session.getMapper(EvaluationMapper.class);
			mapper.insertEvaluation(entity.getStudent().getId(), entity.getCourse().getId(), entity.getValue());
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void update(Evaluation entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EvaluationMapper mapper = session.getMapper(EvaluationMapper.class);
			mapper.updateEvaluation(entity.getId(), entity.getStudent().getId(), entity.getCourse().getId(), entity.getValue());
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void delete(Evaluation entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			EvaluationMapper mapper = session.getMapper(EvaluationMapper.class);
			mapper.deleteEvaluation(entity.getId());
			session.commit();
			notifyObservers();
		}
	}
}
