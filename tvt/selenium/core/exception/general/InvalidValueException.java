package tvt.selenium.core.exception.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class InvalidValueException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidValueException (){
		super();
	}

	public InvalidValueException (java.lang.String message){
		super(message);
	}
	
	public InvalidValueException (java.lang.Throwable cause){
		super(cause);
	}
	
	public InvalidValueException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public InvalidValueException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public InvalidValueException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public InvalidValueException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public InvalidValueException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
