package web.automation.core.exception.timeout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class NotFoundException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException (){
		super();
	}

	public NotFoundException (java.lang.String message){
		super(message);
	}
	
	public NotFoundException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NotFoundException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NotFoundException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NotFoundException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NotFoundException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NotFoundException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
