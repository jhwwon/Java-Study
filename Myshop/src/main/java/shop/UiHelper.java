package shop;

import jakarta.servlet.http.HttpServletRequest; 

public class UiHelper {
	// 공용변수 
	public static final String FLASH_KEY = "__flash";

	// 리턴 메서드 
	public static String flash(HttpServletRequest req) {
		Object msg = req.getAttribute(FLASH_KEY);
		return (msg == null) ? "" : ("<div class='flash'>" + msg + "</div>");
	}
}
