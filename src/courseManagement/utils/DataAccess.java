package courseManagement.utils;

import java.util.List;

public interface DataAccess<T> {
	
	/**
	 * Find the entity associated with the given id.
	 * @param id
	 * @return Entity instance
	 */
	public T findById(int id);
	
	/**
	 * Find all entities of the given type.
	 * @return List of entity instances
	 */
	public List<T> findAll();
	
	/**
	 * Insert entity into store.
	 * @param entity
	 */
	public void insert(T entity);
	
	/**
	 * Update entity in store.
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * Delete entity in store.
	 * @param entity
	 */
	public void delete(T entity);
	
}
