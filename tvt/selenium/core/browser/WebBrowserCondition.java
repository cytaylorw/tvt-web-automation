/**
 * WebBrowserCondition is the collections for the condition checking on the Browser
 * 
 * @author Taylor Wong
 */

package tvt.selenium.core.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tvt.selenium.core.tool.WebJavaScript;

public class WebBrowserCondition {

	private WebBrowser browser;
	
	//timeout in second for WebDriverWait
	private static final int WEBDRIVERWAIT_TIME = 0;
	
	public WebBrowserCondition(WebBrowser browser) {
		this.browser = browser;
	}

	/**
	 * Checking if the WebElement is found and displayed.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return The status on whether the WebElement is found and displayed.
	 */
	public boolean isDisplayed(By byLocator){
		try {
			return browser.find().element(byLocator).getWebElement().isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	return false;
	    } catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the WebElement is found and enabled.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return The status on whether the WebElement is found and enabled.
	 */
	public boolean isEnabled(By byLocator){
		try {
			return browser.find().element(byLocator).getWebElement().isEnabled();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	return false;
	    } catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the WebElement is found and selected.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return The status on whether the WebElement is found and selected.
	 */
	public boolean isSelected(By byLocator){
		try {
	    	return browser.find().element(byLocator).getWebElement().isSelected();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	return false;
	    } catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the WebElement is found.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return The status on whether the WebElement is found.
	 */
	public boolean isFound(By byLocator) {
	    try {
	    	browser.find().element(byLocator);
	    	return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	return false;
	    }
	}
	
	/**
	 * Checking if the browser alert is present.
	 * @return The status on whether the browser alert is present.
	 */
	public boolean isAlertPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(browser.getWebDriver(),WEBDRIVERWAIT_TIME);
	        wait.until(ExpectedConditions.alertIsPresent());
	        return true;
	    } catch (org.openqa.selenium.NoAlertPresentException e) {
	        return false;
	    }
	}
	
	/**
	 * Checking if the vertical scroll bar is present on the HTML document and document body.
	 * @return The status on whether the vertical scroll bar is present on the HTML document and document body.
	 */
	public boolean isDocVerticalScrollbar() {
		WebJavaScript js = new WebJavaScript(browser);
		if (js.isDocumentVerticalScrollBar() || js.isDocumentBodyVerticalScrollBar()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checking if the horizontal scroll bar is present on the HTML document and document body.
	 * @return The status on whether the horizontal scroll bar is present on the HTML document and document body.
	 */
	public boolean isDocHorizontalScrollbar() {
		WebJavaScript js = new WebJavaScript(browser);
		if (js.isDocumentHorizontalScrollBar() || js.isDocumentBodyHorizontalScrollBar()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Checking if the current locale is equal to any of the locale(s) specified in the parameter.
	 * @param locale The locale(s) to trigger the condition. Please see {@link tvt.selenium.core.locale.WebLocales}
	 * @return The status on whether the current locale is equal to any of the locale(s).
	 */
	public boolean isLocaleEqualAnyOf(String... locale) {
		if(locale.length == 0) throw new IllegalArgumentException("Must specify at least one locale");
		for(int i=0; i<locale.length; i++){
			if(locale[i].equals(browser.getLocale())) return true;
		}
		return false;
	}
	
	/**
	 * Checking if the browser is FireFox.
	 * @return The status on whether the browser is FireFox.
	 */
	public boolean isFirefoxBrowser(){
		return browser.getBrowserType().equalsIgnoreCase("firefox");
	}
	
	/**
	 * Checking if the browser is Chrome.
	 * @returnThe status on whether the browser is Chrome.
	 */
	public boolean isChromeBrowser(){
		return browser.getBrowserType().equalsIgnoreCase("chrome");
	}
}
