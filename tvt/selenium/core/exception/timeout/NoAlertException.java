package tvt.selenium.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class NoAlertException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAlertException (){
		super();
	}

	public NoAlertException (java.lang.String message){
		super(message);
	}
	
	public NoAlertException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NoAlertException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NoAlertException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NoAlertException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NoAlertException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NoAlertException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
