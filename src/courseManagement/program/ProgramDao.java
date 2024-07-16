package courseManagement.program;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import courseManagement.Program;
import courseManagement.utils.GenericDao;

public class ProgramDao extends GenericDao<Program> {
	@Override
	public Program findById(int id) {
		try(SqlSession session = SqlSession.openSession()){
			ProgramMapper programMapper = session.getMapper(ProgramMapper.class);
			return programMapper.selectProgram(id);
		}
	}
	
	@Override
	public List<Program> findAll(){
		try(SqlSession session = SqlSession.openSession()){
			ProgramMapper programMapper = session.getMapper(ProgramMapper.class);
			return programMapper.selectAllPrograms();
		}
	}
	
	@Override
	public void insert(Program entity) {
		try(SqlSession session = SqlSession.openSession()){
			ProgramMapper programMapper = session.getMapper(ProgramMapper.class);
			programMapper.insertProgram(entity);
			session.commit();
			notifyInsertObservers(entity);
		}
	}
	
	@Override
	public void update(Program entity) {
		try(SqlSession session = SqlSession.openSessio()){
			ProgramMapper programMapper = session.getMapper(ProgramMapper.class);
			programMapper.updateProgram(entity);
			notifyUpdateObservers(entity);
		}
	}
	
	@Override
	public void delete(Program entity) {
		try(SqlSession session = SqlSession.openSession()){
			ProgramMapper programMapper = session.getMapper(ProgramMapper.class);
			programMapper.deleteProgram(entity);
			session.commit();
			notifyDeleteObservers(entity);
		}
	}
	
}
