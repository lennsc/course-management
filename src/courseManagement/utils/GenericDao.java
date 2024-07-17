package courseManagement.utils;

import org.apache.ibatis.session.SqlSessionFactory;

public abstract class GenericDao<T> extends Observable<T> implements DataReadAccess<T>, DataWriteAccess<T> {

	protected SqlSessionFactory sqlSessionFactory;

	public GenericDao() {
		this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
	}
	
	/**
	 * Notify observers that database was changed.
	 */
	protected void notifyObservers() {
		for (DaoObserver<T> observer : observers) {
			observer.onChange();
		}
	}
}
