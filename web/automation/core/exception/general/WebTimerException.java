package web.automation.core.exception.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class WebTimerException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebTimerException (){
		super();
	}

	public WebTimerException (java.lang.String message){
		super(message);
	}
	
	public WebTimerException (java.lang.Throwable cause){
		super(cause);
	}
	
	public WebTimerException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public WebTimerException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public WebTimerException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public WebTimerException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public WebTimerException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
