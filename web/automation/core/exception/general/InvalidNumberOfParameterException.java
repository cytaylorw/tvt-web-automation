package web.automation.core.exception.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class InvalidNumberOfParameterException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberOfParameterException (){
		super();
	}

	public InvalidNumberOfParameterException (java.lang.String message){
		super(message);
	}
	
	public InvalidNumberOfParameterException (java.lang.Throwable cause){
		super(cause);
	}
	
	public InvalidNumberOfParameterException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public InvalidNumberOfParameterException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public InvalidNumberOfParameterException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public InvalidNumberOfParameterException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public InvalidNumberOfParameterException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
