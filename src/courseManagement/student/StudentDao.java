package courseManagement.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import courseManagement.Result;
import courseManagement.Student;
import courseManagement.utils.GenericDao;

public class StudentDao extends GenericDao<Student> {
	
	@Override
	public Student findById(int id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.selectStudent(id);
		}
	}
	
	@Override
	public List<Student> findAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.selectAllStudents();
		}
	}

	@Override
	public void insert(Student entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.insertStudent(entity);
			for (Result result : entity.getTranscript()) {
				studentMapper.insertResult(entity.getId(), result.getKey().getId(), result.getValue());
			}
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void update(Student entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.updateStudent(entity);
			studentMapper.deleteResults(entity.getId());
			for (Result result : entity.getTranscript()) {
				studentMapper.insertResult(entity.getId(), result.getKey().getId(), result.getValue());
			}
			session.commit();
			notifyObservers();
		}
	}

	@Override
	public void delete(Student entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.deleteStudent(entity);
			studentMapper.deleteResults(entity.getId());
			session.commit();
			notifyObservers();
		}
	}
}
