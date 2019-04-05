/**
 * Java Robot Action on a WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.element.action;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.robot.BrowseFileByRobotException;
import tvt.selenium.core.tool.WebImage;

public class ElementActionByRobot{

	private BrowserElement element;
	private WebBrowser browser;
	private Point offset;
	private int delay;
	
	public ElementActionByRobot(WebBrowser browser,BrowserElement element,int time) {
		this.browser = browser;
		this.element = element;
		browser.debug().debugRobot("Robot actions");
		offset = browser.robotSetup().robotOffset();
		delay = time;
	}
	
	/**
	 * Move to the current {@link BrowserElement} with offset from upper-left corner of the WebElement with Java Robot. The final location has to be in the viewport.
	 * @param offsetX The X coordinate from upper-left corner of the WebElement.
	 * @param offsetY The Y coordinate from upper-left corner of the WebElement.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement move(int offsetX,int offsetY){
		Point point = element.getLocation();
		
		element.delay(delay).waitFor().displayed();
		browser.actionsByRobot().move(point.x+browser.robotSetup().robotOffset().getX()+offsetX, 
				point.y+browser.robotSetup().robotOffset().getY()+offsetY);
		return element;
	}
	
	/**
	 * Move to the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement move(){
		Point point = element.getLocation();
		int height=element.getSize().getHeight()/2;
		int width=element.getSize().getWidth()/2;
		
		element.delay(delay).waitFor().displayed();
		browser.actionsByRobot().move(point.getX()+offset.getX()+width, point.getY()+offset.getY()+height);
		return element;
	}
	
	/**
	 * Click on the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement click(){
		Robot robot = browser.robotSetup().robot();
		Point point = element.getLocation();
		int height=element.getSize().getHeight()/2;
		int width=element.getSize().getWidth()/2;
		
		element.delay(delay).waitFor().enabled();
		browser.actionsByRobot().move(point.x+offset.getX()+width, point.y+offset.getY()+height);
		robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(0, 0);
        return element;
	}

	/**
	 * Double click on the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement doubleClick(){
		Robot robot = browser.robotSetup().robot();
		Point point = element.getLocation();
    
		int height=element.getSize().getHeight()/2;
		int width=element.getSize().getWidth()/2;
		
		element.delay(delay).waitFor().enabled();
		browser.actionsByRobot().move(point.getX()+offset.getX()+width, point.getY()+offset.getY()+height);
		robot.setAutoDelay(browser.robotSetup().getRobotDelay()/3);
		robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(0, 0);
        return element;
	}
	
	/**
	 * Context click on the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement contextClick(){
		Robot robot = browser.robotSetup().robot();
		Point point = element.getLocation();
    
		int height=element.getSize().getHeight()/2;
		int width=element.getSize().getWidth()/2;
		
		element.delay(delay).waitFor().enabled();
		browser.actionsByRobot().move(point.getX()+offset.getX()+width, point.getY()+offset.getY()+height);
		robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseMove(0, 0);
        return element;
	}
	
	/**
	 * Click and send keys to the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @param characters The keys to send.
	 * @throws Exception
	 */
	public BrowserElement sendKeys(CharSequence characters){
		click();
		element.delay(delay).waitFor().enabled();
		browser.actionsByRobot().sendKeys(characters);	
		return element;
	}
	
	/**
	 * Click on the current {@link BrowserElement}(browse button) to open the browse window then type and open the file with Java Robot. The WebElement has to be in the viewport.
	 * @param file The full path for the file.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement browseFile(String file){
		int delay = browser.robotSetup().getRobotDelay();
		int i = browser.getTVTProfile().getWaitTime()/(delay*10);
		click();
		element.delay(delay*20);
		browser.actionsByRobot().sendKeys(file);
		element.delay(delay*20);
		BufferedImage dialog = browser.screen().bufferedImageByRobot().takeFullScreen().subImage(browser.window().getUploadFile()).getImage();
		while(WebImage.compareImage(dialog,browser.screen().bufferedImageByRobot().takeFullScreen().subImage(browser.window().getUploadFile()).getImage())){
			browser.actionsByRobot().hotKey('o',Keys.ALT);
			element.delay(delay*10);
			i--;
			if(i==0)throw new BrowseFileByRobotException(browser,"Failed to browser file by Java Robot.");
		}
		return element;
	}

	/**
	 * Hold Ctrl key and click on the current {@link BrowserElement} with Java Robot. The WebElement has to be in the viewport.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement ctrlClick(){
		Robot robot = browser.robotSetup().robot();
		element.delay(delay).waitFor().enabled();
        robot.keyPress(KeyEvent.VK_CONTROL);
        click();
        robot.keyRelease(KeyEvent.VK_CONTROL);
        return element;
	}
}
