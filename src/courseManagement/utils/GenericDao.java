package courseManagement.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class GenericDao<T> implements DataAccess<T> {

	private Class<T> entityClass;
	private SqlSessionFactory sqlSessionFactory;
	private List<DaoObserver<T>> observers;

	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
		this.observers = new ArrayList<>();
	}

	/**
	 * Register observer. Observers are notified when an entity is inserted, updated
	 * or deleted.
	 * 
	 * @param observer
	 */
	public void addObserver(DaoObserver<T> observer) {
		observers.add(observer);
	}

	/**
	 * Unregister observer.
	 * 
	 * @param observer
	 */
	public void removeObserver(DaoObserver<T> observer) {
		observers.remove(observer);
	}

	public T findById(int id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(entityClass.getName() + ".findById", id);
		}
	}

	public List<T> findAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(entityClass.getName() + ".findAll");
		}
	}

	public void insert(T entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.insert(entityClass.getName() + ".insert", entity);
			session.commit();
			notifyInsertObservers(entity);
		}
	}

	public void update(T entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.update(entityClass.getName() + ".update", entity);
			session.commit();
			notifyUpdateObservers(entity);
		}
	}

	public void delete(T entity) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.delete(entityClass.getName() + ".delete", entity);
			session.commit();
			notifyDeleteObservers(entity);
		}
	}

	/**
	 * Notify observers that a new entity was added.
	 * 
	 * @param entity
	 */
	private void notifyInsertObservers(T entity) {
		for (DaoObserver<T> observer : observers) {
			observer.onEntityInserted(entity);
		}
	}

	/**
	 * Notify observers that an entity was updated.
	 * 
	 * @param entity
	 */
	private void notifyUpdateObservers(T entity) {
		for (DaoObserver<T> observer : observers) {
			observer.onEntityUpdated(entity);
		}
	}

	/**
	 * Notify observers that an entity was deleted.
	 * 
	 * @param entity
	 */
	private void notifyDeleteObservers(T entity) {
		for (DaoObserver<T> observer : observers) {
			observer.onEntityDeleted(entity);
		}
	}
}
