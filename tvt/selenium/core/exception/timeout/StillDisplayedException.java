package tvt.selenium.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class StillDisplayedException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StillDisplayedException (){
		super();
	}

	public StillDisplayedException (java.lang.String message){
		super(message);
	}
	
	public StillDisplayedException (java.lang.Throwable cause){
		super(cause);
	}
	
	public StillDisplayedException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public StillDisplayedException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public StillDisplayedException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public StillDisplayedException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public StillDisplayedException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
