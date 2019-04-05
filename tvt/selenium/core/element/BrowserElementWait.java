package tvt.selenium.core.element;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.debug.WebTimer;
import tvt.selenium.core.exception.timeout.NotDisplayedException;
import tvt.selenium.core.exception.timeout.NotEnabledException;
import tvt.selenium.core.exception.timeout.NotFoundException;
import tvt.selenium.core.exception.timeout.NotSelectedException;
import tvt.selenium.core.exception.timeout.StillDisplayedException;
import tvt.selenium.core.exception.timeout.StillEnabledException;
import tvt.selenium.core.exception.timeout.StillFoundException;
import tvt.selenium.core.exception.timeout.StillSelectedException;
import tvt.selenium.core.exception.timeout.element.*;


public class BrowserElementWait {

	private BrowserElement element;
	private WebBrowser browser;
	private WebDebug debug;
	private int waitInterval;
	private int waitTime;
	private WebTimer timer;
	
	/**
	 * Default constructor with wait time configured in GSSCWebDriver.
	 * @param browser {@link WebBrowser}
	 * @param element {@link BrowserElement}
	 */
	public BrowserElementWait(WebBrowser browser,BrowserElement element) {
		this.element = element;
		this.browser = browser;
		debug = browser.debug();
		waitInterval = browser.getTVTProfile().getWaitInterval();
		waitTime = browser.getTVTProfile().getWaitTime();
		initTimer();
	}
	
	/**
	 * Constructor with wait time configured in GSSCWebDriver multiplied with the waitTimeMultiplier parameter.
	 * @param browser {@link WebBrowser}
	 * @param element {@link BrowserElement}
	 * @param waitTimeMultiplier The wait time multiplier.
	 */
	public BrowserElementWait(WebBrowser browser,BrowserElement element,int waitTimeMultiplier) {
		this.element = element;
		this.browser = browser;
		debug = browser.debug();
		waitInterval = browser.getTVTProfile().getWaitInterval();
		waitTime = browser.getTVTProfile().getWaitTime()*waitTimeMultiplier;
		initTimer();
	}

	/**
	 * Wait for the current {@link BrowserElement} to be found.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement found (){
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (int i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return element;
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be not found.
	 * @throws Exception
	 */
	public void notFound (){
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (int i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillFoundException(browser,element,"Timeout: Still Found");
	    	}
	    	try { if (!element.condition().isFound()) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be displayed.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement displayed (){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,element,"Timeout: Not Displayed");
	    	}
	    	try { if (element.condition().isDisplayed()) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
		
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be not displayed.
	 * @throws Exception
	 */
	public void notDisplayed (){
		int i;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillDisplayedException(browser,element,"Timeout: Still Displayed");
	    	}
	    	try { if (!element.condition().isDisplayed()) {
	    		debugTimeSpentByCountMessage(i);
	    		debugTimeSpentByTimerMessage();
	    		return; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
		
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be enabled.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement enabled (){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotEnabledException(browser,element,"Timeout: Not Enabled");
	    	}
	    	if (element.condition().isEnabled()) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be not enabled.
	 * @throws Exception
	 */
	public void notEnabled (){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillEnabledException(browser,element,"Timeout: Still Enabled");
	    	}
	    	if (!element.condition().isEnabled()) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be selected.
	 * @throws Exception
	 */
	public void selected (){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,element,"Timeout: Not Displayed");
	    	}
	    	try { if (element.condition().isDisplayed()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotSelectedException(browser,element,"Timeout: Not Selected");
	    	}
	    	if (element.condition().isSelected()) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be not selected.
	 * @throws Exception
	 */
	public void notSelected (){
		int i,j,k;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotDisplayedException(browser,element,"Timeout: Not Displayed");
	    	}
	    	try { if (element.condition().isDisplayed()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (k = 0;; k++) {
	    	if (i+j+k >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new StillSelectedException(browser,element,"Timeout: Still Selected");
	    	}
	    	if (!element.condition().isSelected()) {
	    		debugTimeSpentByCountMessage(i+j+k);
	    		debugTimeSpentByTimerMessage();
	    		return;
	    	}
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to has text value.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement hasText(){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait("Text not empty");
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new EmptyTextException(browser,element,"Timeout: Text still empty");
	    	}
	    	try { if (!element.condition().isEmptyText()) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be equal to the text parameter.
	 * @param text The text parameter.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement equalText(String text){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait("Text = "+text);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new TextNotEqualException(browser,element,"Timeout: Text Not Equal To "+text);
	    	}
	    	try { if (element.condition().isEqualText(text)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to be not equal to the text parameter.
	 * @param text The text parameter.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement notEqualText(String text){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait("Text != "+text);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new TextStillEqualException(browser,element,"Timeout: Text Still Equal To "+text);
	    	}
	    	try { if (!element.condition().isEqualText(text)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	

	/**
	 * Wait for the current {@link BrowserElement} to have the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement equalAttributeValue(String attribute,String value){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait(attribute+" = "+value);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new AttributeNotEqualException(browser,element,"Timeout: "+attribute+" not equal to "+value);
	    	}
	    	try { if (element.condition().isEqualAttributeValue(attribute,value)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to not have the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement notEqualAttributeValue(String attribute,String value){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait(attribute+" != "+value);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new AttributeStillEqualException(browser,element,"Timeout: "+attribute+" still equal to "+value);
	    	}
	    	try { if (!element.condition().isEqualAttributeValue(attribute,value)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to contain the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement containAttributeValue(String attribute,String value){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait(attribute+" contains "+value);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new AttributeNotContainException(browser,element,"Timeout: "+attribute+" does not contain "+value);
	    	}
	    	try { if (element.condition().isContainedAttributeValue(attribute,value)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
	    	browser.sleep(waitInterval);
	    }
	}
	
	/**
	 * Wait for the current {@link BrowserElement} to not contain the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement notContainAttributeValue(String attribute,String value){
		int i,j;
		int count = waitTime*1000/waitInterval;
		debug.debugWait(element.toString());
		debug.debugWait(attribute+" not contain "+value);
		debugMessage(count);
		for (i = 0;; i++) {
	    	if (i >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new NotFoundException(browser,element,"Timeout: Not Found");
	    	}
	    	try { if (element.condition().isFound()) break; } catch (Exception e) {}
	    	browser.sleep(waitInterval);
	    }
		for (j = 0;; j++) {
	    	if (i+j >= count) {
	    		debugTimeSpentByTimerMessage();
	    		throw new AttributeStillContainException(browser,element,"Timeout: "+attribute+" still contains "+value);
	    	}
	    	try { if (!element.condition().isContainedAttributeValue(attribute, value)) {
	    		debugTimeSpentByCountMessage(i+j);
	    		debugTimeSpentByTimerMessage();
	    		return element; 
	    	}} catch (Exception e) {}
	    	
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
