package web.automation.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class AttributeNotContainException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttributeNotContainException (){
		super();
	}

	public AttributeNotContainException (java.lang.String message){
		super(message);
	}
	
	public AttributeNotContainException (java.lang.Throwable cause){
		super(cause);
	}
	
	public AttributeNotContainException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public AttributeNotContainException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public AttributeNotContainException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public AttributeNotContainException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public AttributeNotContainException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
