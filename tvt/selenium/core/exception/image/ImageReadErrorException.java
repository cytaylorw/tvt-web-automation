package tvt.selenium.core.exception.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class ImageReadErrorException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageReadErrorException (){
		super();
	}

	public ImageReadErrorException (java.lang.String message){
		super(message);
	}
	
	public ImageReadErrorException (java.lang.Throwable cause){
		super(cause);
	}
	
	public ImageReadErrorException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public ImageReadErrorException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public ImageReadErrorException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public ImageReadErrorException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public ImageReadErrorException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
