package tvt.selenium.core.exception.handle.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class URLSegementNotfoundException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public URLSegementNotfoundException (){
		super();
	}

	public URLSegementNotfoundException (java.lang.String message){
		super(message);
	}
	
	public URLSegementNotfoundException (java.lang.Throwable cause){
		super(cause);
	}
	
	public URLSegementNotfoundException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public URLSegementNotfoundException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public URLSegementNotfoundException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public URLSegementNotfoundException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public URLSegementNotfoundException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}