package tvt.selenium.core.exception.handle.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class WindowOutOfBoundException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowOutOfBoundException (){
		super();
	}

	public WindowOutOfBoundException (java.lang.String message){
		super(message);
	}
	
	public WindowOutOfBoundException (java.lang.Throwable cause){
		super(cause);
	}
	
	public WindowOutOfBoundException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public WindowOutOfBoundException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public WindowOutOfBoundException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public WindowOutOfBoundException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public WindowOutOfBoundException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
