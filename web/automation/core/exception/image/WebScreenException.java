package web.automation.core.exception.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class WebScreenException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebScreenException (){
		super();
	}

	public WebScreenException (java.lang.String message){
		super(message);
	}
	
	public WebScreenException (java.lang.Throwable cause){
		super(cause);
	}
	
	public WebScreenException (java.lang.String message,java.lang.Throwable cause){
		super(message,cause);
	}
	
	public WebScreenException (WebBrowser browser,java.lang.String message){
		super(browser,message);
	}
	
	public WebScreenException (WebBrowser browser,By locator,java.lang.String message){
		super(browser,locator,message);
	}
	
	public WebScreenException (WebBrowser browser,WebElement element,java.lang.String message){
		super(browser,element,message);
	}
	
	public WebScreenException (WebBrowser browser,BrowserElement element,java.lang.String message){
		super(browser,element,message);
	}
}
