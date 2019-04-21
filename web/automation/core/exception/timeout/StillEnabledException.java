package web.automation.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class StillEnabledException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StillEnabledException (){
		super();
	}

	public StillEnabledException (java.lang.String message){
		super(message);
	}
	
	public StillEnabledException (java.lang.Throwable cause){
		super(cause);
	}
	
	public StillEnabledException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public StillEnabledException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public StillEnabledException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public StillEnabledException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public StillEnabledException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
