package shop;

public class ValidationUtil {
	public static boolean isNullOrBlank(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static int toIntOrDefault(String s, int def) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return def;
		}
	}
}