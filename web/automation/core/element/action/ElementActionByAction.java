/**
 * WebDriver Actions actions on a WebElement.
 * @author Taylor Wong
 */
package web.automation.core.element.action;

import org.openqa.selenium.Keys;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

public class ElementActionByAction {

	private BrowserElement element;
	private WebBrowser browser;
	private int delay;
	
	public ElementActionByAction(WebBrowser browser,BrowserElement element,int time) {
		this.browser = browser;
		this.element = element;
		delay = time;
	}
	
	/**
	 * Actions.moveToElement(WebElement).click()
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement click(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).click().build().perform();
		return element;
	}
	
	/**
	 * Actions.moveToElement(WebElement).contextClick()
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement contextClick(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).contextClick().build().perform();
		return element;
	}
	
	/**
	 * Actions.moveToElement(WebElement).doubleClick()
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement doubleClick(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).doubleClick().build().perform();
		return element;
	}
	
	/**
	 * Actions.moveToElement(WebElement).clickAndHold()
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement clickAndHold(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).clickAndHold().build().perform();
		return element;
	}
	
	/**
	 * Actions.moveToElement(WebElement)
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement move(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).build().perform();
		return element;
	}
	
	/**
	 * Actions.moveToElement(WebElement,offsetX,offsetY)
	 * @param offsetX The X coordinate from upper-left corner of the WebElement.
	 * @param offsetY The Y coordinate from upper-left corner of the WebElement.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement move(int offsetX,int offsetY){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement(),offsetX,offsetY).build().perform();
		return element;
	}
	
	/**
	 * Actions.sendKeys(WebElement, keys)
	 * @param keys The keys to send.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement sendKeys(CharSequence... keys){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().sendKeys(element.getWebElement(), keys).build().perform();
		return element;
		
	}
	
	/**
	 * Actions.moveToElement(WebElement).click().sendKeys(keys)
	 * @param keys The keys to send.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement clickThenType(CharSequence... keys){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().moveToElement(element.getWebElement()).click().sendKeys(keys).build().perform();
		return element;
	}
	
	/**
	 * Actions.keyDown(Keys.CONTROL).moveToElement(WebElement).click().keyUp(Keys.CONTROL)
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement ctrlClick(){
		element.delay(delay).waitFor().enabled();
		browser.actionsByAction().newActions().keyDown(Keys.CONTROL).moveToElement(element.getWebElement()).click().keyUp(Keys.CONTROL).build().perform();
		return element;
	}
	
}
