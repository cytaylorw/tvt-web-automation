/**
 * Java Robot action to be performed with no target WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.browser.action;

import java.awt.Robot;

import org.openqa.selenium.Keys;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.tool.WebRobot;

public class BrowserActionByRobot {

	private WebBrowser browser;
	
	public BrowserActionByRobot(WebBrowser tvtWebBrowser) {
		browser=tvtWebBrowser;
	}

	/**
	 * Send a single key with Java Robot.
	 * @param key Please see org.openqa.selenium.Keys.
	 */
	public BrowserActionByRobot key(Keys key){
		Robot robot = browser.robotSetup().robot();
		WebRobot.robotKey(robot, key);
		return this;
	}
	
	/**
	 * Send the hotkey with Java Robot.
	 * @param key The character to be pressed.
	 * @param mod Modifier key. Please see org.openqa.selenium.Keys.
	 */
	public BrowserActionByRobot hotKey(char key,Keys... mod){
		Robot robot = browser.robotSetup().robot();
		WebRobot.robotHotKey(robot,key,mod);
		return this;
	}
	
	/**
	 * Send keys with Java Robot.
	 * @param characters characters to be sent.
	 */
	public BrowserActionByRobot sendKeys(CharSequence characters){
		Robot robot = browser.robotSetup().robot();
		int length = characters.length();
        for (int i = 0; i < length; i++) {
        	if (i == 1) robot.setAutoDelay(browser.robotSetup().getRobotDelay()/2);
            char character = characters.charAt(i);
            WebRobot.robotType(robot,character);
        }
        return this;
	}
	
	/**
	 * Move the mouse to the coordinate with Java Robot.
	 * @param x horizontal coordinate.
	 * @param y vertical coordinate.
	 */
	public BrowserActionByRobot move(int x, int y){
		browser.debug().debugRobot("Robot move mouse at ("+x+","+y+")");
		browser.debug().printSplitter(WebDebug.DEBUGROBOT);
		browser.robotSetup().robot().mouseMove(x,y);
		return this;
	}
}
