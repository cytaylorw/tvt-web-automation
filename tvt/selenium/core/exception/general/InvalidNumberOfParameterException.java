package tvt.selenium.core.exception.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

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
