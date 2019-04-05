package tvt.selenium.core.exception.handle.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class WindowHandlesIndexException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowHandlesIndexException (){
		super();
	}

	public WindowHandlesIndexException (java.lang.String message){
		super(message);
	}
	
	public WindowHandlesIndexException (java.lang.Throwable cause){
		super(cause);
	}
	
	public WindowHandlesIndexException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public WindowHandlesIndexException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public WindowHandlesIndexException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public WindowHandlesIndexException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public WindowHandlesIndexException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
