package web.automation.core.exception.handle.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class NoNewWindowException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoNewWindowException (){
		super();
	}

	public NoNewWindowException (java.lang.String message){
		super(message);
	}
	
	public NoNewWindowException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NoNewWindowException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NoNewWindowException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NoNewWindowException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NoNewWindowException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NoNewWindowException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
