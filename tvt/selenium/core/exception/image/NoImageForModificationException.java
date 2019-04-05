package tvt.selenium.core.exception.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class NoImageForModificationException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoImageForModificationException (){
		super();
	}

	public NoImageForModificationException (java.lang.String message){
		super(message);
	}
	
	public NoImageForModificationException (java.lang.Throwable cause){
		super(cause);
	}
	
	public NoImageForModificationException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public NoImageForModificationException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public NoImageForModificationException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public NoImageForModificationException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public NoImageForModificationException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
