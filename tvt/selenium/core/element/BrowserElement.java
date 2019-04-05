/**
 * Collect all the action methods by WebDriver, WebDriver Actions, and Java Robot to perform on the WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.action.ElementActionByAction;
import tvt.selenium.core.element.action.ElementActionByDriver;
import tvt.selenium.core.element.action.ElementActionByRobot;
import tvt.selenium.core.element.action.ElementScroll;
import tvt.selenium.core.tool.WebJavaScript;
import tvt.selenium.core.widget.WebWidget;

public class BrowserElement{

	private WebElement element;
	private WebBrowser browser;
	private int delay;

	/**
	 * 
	 * @param browser {@link WebBrowser}
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 */
	public BrowserElement (WebBrowser browser,By byLocator){
		element = browser.getWebDriver().findElement(byLocator);
		this.browser = browser;
		enableDelay();
	}
	
	/**
	 * 
	 * @param browser {@link WebBrowser}
	 * @param element The WebElement.
	 */
	public BrowserElement (WebBrowser browser,WebElement element){
		this.element = element;
		this.browser = browser;
		enableDelay();
	}
	
	/**
	 * 
	 * @param browser {@link WebBrowser}
	 * @param element The WebElement.
	 * @param delayTme The delay time in millisecond.
	 */
	public BrowserElement (WebBrowser browser,WebElement element,int delayTme){
		this.element = element;
		this.browser = browser;
		delay=delayTme;
	}
	
	/**
	 * Put to sleep with the time specified in parameter.
	 * @param time The delay time in millisecond.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement delay(int time){
		browser.sleep(time);
		return this;
	}
	
	/**
	 * Put to sleep with the configured delay time.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement delay(){
		this.delay(delay);
		return this;
	}

	/**
	 * Set the delay time for current BrowserElement.
	 * @param time The delay time in millisecond.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement setDelay(int time){
		delay=time;
		return this;
	}
	
	/**
	 * Set the delay time with the action delay in TVTDriver.
	 * @return {@link BrowserElement}
	 */
	private BrowserElement enableDelay(){
		setDelay(browser.getTVTProfile().getActionDelay());
		return this;
	}
	
	/**
	 * The collection of actions by WebDriver.
	 * @return {@link ElementActionByDriver }
	 */
	public ElementActionByDriver actionsByDriver(){
		return new ElementActionByDriver(browser,this,delay);
	}
	
	/**
	 * The collection of actions by WebDriver Actions.
	 * @return {@link ElementActionByAction }
	 */
	public ElementActionByAction actionsByAction(){
		return new ElementActionByAction(browser,this,delay);
	}
	
	/**
	 * The collection of actions by Java Robot.
	 * @return {@link ElementActionByRobot }
	 */
	public ElementActionByRobot actionsByRobot(){
		return new ElementActionByRobot(browser,this,delay);
	}
	
	/**
	 * Use these scrolling methods when the WebElement is a scrolling div with scroll bar.
	 * @return {@link ElementScroll }
	 */
	public ElementScroll scroll(){
		return new ElementScroll(browser,this,delay);
	}
	
	/**
	 * Implicit wait for the current BrowserElement.
	 * @return {@link BrowserElementWait}
	 */
	public BrowserElementWait waitFor(){
		return new BrowserElementWait(browser,this);
	}
	
	/**
	 * Implicit wait for the current BrowserElement with the wait time multiplier
	 * @param waitTimeMultiplier The multiplier upon the time configured in GSSCWebDriver.
	 * @return {@link BrowserElementWait}
	 */
	public BrowserElementWait waitFor(int waitTimeMultiplier){
		return new BrowserElementWait(browser,this,waitTimeMultiplier);
	}
	
	/**
	 * Browser element condition methods which return boolean value.
	 * @return {@link BrowserElementCondition}
	 */
	public BrowserElementCondition condition(){
		return new BrowserElementCondition(browser,this);
	}

	/**
	 * The list of widget types to select. The available actions are organized by widget type.
	 * @return {@link WebWidget}
	 */
	public WebWidget widget(){
		return new WebWidget(browser,this);
	}
	
	/**
	 * Return the text of the current browser element.
	 * @return The text of the current browser element.
	 */
	public String getText(){
		return element.getText();
	}
	
	/**
	 * Return the attribute value of the current browser element.
	 * @param attribute The attribute value of the current browser element.
	 * @return
	 */
	public String getAttribute(String attribute){
		return element.getAttribute(attribute);
	}
	
	/**
	 * Return the tag name of the current browser element.
	 * @return The tag name of the current browser element.
	 */
	public String getTagName(){
		return element.getTagName();
	}
	
	/**
	 * Return the location of the current browser element.
	 * @return The location of the current browser element.
	 */
	public Point getLocation(){
		return element.getLocation();
	}
	/**
	public Point getScreenLocation(){
		return new Point(browser.frame().getOffset().getX()+element.getLocation().getX(),
				browser.frame().getOffset().getY()+element.getLocation().getY());
	}
	*/

	/**
	 * Return the size of the current browser element.
	 * @return The size of the current browser element.
	 */
	public Dimension getSize(){
		return element.getSize();
	}
	
	/**
	 * Return the WebElement of the current browser element.
	 * @return The WebElement of the current browser element.
	 */
	public WebElement getWebElement(){
		return element;
	}
	
	public String toString(){
		return element.toString();
	}
	
	/**
	 * Scroll with JavaScript scrollIntoView method. The top of the element will be aligned to the top of the scrollable ancestor object.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement scrollIntoViewAlignTop(){
		new WebJavaScript(browser).scrollIntoView(this,true);
		return delay(delay);
	}
	
	/**
	 * Scroll with JavaScript scrollIntoView method. The bottom of the element will be aligned to the bottom of the scrollable ancestor object.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement scrollIntoViewAlignBottom(){
		new WebJavaScript(browser).scrollIntoView(this,false);
		return delay(delay);
	}
}
