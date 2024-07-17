package courseManagement.utils;

public interface DaoObserver<T> {
	
	/**
	 * Called when the database was changed
	 */
	void onChange();
}
