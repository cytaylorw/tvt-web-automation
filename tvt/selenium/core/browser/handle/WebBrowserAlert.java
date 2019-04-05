package tvt.selenium.core.browser.handle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;

import tvt.selenium.core.browser.WebBrowser;

public class WebBrowserAlert {

	private Alert alert;
	private Credentials credential;
	
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
	 * Set the credential to be used in the browser alert.
	 * @param username User name for the credential.
	 * @param password Password for the credential.
	 * @return {@link WebBrowserAlert}
	 */
	public WebBrowserAlert setCredential(String username, String password){
		credential = new UserAndPassword(username,password);
		return this;
	}
	
	/**
	 * Authenticate using the provided credential.
	 * @param username User name for the credential.
	 * @param password Password for the credential.
	 */
	public void authenticate(String username,String password){
		alert.authenticateUsing(new UserAndPassword(username,password));
	}
	
	/**
	 * Authenticate using the credential configured with {@link #setCredential(String, String)}.
	 */
	public void authenticate(){
		alert.authenticateUsing(credential);
	}
	
	/**
	 * Send keys to the alert.
	 * @param keys Keys to be sent to the alert.
	 */
	public void sendkeys(String keys){
		alert.sendKeys(keys);
	}
}
