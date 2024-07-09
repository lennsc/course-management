package courseManagement.utils;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import courseManagement.Identifiable;

public class GenericRepository<T extends Identifiable> implements DataAccess<T> {

	private GenericDao<T> genericDao;
	private List<T> entities;

	/**
	 * Initialize repository and view (by running the update method).
	 * 
	 * @param entityClass
	 * @param update
	 */
	public GenericRepository(Class<T> entityClass, Consumer<List<T>> updateConsumer) {
		genericDao = new GenericDao<T>(entityClass);
		entities = Collections.synchronizedList(genericDao.findAll());
		
		updateConsumer.accept(entities);

		genericDao.addObserver(new DaoObserver<T>() {

			@Override
			public void onEntityInserted(T entity) {
				entities.add(entity);
				updateConsumer.accept(entities);
			}

			@Override
			public void onEntityUpdated(T entity) {
				for (int i = 0; i < entities.size(); i++) {
					T currentEntity = entities.get(i);
					if (currentEntity.getId() == entity.getId()) {
						entities.set(i, entity);
						break;
					}
				}
				updateConsumer.accept(entities);
			}

			@Override
			public void onEntityDeleted(T entity) {
				for (int i = 0; i < entities.size(); i++) {
					T currentEntity = entities.get(i);
					if (currentEntity.getId() == entity.getId()) {
						entities.remove(i);
						break;
					}
				}
				updateConsumer.accept(entities);
			}
		});
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
