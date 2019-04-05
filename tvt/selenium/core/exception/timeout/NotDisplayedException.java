package tvt.selenium.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class NotDisplayedException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotDisplayedException (){
		super();
	}

	public NotDisplayedException (java.lang.String message){
		super(message);
	}
	
	public NotDisplayedException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NotDisplayedException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NotDisplayedException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NotDisplayedException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NotDisplayedException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NotDisplayedException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
