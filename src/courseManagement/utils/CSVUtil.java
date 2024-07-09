package courseManagement.utils;

import java.util.ArrayList;
import java.util.List;

import courseManagement.Identifiable;

public abstract class CSVUtil {

	/**
	 * Converts a list of items providing a getId()-Method to a comma-separated
	 * string containing the id values.
	 * 
	 * @param <T>   Item type
	 * @param items List of items
	 * @return String containing the id values.
	 */
	public static <T extends Identifiable> String listToCsvRow(List<T> items) {
		StringBuilder stringBuilder = new StringBuilder();
		String prefix = "";
		for (T item : items) {
			stringBuilder.append(prefix);
			prefix = ",";
			stringBuilder.append(item.getId());
		}
		return stringBuilder.toString();
	}

	/**
	 * Converts a string created with listToCsvRow back to a list of items.
	 * 
	 * @param <T>       Item type
	 * @param itemClass Item class
	 * @param csv       String produced by listToCsvRow
	 * @return List of items
	 */
	public static <T> List<T> csvRowToList(Class<T> itemClass, String csv) {
		String[] idList = csv.split(",");
		List<T> items = new ArrayList<>();
		GenericDao<T> genericDao = new GenericDao<T>(itemClass);

		for (String idString : idList) {
			int id = Integer.parseInt(idString);
			T item = genericDao.findById(id);
			items.add(item);
		}
		
		return items;
	}
}
