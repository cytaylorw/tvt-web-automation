package web.automation.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class AttributeStillContainException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttributeStillContainException (){
		super();
	}

	public AttributeStillContainException (java.lang.String message){
		super(message);
	}
	
	public AttributeStillContainException (java.lang.Throwable cause){
		super(cause);
	}
	
	public AttributeStillContainException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public AttributeStillContainException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public AttributeStillContainException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public AttributeStillContainException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public AttributeStillContainException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
