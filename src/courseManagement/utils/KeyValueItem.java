package courseManagement.utils;

public record KeyValueItem(String key, String value) {
	@Override
	public final String toString() {
		return value;
	}
}
