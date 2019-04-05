package tvt.selenium.core.exception.robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class BrowseFileByRobotException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrowseFileByRobotException (){
		super();
	}

	public BrowseFileByRobotException (java.lang.String message){
		super(message);
	}
	
	public BrowseFileByRobotException (java.lang.Throwable cause){
		super(cause);
	}
	
	public BrowseFileByRobotException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public BrowseFileByRobotException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public BrowseFileByRobotException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public BrowseFileByRobotException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public BrowseFileByRobotException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
