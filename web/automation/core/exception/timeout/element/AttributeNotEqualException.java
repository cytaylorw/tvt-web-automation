package web.automation.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class AttributeNotEqualException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttributeNotEqualException (){
		super();
	}

	public AttributeNotEqualException (java.lang.String message){
		super(message);
	}
	
	public AttributeNotEqualException (java.lang.Throwable cause){
		super(cause);
	}
	
	public AttributeNotEqualException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public AttributeNotEqualException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public AttributeNotEqualException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public AttributeNotEqualException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public AttributeNotEqualException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
