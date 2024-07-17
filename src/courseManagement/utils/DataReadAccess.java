package courseManagement.utils;

import java.util.List;

public interface DataReadAccess<T> {

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
}
