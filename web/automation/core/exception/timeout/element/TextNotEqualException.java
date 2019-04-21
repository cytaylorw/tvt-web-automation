package web.automation.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class TextNotEqualException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextNotEqualException (){
		super();
	}

	public TextNotEqualException (java.lang.String message){
		super(message);
	}
	
	public TextNotEqualException (java.lang.Throwable cause){
		super(cause);
	}
	
	public TextNotEqualException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public TextNotEqualException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public TextNotEqualException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public TextNotEqualException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public TextNotEqualException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
