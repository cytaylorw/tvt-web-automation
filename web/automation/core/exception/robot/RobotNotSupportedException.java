package web.automation.core.exception.robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.WebBrowserException;

public class RobotNotSupportedException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RobotNotSupportedException (){
		super();
	}

	public RobotNotSupportedException (java.lang.String message){
		super(message);
	}
	
	public RobotNotSupportedException (java.lang.Throwable cause){
		super(cause);
	}
	
	public RobotNotSupportedException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public RobotNotSupportedException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public RobotNotSupportedException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public RobotNotSupportedException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public RobotNotSupportedException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
