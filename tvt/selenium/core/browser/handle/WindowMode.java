package tvt.selenium.core.browser.handle;

public interface WindowMode {

	/**
	 * Window is maximized or max bounded.
	 */
	public static String MAX = "WIN_MAX";
	
	/**
	 * The window is at point (0,0) but not maximized or max bounded .
	 */
	public static String ORIGIN = "WIN_ORIGIN";
	
	/**
	 * The window is not at point (0,0).
	 */
	public static String NON_ORIGIN = "WIN_NON_ORIGIN";
}
