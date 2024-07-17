package courseManagement.utils;

public record IdValueItem(int id, String value) {
	@Override
	public final String toString() {
		return value;
	}
}

