package tvt.selenium.core.browser.handle;

import org.openqa.selenium.Alert;

import tvt.selenium.core.browser.WebBrowser;

public class WebBrowserAlert {

	private Alert alert;
	
	/**
	 * The constructor will switch to the alert.
	 * @param browser {@link WebBrowser}
	 */
	public WebBrowserAlert(WebBrowser browser){
		alert=browser.getWebDriver().switchTo().alert();
	}
	
	/**
	 * Accept the alert.
	 */
	public void accept() {
		alert.accept();
	}
	
	/**
	 * Dismiss the alert.
	 */
	public void dismiss() {
		alert.dismiss();
	}

	/**
	 * Send keys to the alert.
	 * @param keys Keys to be sent to the alert.
	 */
	public void sendkeys(String keys){
		alert.sendKeys(keys);
	}
}
