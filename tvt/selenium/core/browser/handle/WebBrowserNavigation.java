/**
 * Managing browser URL.
 * @author Taylor Wong
 */
package tvt.selenium.core.browser.handle;

import org.openqa.selenium.Keys;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.exception.handle.navigation.URLSegementNotfoundException;

public class WebBrowserNavigation {

	private WebBrowser browser;
	
	public WebBrowserNavigation(WebBrowser browser){
		this.browser=browser;
	}
	
	/**
	 * Go to the URL.
	 * @param url The URL to be navigated.
	 */
	public void url (String url){
		browser.getWebDriver().get(url); 
		browser.frame().defaultContent();
	}
	
	/**
	 * Clear all cookies and go to the URL.
	 * @param url The URL to be navigated.
	 */
	public void initURL (String url){
		browser.getWebDriver().manage().deleteAllCookies();
		url(url);
		browser.window().initWindowHandles();
	}
	
	/**
	 * Get the current URL.
	 * @return The current URL.
	 */
	public String getCurrentURL(){
		return browser.getWebDriver().getCurrentUrl();
	}
	
	/**
	 * Navigate back with WebDriver method.
	 */
	public void back(){
		browser.getWebDriver().navigate().back();
		browser.frame().defaultContent();
	}
	
	/**
	 * Refresh the browser with WebDriver method.
	 */
	public void refresh(){
		browser.getWebDriver().navigate().refresh();
		//browser.frame().defaultContent();
	}
	
	/**
	 * Navigate back with Java Robot by pressing Backspace.
	 * @throws Exception
	 */
	public void backByRobot(){
		browser.actionsByRobot().key(Keys.BACK_SPACE);
		browser.frame().defaultContent();
	}
	
	/**
	 * Refresh the browser with Java Robot by pressing F5.
	 */
	public void refreshByRobot(){
		browser.actionsByRobot().key(Keys.F5);
		browser.frame().defaultContent();
	}
	
	/**
	 * Replace the URL by keeping the URL from the beginning to the lastSegmentToKeep and adding the newSegment at its end. Then navigate to the new URL.
	 * @param lastSegmentToKeep The last URL segment to keep.
	 * @param newSegment The new URL segment added after lastSegmentToKeep.
	 */
	public void replaceURL(String lastSegmentToKeep,String newSegment){
		String url = browser.navigate().getCurrentURL();
		String segment = "/"+lastSegmentToKeep+"/";
		if(url.contains(segment)){
			url = url.substring(0, url.indexOf(segment)+segment.length());
			if(newSegment.startsWith("/")){
				url =  url+newSegment.substring(1);
			}else{
				url =  url+newSegment;
			}
		}else{
			throw new URLSegementNotfoundException("URL segment not found: "+segment);
		}
		url(url);
	}
}
