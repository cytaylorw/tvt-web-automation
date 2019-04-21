
package web.automation.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class NotEnabledException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnabledException (){
		super();
	}

	public NotEnabledException (java.lang.String message){
		super(message);
	}
	
	public NotEnabledException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NotEnabledException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NotEnabledException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NotEnabledException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NotEnabledException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NotEnabledException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
