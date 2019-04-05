/**
 * WebBrowser is designed to access all methods implemented upon WebDriver
 * 
 * @author Taylor Wong
 */
package tvt.selenium.core.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import tvt.selenium.core.browser.action.BrowserActionByAction;
import tvt.selenium.core.browser.action.BrowserActionByRobot;
import tvt.selenium.core.browser.handle.WebBrowserAlert;
import tvt.selenium.core.browser.handle.WebBrowserFrame;
import tvt.selenium.core.browser.handle.WebBrowserNavigation;
import tvt.selenium.core.browser.handle.WebBrowserWindow;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.debug.WebTimer;
import tvt.selenium.core.driver.TVTDriver;
import tvt.selenium.core.driver.TVTProfile;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.locator.WebLocator;
import tvt.selenium.core.screen.WebScreen;
import tvt.selenium.core.tool.WebJavaScript;

public class WebBrowser {

	
	private TVTDriver tvtDriver;
	private WebBrowserRobot robotSetup;
	private WebBrowserWindow windows;
	private WebBrowserFrame frames;
	private WebScreen screen;
	private WebTimer timer;
	
	/**
	 * Constructor which will also initialize <code>WebBrowserWindow</code>, <code>WebBrowserFrame</code>, <code>WebBrowserRobotSetup</code>. Robot delay will use the action delay.
	 * @param driver TVTDriver initialized with TVTProfile configured.
	 * @throws Exception 
	 */
	public WebBrowser(TVTDriver driver){
		this.tvtDriver = driver;
		initHandlers();
	}
	
	public WebBrowser(String browserType,TVTProfile tvtProfile){
		tvtDriver = new TVTDriver(browserType,tvtProfile);
		initHandlers();
	}
	
	/**
	public WebBrowser(String browserType,String browserOption,String locale){
		tvtDriver = new TVTDriver(browserType,browserOption,new TVTProfile(locale));
		initHandlers();
	}
	**/
	
	public WebBrowser(WebDriver webdriver,TVTProfile tvtProfile){
		tvtDriver = new TVTDriver(webdriver,tvtProfile);
		initHandlers();
	}
	
	public WebBrowser(WebDriver webdriver,String locale){
		tvtDriver = new TVTDriver(webdriver,new TVTProfile(locale));
		initHandlers();
	}
	
	private void initHandlers(){
		updateDebugLevel();
		tvtDriver.debugPorilfeSettings();
		screen = new WebScreen(this);
		windows = new WebBrowserWindow(this);
		frames = new WebBrowserFrame(this);
		robotSetup = new WebBrowserRobot(this);
		timer = new WebTimer(this);
	}
	
	public void updateDebugLevel(){
		if(debug().getDebugLevel() != getTVTProfile().getDebugLevel()){
			debug().printMessage("Updating debug level....");;
			debug().setDebugLevel(getTVTProfile().getDebugLevel());
			debug().printSplitter();
		}
	}
	
	/**
	 * Close the browser. Equivalent to WebDriver.quit().
	 */
	public void quit(){
		getWebDriver().quit();
	}
	
	/**
	 * Implicit wait.
	 * @return {@link WebBrowserWait}.
	 */
	public WebBrowserWait waitFor(){
			return new WebBrowserWait(this);
	}
	
	/**
	 * Implicit wait with the wait time multiplier
	 * @param waitTimeMultiplier The multiplier upon the time configured in GSSCWebDriver.
	 * @return {@link WebBrowserWait}.
	 */
	public WebBrowserWait waitFor(int waitTimeMultiplier){
		return new WebBrowserWait(this,waitTimeMultiplier);
	}
	
	/**
	 * Screen capture related methods.
	 * @return {@link WebScreen}.
	 */
	public WebScreen screen(){
		try{
			return screen;
		}catch (NullPointerException e){
			throw new NullPointerException("Please setup the directory for saving screencapture first with TVTWebDriver.setScreenCapture");
		}
	}
	
	/**
	 * Browser condition methods which return boolean value.
	 * @return {@link WebBrowserCondition}.
	 */
	public WebBrowserCondition condition(){
		return new WebBrowserCondition(this);
	}
	
