/**
 * WebBrowserRobotSetup is written for configuring Java Robot and calculating current offset
 * @author Taylor Wong
 */
package web.automation.core.browser;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Point;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import web.automation.core.debug.WebDebug;
import web.automation.core.exception.robot.RobotNotSupportedException;
import web.automation.core.tool.WebJavaScript;

public class WebBrowserRobot {

	private WebBrowser browser;
	private WebDebug debug;
	private int robotDelay;
	private Point extraOffset;	
	
	private static final int DEFAULT_SAFE_DELAY = 100;
	
	/**
	 * 
	 * @param browser The WebBrowser instance to access other methods
	 */
	public WebBrowserRobot(WebBrowser browser){
		this.browser = browser;
		debug = browser.debug();
		robotDelay = browser.getAutoProfile().getRobotDelay();
		checkRobotDelay();
		clearExtraOffset();
	}
	
	private void checkRobotDelay(){
		if(robotDelay < DEFAULT_SAFE_DELAY){
			debug.debugRobot("The current robot delay is lower than the default safe value 100.");
			debug.printSplitter(WebDebug.DEBUGROBOT);
		}
	}
	
	/**
	 * Initialize and return the Java Robot with auto delay
	 * @return java.awt.Robot with auto delay
	 * @throws AWTException 
	 * @throws Exception
	 */
	public Robot robot(){
		java.awt.Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(robotDelay);
			return robot;
		} catch (AWTException e) {
			throw new RobotNotSupportedException(e);
		}
	}
	
	/**
	 * Calculate and return the browser offset including browser window, frame, and scrolled page offsets
	 * @return The browser offset
	 * @throws Exception
	 */
	public Point robotOffset (){
		WebJavaScript js = new WebJavaScript(browser);
		Point scrolled = browser.getScrolledOffset();
		Point preScrolled = browser.frame().getScrolledOffset();
		int windowLocationX = js.windowLocationX();
		int windowLocationY = js.windowLocationY();
		debug.debugRobot("windowLocationX = "+windowLocationX);
		debug.debugRobot("windowLocationY = "+windowLocationY);
		debug.debugRobot("extraOffset = "+extraOffset.toString());
		int x = windowLocationX+browser.window().getOffset().getX()+browser.frame().getOffset().getX()+extraOffset.getX()-scrolled.getX()-preScrolled.getX();
		int y = windowLocationY+browser.window().getOffset().getY()+browser.frame().getOffset().getY()+extraOffset.getY()-scrolled.getY()-preScrolled.getY();
		Point offset = new Point(x,y);
		debug.debugRobot("robotOffset = "+offset);
		debug.printSplitter(WebDebug.DEBUGROBOT);
		return offset;
	}
	
	/**
	 * Return the default robot auto delay value
	 * @return The default robot auto delay value
	 */
	public int getRobotDelay(){
		return robotDelay;
	}
	
	/**
	 * Set the extra offset in addition to all the predefined and calculated offsets.
	 * @param x horizontal value
	 * @param y vertical value
	 */
	public void setExtraOffset(int x,int y){
		extraOffset = new Point(x,y);
	}
	
	public void setExtraOffset(Point offset){
		extraOffset = offset;
	}
	
	/**
	 * Set the extra offset to (0,0)
	 */
	public void clearExtraOffset(){
		extraOffset = new Point(0,0);
	}
	
	/**If old version of FireFox is used, there will be a status bar at the bottom of the browser when launching by Selenium
	 * Close before calculating the browser menubar
	**/
	@SuppressWarnings("unused")
	private void closeStatusBar4FF(){
		Actions actions = new Actions(browser.getWebDriver());
		actions.sendKeys(Keys.chord(Keys.CONTROL, "/")).keyUp( Keys.CONTROL ).build().perform();
	}
}
