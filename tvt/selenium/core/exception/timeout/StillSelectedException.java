package tvt.selenium.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class StillSelectedException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StillSelectedException (){
		super();
	}

	public StillSelectedException (java.lang.String message){
		super(message);
	}
	
	public StillSelectedException (java.lang.Throwable cause){
		super(cause);
	}
	
	public StillSelectedException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public StillSelectedException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public StillSelectedException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public StillSelectedException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public StillSelectedException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
