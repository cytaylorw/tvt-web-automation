package tvt.selenium.core.exception.timeout.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class EmptyTextException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyTextException (){
		super();
	}

	public EmptyTextException (java.lang.String message){
		super(message);
	}
	
	public EmptyTextException (java.lang.Throwable cause){
		super(cause);
	}
	
	public EmptyTextException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public EmptyTextException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public EmptyTextException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public EmptyTextException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public EmptyTextException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
