package tvt.selenium.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class AttributeStillEqualException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttributeStillEqualException (){
		super();
	}

	public AttributeStillEqualException (java.lang.String message){
		super(message);
	}
	
	public AttributeStillEqualException (java.lang.Throwable cause){
		super(cause);
	}
	
	public AttributeStillEqualException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public AttributeStillEqualException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public AttributeStillEqualException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public AttributeStillEqualException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public AttributeStillEqualException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
