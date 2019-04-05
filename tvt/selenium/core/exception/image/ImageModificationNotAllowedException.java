package tvt.selenium.core.exception.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.WebBrowserException;

public class ImageModificationNotAllowedException extends WebBrowserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageModificationNotAllowedException (){
		super();
	}

	public ImageModificationNotAllowedException (java.lang.String message){
		super(message);
	}
	
	public ImageModificationNotAllowedException (java.lang.Throwable cause){
		super(cause);
	}
	
	public ImageModificationNotAllowedException (java.lang.String message, java.lang.Throwable cause){
		super(message,cause);
	}
	
	public ImageModificationNotAllowedException (WebBrowser browser, java.lang.String message){
		super(browser,message);
	}
	
	public ImageModificationNotAllowedException (WebBrowser browser, By locator, java.lang.String message){
		super(browser,locator,message);
	}
	
	public ImageModificationNotAllowedException (WebBrowser browser, WebElement element, java.lang.String message){
		super(browser,element,message);
	}
	
	public ImageModificationNotAllowedException (WebBrowser browser, BrowserElement element, java.lang.String message){
		super(browser,element,message);
	}
}
