package courseManagement.utils;

public interface DataWriteAccess<T> {
	
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