	/**
	 * Selenium WebDriver Action actions on browser without target element.
	 * @return {@link BrowserActionByAction}.
	 */
	public BrowserActionByAction actionsByAction(){
		return new BrowserActionByAction(this);
	}
	
	/**
	 * Java Robot actions on browser without target element.
	 * @return {@link BrowserActionByRobot}.
	 */
	public BrowserActionByRobot actionsByRobot(){
		try{
			return new BrowserActionByRobot(this);
		}catch (NullPointerException e){
			throw new NullPointerException("Make sure robotSetup initialized with TVTWebBrowser.initRobotSetup(int robotDelay)");
		}
	}
	
	/**
	 * The browser window class with Robot related offset values calculated.
	 * @return Browser window class to manage windows. Please see {@link WebBrowserWindow}.
	 */
	public WebBrowserWindow window(){
		return windows;
	}
	
	/**
	 * The browser frame class with Robot related offset values calculated.
	 * @returnBrowser frame class to manage frames. Please see {@link WebBrowserFrame}.
	 */
	public WebBrowserFrame frame(){
		return frames;
	}
	
	/**
	 * The browser navigation class for managing URL.
	 * @return browser navigation class to manage URL. Please see {@link WebBrowserNavigation}.
	 */
	public WebBrowserNavigation navigate(){
		return new WebBrowserNavigation(this);
	}
	
	/**
	 * The browser navigation class for managing browser alert.
	 * @return browser alert class to manage browser alert. Please see {@link WebBrowserAlert}.
	 */
	public WebBrowserAlert alert() {	
		return new WebBrowserAlert(this);
	}
	
	/**
	 * Java Script methods.
	 * @return {@link WebJavaScript}
	 */
	public WebJavaScript JavaScript(){
		return new WebJavaScript(this);
	}
	
	/**
	 * The Java Robot setup class for calculating the Robot offset for element.
	 * @return Java Robot setup class for browser. Please see {@link WebBrowserRobot}.
	 */
	public WebBrowserRobot robotSetup(){
		return robotSetup;
	}
	
	/**
	 * Return the WebDriver instance to access Selenium methods directly.
	 * @return WebDriver instance to access Selenium methods directly.
	 */
	public WebDriver getWebDriver(){
		return tvtDriver.getWebDriver();
	}
	
	/**
	 * Return the TVTWebDriver instance to get the related variables.
	 * @return TVTWebDriver instance to get the related variables. Please see {@link TVTDriver}.
	 */
	public TVTProfile getTVTProfile(){
		return tvtDriver.getProfile();
	}
	
	public String getBrowserType(){
		return tvtDriver.getBrowserType();
	}
	
	/**
	 * Get the current browser locale in {@link tvt.selenium.core.locale.WebLocales}.
	 * @return The current browser locale in {@link tvt.selenium.core.locale.WebLocales}.
	 */
	public String getLocale(){
		return tvtDriver.getProfile().getLocale();
	}
	
	public WebDebug debug() {
		return tvtDriver.getDebug();
	}
	
	public WebTimer timer(){
		return timer;
	}
	
	/**
	 * Find the WebElement and return in <code>BrowserElement</code>.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return BrowserElement which contains WebElement and related methods. Please see {@link BrowserElement}.
	 */
	public WebLocator find(){
		return new WebLocator(this);
	}
	
	
	/**
	 * Put to sleep for the specified time in millisecond.
	 * @param timeInMS time in millisecond.
	 * @throws Exception
	 */
	public void sleep(int timeInMS){
		try {
			Thread.sleep(timeInMS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Point getScrolledOffset(){
		WebJavaScript js = new WebJavaScript(this);
		int x = js.scrolledDocumentOffset().getX()+ js.scrolledDocumentBodyOffset().getX();
		int y = js.scrolledDocumentOffset().getY()+ js.scrolledDocumentBodyOffset().getY();
		Point scrolled = new Point(x,y);
		debug().debugBrowser("scrolled = "+scrolled.toString());
		return scrolled;
	}

	public Capabilities getCapabilities(){
		return ((RemoteWebDriver)getWebDriver()).getCapabilities();
	}
	
	/**
	 * Methods to get localized text from PII.
	 * @return The PIIReader class to get localized text from PII.
	 
	@Beta
	public PIIReader getPII(){
		return tvtDriver.getPII();
	}
	*/
}
