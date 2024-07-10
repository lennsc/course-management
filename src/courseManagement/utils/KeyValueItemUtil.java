package courseManagement.utils;

import java.util.Arrays;

import org.eclipse.emf.common.util.Enumerator;

public abstract class KeyValueItemUtil {
	
	/**
	 * Convert list of enum values to KeyValueItems.
	 * 
	 * @param <T> Enum must implement the Enumerator interface
	 * @param values Array of enum values
	 * @return Array of KeyValueItems
	 * @implNote Returned array can be directly inserted in JComboBox constructor
	 */
	public static <T extends Enumerator> KeyValueItem[] getKeyValueItems(T[] values) {
		return Arrays.asList(values).stream()
				.map(value -> new KeyValueItem(value.getName(), value.getLiteral())).toArray(KeyValueItem[]::new);
	}
}
