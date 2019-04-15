package web.automation.core.exception;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.tool.WebDate;

public class WebBrowserException extends org.openqa.selenium.WebDriverException{

	/**
	 * 
	 */
	String failScreen;
	WebBrowser browser;
	
	
	private static final long serialVersionUID = 1L;
	
	public WebBrowserException (){
		super();
	}

	public WebBrowserException (String message){
		super(message);
	}
	
	public WebBrowserException (Throwable cause){
		super(cause);
	}
	
	public WebBrowserException (String message, Throwable cause){
		super(message,cause);
	}
	
	public WebBrowserException (WebBrowser browser, String message){
		super(message);
		this.browser = browser;
		if(browser.screen() != null){
			takeScreenCapture(browser,message);
		}
		browser.debug().printException(message,this);
	}
	
	public WebBrowserException (WebBrowser browser, By locator, String message){
		super(message);
		this.browser = browser;
		browser.debug().printException(message,this);
		if(browser.screen() != null)takeScreenCapture(browser,locator,message);	
	}
	
	public WebBrowserException (WebBrowser browser, WebElement element, String message){
		super(message);
		this.browser = browser;
		browser.debug().printException(message,this);
		if(browser.screen() != null)takeScreenCapture(browser,element,message);
	}
	
	public WebBrowserException (WebBrowser browser, BrowserElement element, String message){
		super(message);
		this.browser = browser;
		browser.debug().printException(message,this);
		if(browser.screen() != null)takeScreenCapture(browser,element,message);
	}
	
	public void takeScreenCapture(WebBrowser browser, String message){
		String name = ("_Fail@"+WebDate.timeForExceptionScreen()+"@"+message).replaceAll("[\\\\/:*?\"<>|]", "_").replaceAll("\\s+","");
		browser.screen().bufferedImageByRobot().takeFullScreen().saveImage(name);
		failScreen = name;
	}
	
	public void takeScreenCapture(WebBrowser browser, By locator, String message){
		takeScreenCapture(browser,checkElementString(locator.toString())+"@"+message);
	}
	
	public void takeScreenCapture(WebBrowser browser, WebElement element, String message){
		String elementString = element.toString();
		takeScreenCapture(browser,checkElementString(removeDriver(elementString))+"@"+message);
	}
	
	public void takeScreenCapture(WebBrowser browser, BrowserElement element, String message){
		String elementString = element.toString();
		takeScreenCapture(browser,checkElementString(removeDriver(elementString))+"@"+message);
	}
	
	private String removeDriver(String string){
		if(string.contains("Driver:")){
			//Remove the last "]"
			string = string.substring(0, string.length()-1);
			//Remove string "[[FirefoxDriver_firefoxonWINDOWS(d4437378-fa10-44ca-b309-b1c3eb73aa40)]"
			string = string.substring(string.indexOf("]")+1);
		}
		return string;
	}
	
	private String checkElementString(String string){
		int length = string.length();
		if(length > 195){
			return string.substring(0,192)+"...";
		}else{
			return string;
		}
	}
	
	public void removeFailScreen(){
		if(browser != null){
			browser.screen().deleteImage(failScreen);
		}
	}
}
