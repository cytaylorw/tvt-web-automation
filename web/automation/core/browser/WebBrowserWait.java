/**
 * WebBrowserWait waits and returns the element when the condition is met.
 * @author Taylor Wong
 */
package web.automation.core.browser;

import org.openqa.selenium.By;

import web.automation.core.browser.handle.WebBrowserAlert;
import web.automation.core.debug.WebDebug;
import web.automation.core.debug.WebTimer;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.timeout.*;

public class WebBrowserWait {

	private WebBrowser browser;
	private WebDebug debug;
	private int waitInterval;
	private int waitTime;
	private WebTimer timer;
	
	/**
	 * Default constructor with wait time configured in GSSCWebDriver.
	 * @param The browser {@link WebBrowser}
	 */
	public  WebBrowserWait(WebBrowser browser){
		this.browser = browser;
		debug = browser.debug();
		waitInterval = browser.getAutoProfile().getWaitInterval();
		waitTime = browser.getAutoProfile().getWaitTime();
		initTimer();
	}
	
	/**
	 * Constructor with wait time configured in GSSCWebDriver multiplied with the waitTimeMultiplier parameter.
	 * @param browser The browser WebBrowser instance for the browser.
	 * @param waitTimeMultiplier The wait time multiplier.
	 */
	public  WebBrowserWait(WebBrowser browser, int waitTimeMultiplier){
		this.browser = browser;
		debug = browser.debug();
		waitInterval = browser.getAutoProfile().getWaitInterval();
		waitTime = browser.getAutoProfile().getWaitTime()*waitTimeMultiplier;
		timer = new WebTimer(browser);
		initTimer();
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be found.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement found (By byLocator){
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (int i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return browser.find().element(byLocator); 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be not found.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @throws Exception
	 */
	public void notFound (By byLocator){
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (int i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillFoundException(browser,byLocator,"Timeout: Still Found");
	    	}
	    	try { if (!browser.condition().isFound(byLocator)) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be displayed.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement displayed (By byLocator){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,byLocator,"Timeout: Not Displayed");
	    	}
	    	try { if (browser.condition().isDisplayed(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return browser.find().element(byLocator); 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
		
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be not displayed.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @throws StillDisplayedException
	 */
	public void notDisplayed (By byLocator){
		int i;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillDisplayedException(browser,byLocator,"Timeout: Still Displayed");
	    	}
	    	try { if (!browser.condition().isDisplayed(byLocator)) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		break; 
	    	}} catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be enabled.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement enabled (By byLocator){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotEnabledException(browser,byLocator,"Timeout: Not Enabled");
	    	}
	    	if (browser.condition().isEnabled(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return browser.find().element(byLocator);
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be not enabled.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @throws Exception
	 */
	public void notEnabled (By byLocator){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillEnabledException(browser,byLocator,"Timeout: Still Enabled");
	    	}
	    	if (!browser.condition().isEnabled(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
		
	/**
	 * Wait for the WebElement located by byLocator to be selected.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement selected (By byLocator){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,byLocator,"Timeout: Not Displayed");
	    	}
	    	try { if (browser.condition().isDisplayed(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotSelectedException(browser,byLocator,"Timeout: Not Selected");
	    	}
	    	if (browser.condition().isSelected(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return browser.find().element(byLocator);
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be not selected.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement notSelected (By byLocator){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,byLocator,"Timeout: Not Displayed");
	    	}
	    	try { if (browser.condition().isDisplayed(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillSelectedException(browser,byLocator,"Timeout: Still Selected");
	    	}
	    	if (!browser.condition().isSelected(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return browser.find().element(byLocator);
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the browser alert to be present.
	 * @return {@link WebBrowserAlert}
	 * @throws Exception
	 */
	public WebBrowserAlert alertPresent (){
		int count = waitTime*1000/waitInterval;
		debug.debugWait("");
		debugMessage(count);
		for (int i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NoAlertException(browser,"Timeout: No Alert");
	    	}
	    	try { if (browser.condition().isAlertPresent()) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return browser.alert();
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the WebElement located by byLocator to be displayed and enabled.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link BrowserElement} found with byLocator
	 * @throws Exception
	 */
	public BrowserElement displayedAndEnabled (By byLocator){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,byLocator,"Timeout: Not Displayed");
	    	}
	    	try { if (browser.condition().isDisplayed(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotEnabledException(browser,byLocator,"Timeout: Not Enabled");
	    	}
	    	if (browser.condition().isEnabled(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return  browser.find().element(byLocator);
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	

	/**
	 * Wait for the WebElement located by byLocator to be displayed and not enabled.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @throws Exception
	 */
	public void displayedAndNotEnabled (By byLocator){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(byLocator.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,byLocator,"Timeout: Not Found");
	    	}
	    	try { if (browser.condition().isFound(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,byLocator,"Timeout: Not Displayed");
	    	}
	    	try { if (browser.condition().isDisplayed(byLocator)) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillEnabledException(browser,byLocator,"Timeout: Still Enabled");
	    	}
	    	if (!browser.condition().isEnabled(byLocator)) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	private void debugMessage(int count){
		debug.debugWait("<Time: "+ waitTime+ "> s = <Count: "+count+"> * <waitInterval: "+waitInterval+"> ms");
	}
	
	private void debugTimeSpentByCountMessage(int actualCount){
		debug.debugWait("Time spent by count #"+actualCount+" : "+(actualCount*waitInterval)+" ms");
	}
	
	private void debugTimeSpentByTimerMessage(){
		debug.debugWait("Time spent by timer: "+timer.stop(false).convertElapseTime());
		debug.printSplitter(WebDebug.DEBUGWAIT);
	}
	
	private void initTimer(){
		timer = new WebTimer(browser);
		timer.start(false);
	}
}
