package courseManagement.utils;

public interface DaoObserver<T> {
	
	/**
	 * Called when a new entity was inserted by the DAO.
	 * @param entity
	 */
	void onEntityInserted(T entity);
	
	/**
	 * Called when an entity was updated by the DAO.
	 * @param entity
	 */
    void onEntityUpdated(T entity);
    
    /**
     * Called when an entity was deleted by the DAO.
     * @param entity
     */
    void onEntityDeleted(T entity);
}
