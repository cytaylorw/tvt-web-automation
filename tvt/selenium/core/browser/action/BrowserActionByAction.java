/**
 * WebDriver Actions action to be performed with no target WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.browser.action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.exception.general.InvalidNumberOfParameterException;

public class BrowserActionByAction {

	private WebBrowser browser;
	
	public BrowserActionByAction(WebBrowser tvtWebBrowser) {
		browser=tvtWebBrowser;
	}

	/**
	 * Initialize and return a new WebDirver Actions instance for current browser.
	 * @return {@link Actions}
	 */
	public Actions newActions(){
		return new Actions(browser.getWebDriver());
	}
	
	/**
	 * Send a single key with WebDirver Actions.
	 * @param key Please see org.openqa.selenium.Keys.
	 */
	public BrowserActionByAction key (Keys key){
		newActions().sendKeys(key).build().perform();
		return this;
	}
	
	/**
	 * Release a single key with WebDirver Actions. Please check the Selenium document for limitation.
	 * @param key Please see org.openqa.selenium.Keys.
	 */
	public BrowserActionByAction keyUp (Keys key){
		newActions().keyUp(key).build().perform();
		return this;
	}
	
	public BrowserActionByAction sendKeys(CharSequence characters){
		newActions().sendKeys(characters).build().perform();
		return this;
	}
	
	/**
	 * Send the hotkey with WebDirver Actions.
	 * @param key The character to be pressed.
	 * @param modifier Modifier key. Please see org.openqa.selenium.Keys.
	 */
	public BrowserActionByAction hotKey (char key,Keys... modifier){
		int i = modifier.length;
		if(i == 1){
			newActions().sendKeys(Keys.chord(modifier[0],String.valueOf(key))).keyUp(modifier[0]).build().perform();
		}else if(i == 2){
			newActions().sendKeys(Keys.chord(modifier[0],modifier[1],String.valueOf(key))).keyUp(modifier[0]).keyUp(modifier[1]).build().perform();
		}else{
			throw new InvalidNumberOfParameterException("Only support 1 or 2 modifier parameters.");
		}
		return this;
	}
	
	public BrowserActionByAction move (int x,int y){
		newActions().moveByOffset(x, y).build().perform();
		return this;
	}
}
