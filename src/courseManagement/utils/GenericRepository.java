package courseManagement.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import courseManagement.Identifiable;

public class GenericRepository<T extends Identifiable> implements DataReadAccess<T>, DataWriteAccess<T> {

	private GenericDao<T> genericDao;
	private List<T> entities;
	private boolean initialized;

	/**
	 * Initialize repository and view (by running the update method) with a custom
	 * DAO.
	 * 
	 * @param customDao
	 * @param updateConsumer
	 */
	public GenericRepository(GenericDao<T> customDao) {
		this.genericDao = customDao;
		initialized = false;
	}

	/**
	 * Common method to initialize repository and register observer for update
	 * consumer.
	 * 
	 * @param updateConsumer
	 */
	public void initializeRepository(Consumer<List<T>> updateConsumer) {
		if (!initialized) {
			entities = new ArrayList<>(genericDao.findAll());
			updateConsumer.accept(entities);
			
			genericDao.addObserver(new DaoObserver<T>() {
				@Override
				public void onChange() {
					entities = new ArrayList<>(genericDao.findAll());
					updateConsumer.accept(entities);
				}
			});
			
			initialized = true;
		} else {
			throw new UnsupportedOperationException("The repository is already initialized.");
		}
	}

	@Override
	public T findById(int id) {
		return genericDao.findById(id);
	}

	/**
	 * Find entity by index in repository store.
	 * 
	 * @param index
	 * @return entity
	 */
	public T findByIndex(int index) {
		return findById(entities.get(index).getId());
	}

	@Override
	public List<T> findAll() {
		return genericDao.findAll();
	}

	@Override
	public void insert(T entity) {
		genericDao.insert(entity);
	}

	@Override
	public void update(T entity) {
		genericDao.update(entity);
	}

	@Override
	public void delete(T entity) {
		genericDao.delete(entity);
	}
}
