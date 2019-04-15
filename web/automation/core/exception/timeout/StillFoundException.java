package web.automation.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class StillFoundException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StillFoundException (){
		super();
	}

	public StillFoundException (java.lang.String message){
		super(message);
	}
	
	public StillFoundException (java.lang.Throwable cause){
		super(cause);
	}
	
	public StillFoundException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public StillFoundException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public StillFoundException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public StillFoundException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public StillFoundException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
