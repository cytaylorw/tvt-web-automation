package tvt.selenium.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class NoPartialTextException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPartialTextException (){
		super();
	}

	public NoPartialTextException (java.lang.String message){
		super(message);
	}
	
	public NoPartialTextException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NoPartialTextException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NoPartialTextException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NoPartialTextException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NoPartialTextException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NoPartialTextException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
