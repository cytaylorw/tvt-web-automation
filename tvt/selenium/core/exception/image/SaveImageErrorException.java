package tvt.selenium.core.exception.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class SaveImageErrorException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaveImageErrorException (){
		super();
	}

	public SaveImageErrorException (java.lang.String message){
		super(message);
	}
	
	public SaveImageErrorException (java.lang.Throwable cause){
		super(cause);
	}
	
	public SaveImageErrorException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public SaveImageErrorException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public SaveImageErrorException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public SaveImageErrorException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public SaveImageErrorException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
