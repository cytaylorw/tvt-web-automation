/**
 *  AutoDriver is for declaring and launching the browser with configuration.
 *  Currently only support Firefox and Chrome since IE only launch with the Windows locale
 *  
 *  @author Taylor Wong
 */
package web.automation.core.driver;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import web.automation.core.debug.WebDebug;
import web.automation.core.locale.WebLocales;
import web.automation.core.tool.WinRegistry;

public class AutoDriver{

	private String browserType;
	private WebDriver driver;
	private AutoProfile profile;
	private WebDebug debug;

	/**
	public AutoDriver(String browserType,String browserOption,String locale){
		profile = new AutoProfile(locale);
		initWebDebug();
		launchWebDriver(browserType,browserOption,locale);
	}
	**/
	public AutoDriver(String browserType,AutoProfile autoProfile){
		profile = autoProfile;
		initWebDebug();
		launchWebDriver(browserType,autoProfile.getLocale());
	}
	
	public AutoDriver(WebDriver webdriver,AutoProfile tvtProfile){
		profile = tvtProfile;
		initWebDebug();
		driver = webdriver;
		//check browser type
		//String browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
		//String userAgent = ((String) ((JavascriptExecutor)driver).executeScript("return navigator.userAgent")).toLowerCase();
		if(driver instanceof FirefoxDriver){
			browserType = "firefox";
		}else if(driver instanceof ChromeDriver){
			browserType = "chrome";
		}else if(driver instanceof InternetExplorerDriver){
			browserType = "internet explorer";
		}
		if(browserType == null){
			debug.debugDriver("User defined WebDriver is not supported Use it at your own risk.");
		}else{
			debug.debugDriver("User defined WebDriver is provided with browser type: "+browserType);
		}
		debug.printSplitter(WebDebug.DEBUGDRIVER);
	}
	
	/**
	 * 
	 * @return The WebDriver instance launched for current browser
	 */
	public WebDriver getWebDriver(){
		return driver;
	}
	
	/**
	 * 
	 * @return The current browser type launched
	 */
	public String getBrowserType(){
		return browserType;
	}
	
	/**
	 * 
	 * @return WebDebug class for methods to print logs in eclipse console. Internal Use. Please see {@link WebDebug}
	 */
	public WebDebug getDebug(){
		return debug;
	}
	
	public AutoProfile getProfile(){
		return profile;
	}
	
	public void debugPorilfeSettings(){
		debug.debugDriver("AutoProfile variable values:");
		List<String> values = profile.getSettings();
		if(values.size() == 0){
			debug.debugDriver("No variable is configured.");
		}else{
			for(String string : values){
				debug.debugDriver(string);
			}
		}
		debug.printSplitter(WebDebug.DEBUGDRIVER);
	}
	
	private void initWebDebug(){
		String dir = profile.getMainDirectory();
		if(dir == null){
			debug= new WebDebug(profile.getLocale(),"C:\\SeleniumLog",profile.getDebugLevel());
		}else{
			debug= new WebDebug(profile.getLocale(),dir,profile.getDebugLevel());
		}
	}
	
	private void setupFirefox (String ffLocale){
		String profileDir = profile.getFirefoxProfile();
		profile.setFirefoxProfile(profileDir);
		
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability(FirefoxDriver.PROFILE,setFirefoxProfile(ffLocale));
    	
    	if(profile.getDriverPath() != null && !profile.getDriverPath().isEmpty()){
    		String driverPath = profile.getDriverPath();
    		debug.debugDriver("Launching GeckoDriver with driver at "+driverPath);
    		System.setProperty("webdriver.gecko.driver",driverPath);
    		capabilities.setCapability("marionette", true);
		}
    	
    	driver = new FirefoxDriver(addCommonCapabilities(capabilities));
	}
	
	private FirefoxProfile setFirefoxProfile(String ffLocale){
		FirefoxProfile fp;
    	String option = profile.getFirefoxProfile();
    	if (option == null || option.isEmpty() || option.equalsIgnoreCase("new")){
    		debug.debugDriver("Launching FirefoxDriver with a new profile.");
    		fp = new FirefoxProfile();
    	}else if (option.equalsIgnoreCase("default")){
    		debug.debugDriver("Launching FirefoxDriver with the default profile.");
    		fp = new ProfilesIni().getProfile("default");
    	}else{
    		debug.debugDriver("Launching FirefoxDriver with profile at "+option);
    		fp = new FirefoxProfile(new File(option));
    	}
		
    	fp.setPreference("intl.locale.matchOS", false);
    	debug.debugDriver("Configuring FirefoxProfile locale/langauge preferences to "+ffLocale);
    	fp.setPreference("general.useragent.locale", ffLocale);
    	fp.setPreference("intl.accept_languages", ffLocale);
    	fp.setPreference("font.language.group", ffLocale);
    	fp.setPreference("datareporting.healthreport.service.enabled", false);
    	fp.setPreference("datareporting.healthreport.service.firstRun", false);
    	fp.setAcceptUntrustedCertificates(true);
		return fp;
	}
	
	/**
	private void setupFirefoxGecko (String ffLocale){
		String driverPath = profile.getDriverPath();
		debug.debugDriver("Launching GeckoDriver with driver at "+driverPath);
		System.setProperty("webdriver.gecko.driver",driverPath);
    	
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability(FirefoxDriver.PROFILE,setFirefoxProfile(ffLocale));
    	capabilities.setCapability("marionette", true);
    	
    	driver = new FirefoxDriver(addCommonCapabilities(capabilities));
	}
	**/
	
	//Browser option for Chrome is the full path to the ChromeDriver file: "C:\\automation\\chromedriver.exe"
	private void setupChrome (String chromeLocale){
		String driverPath = profile.getDriverPath();
		debug.debugDriver("Launching ChromeDriver with driver at "+driverPath+" and "+chromeLocale+" locale.");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=" + chromeLocale);
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-default-browser-check");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(addCommonCapabilities(capabilities));
		
	}
	
	private void setupIE (String ieLocale){
		String driverPath = profile.getDriverPath();
		debug.debugDriver("Launching InternetExplorerDriver with driver at "+driverPath);
		System.setProperty("webdriver.ie.driver", driverPath);
		try {
			// Set IE locale in Windows registry
			WinRegistry.writeStringValue(WinRegistry.HKEY_CURRENT_USER,"Software\\Microsoft\\Internet Explorer\\International","AcceptLanguage",ieLocale);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		driver = new InternetExplorerDriver(addCommonCapabilities(capabilities));
	}

	private DesiredCapabilities addCommonCapabilities(DesiredCapabilities capabilities){
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setJavascriptEnabled(true);
		//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE);
		return capabilities;
	}
	
	private void launchWebDriver(String type,String locale){
		String browserLocale = WebLocales.toBrowserLocale(locale);
		debug.debugDriver("Browser locale is '"+browserLocale+"'.");
		if (type.equalsIgnoreCase("firefox")){
			setupFirefox(browserLocale);
        	browserType = "firefox";
        }else if (type.equalsIgnoreCase("chrome")){
        	setupChrome(browserLocale);
        	browserType = "chrome";
        }else if(type.equalsIgnoreCase("internet explorer")){
        	setupIE(browserLocale);
        	browserType = "internet explorer";
        }else{
        	throw new IllegalArgumentException("Only Support firefox, chrome, and ie");
        }
		debug.debugDriver("WebDriver is launched successfully with browser type: "+browserType);
		debug.printSplitter(WebDebug.DEBUGDRIVER);
	}
	
	
}
