package courseManagement.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
	
	protected List<DaoObserver<T>> observers;
	
	public Observable() {
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
}
