package web.automation.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class TextStillEqualException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextStillEqualException (){
		super();
	}

	public TextStillEqualException (java.lang.String message){
		super(message);
	}
	
	public TextStillEqualException (java.lang.Throwable cause){
		super(cause);
	}
	
	public TextStillEqualException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public TextStillEqualException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public TextStillEqualException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public TextStillEqualException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public TextStillEqualException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
