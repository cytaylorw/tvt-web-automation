/**
 *  Class for variables used for Selenium WebDriver
 *  
 *  @author Taylor Wong
 */

package tvt.selenium.core.driver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import tvt.selenium.core.locale.WebLocales;

public class TVTProfile {

	private String locale;
	private int debugLVL;
	private int waitTime;
	private int waitInterval;
	private int actionDelay;
	private int screenDelay;
	private int robotDelay;
	private String mainDir;
	private String subDir;
	private String imageFormat;
	private float imageQuality;
	private boolean imageSuffix;
	private String firefoxProfile;
	private String driverPath;
	//private PIIReader pii;
	
	
	private static final int DEFAULT_DEBUG_LEVEL = 99;
	private static final int DEFAULT_WAIT_TIME = 1;
	private static final int DEFAULT_WAIT_INTERVAL = 100;
	private static final int DEFAULT_ACTION_DELAY = 0;
	private static final String DEFAULT_MAIN_DIR = null;
	private static final String DEFAULT_SUB_DIR = null;
	private static final int DEFAULT_SCREEN_DELAY = 0;
	private static final int DEFAULT_ROBOT_DELAY = 100;
	private static final String DEFAULT_IMAGE_FORMAT = "png";
	private static final float DEFAULT_IMAGE_QUALITY = 1;
	private static final boolean DEFAULT_IMAGE_SUFFIX = false;
	private static final String DEFAULT_FIREFOX_PROFILE = null;
	private static final String DEFAULT_DRIVER_PATH = null;
	
	public TVTProfile(String locale){
		actionDelay = DEFAULT_ACTION_DELAY;
		waitTime = DEFAULT_WAIT_TIME;
		waitInterval = DEFAULT_WAIT_INTERVAL;
		screenDelay = DEFAULT_SCREEN_DELAY;
		robotDelay = DEFAULT_ROBOT_DELAY;
		mainDir = DEFAULT_MAIN_DIR;
		subDir = DEFAULT_SUB_DIR;
		debugLVL = DEFAULT_DEBUG_LEVEL;
		if(WebLocales.hasLocale(locale)){
			this.locale = locale;
		}else{
			throw new IllegalArgumentException("The locale is not found in WebLocales.java");
		}
		setImageFormat(DEFAULT_IMAGE_FORMAT);
		imageQuality = DEFAULT_IMAGE_QUALITY;
		imageSuffix = DEFAULT_IMAGE_SUFFIX;
		firefoxProfile = DEFAULT_FIREFOX_PROFILE;
		driverPath = DEFAULT_DRIVER_PATH;
	}
	
	/**
	 * Configure the implicit wait and action delay times for Selenium
	 * 
	 * @param waitTimeBySEC The wait time in second for the implicit wait before throwing the timeout exception
	 * @param waitIntervalByMS The wait interval in millisecond to check the status for the implicit wait
	 */
	public void setWait(int waitTimeBySEC,int waitIntervalByMS){
		setWaitTime(waitTimeBySEC);
		setWaitInterval(waitIntervalByMS);
	}
	
	public void setWaitTime(int waitTimeBySEC){
		if(waitTimeBySEC<1)throw new IllegalArgumentException("The implicit wait time value must be bigger than 1");
		waitTime = waitTimeBySEC;
		//debug.debugVariable("waitTime="+waitTimeBySEC+"s");
	}
	
	public void setWaitInterval(int waitIntervalByMS){
		if((1000%waitIntervalByMS) != 0)throw new IllegalArgumentException("The implicit wait interval value must can multiply into 1000");
		waitInterval = waitIntervalByMS;
		//debug.debugVariable("waitInterval="+waitIntervalByMS+"ms");
	}
	
	/**
	 * Configure the screen capture used for Selenium. The directory will be automatically created if not exist.
	 * 
	 * @param screenMainDirectory The root directory to save the screen captures
	 * @param screenSubDirectoryName The sub directory to save the screen captures. For example, use the locale.
	 */
	public void setDirectory(String mainDirectory,String subDirectoryName){
		setMainDirectory(mainDirectory);
		setSubDirectory(subDirectoryName);
	}
	
	public void setMainDirectory(String mainDirectory){
		mainDir = mainDirectory;
	}
	
	public void setSubDirectory(String subDirectoryName){
		if(mainDir != null){
			subDir = subDirectoryName;
		}else{
			throw new NullPointerException("Main directory must be configured first.");
		}
	}
	
	public void setImageFormat(String formatName){
		switch(formatName.toLowerCase()){
		case "png": imageFormat = "png"; break;
		case "jpg": imageFormat = "jpg"; break;
		case "jpeg": imageFormat = "jpeg"; break;
		case "gif": imageFormat = "gif"; break;
		case "bmp": imageFormat = "bmp"; break;
		default:
            throw new IllegalArgumentException(formatName+" not supported. Please use png, jpg, gif, and bmp.");
		}
	}
	
	public void setImageQuality(float quality){
		imageQuality = quality;
	}
	
	public void setImageSuffix(boolean eanbleSuffix){
		imageSuffix=eanbleSuffix;
	}
	
	public void setFirefoxProfile(String profileOption){
		firefoxProfile=profileOption;
	}
	
	public void setDriverPath(String driver){
		driverPath = driver;
	}
	
	/**
	 * 
	 * @param actionDelayByMS The auto delay before performing the action on the WebElement.
	 * @param screenDelayByMS The auto delay before taking the screen captures.
	 */
	public void setDelay(int actionDelayByMS,int screenDelayByMS){
		actionDelay = actionDelayByMS;
		//debug.debugVariable("actionDelay="+actionDelayByMS+"ms");
		screenDelay = screenDelayByMS;
		//debug.debugVariable("screenDelay="+screenDelayByMS+"ms");
		initRobotDelay(actionDelayByMS);
	}
	
	private void initRobotDelay(int robotDelayByMS){
		if(robotDelayByMS < DEFAULT_ROBOT_DELAY){
			robotDelay=DEFAULT_ROBOT_DELAY;
		}else{
			robotDelay=robotDelayByMS;
		}
	}
	
	public void setRobotDelay(int robotDelayByMS){
		robotDelay=robotDelayByMS;
	}
	
	public void setDebugLevel(int level){
		debugLVL = level;
	}
	
	public int getDebugLevel(){
		return debugLVL;
	}
	
	public String getLocale(){
		return locale;
	}
	
	/**
	 * 
	 * @return The action delay in millisecond
	 */
	public int getActionDelay(){
		return actionDelay;
	}
	
	/**
	 * 
	 * @return The Robot delay in millisecond
	 */
	public int getRobotDelay(){
		return robotDelay;
	}
	
	/**
	 * 
	 * @return The implicit wait time in second
	 */
	public int getWaitTime(){
		return waitTime;
	}
	
	/**
	 * 
	 * @return The wait interval for implicit wait in millisecond
	 */
	public int getWaitInterval(){
		return waitInterval;
	}
	
	/**
	 * 
	 * @return The screen capture delay in millisecond
	 */
	public int getScreenDelay(){
		return screenDelay;
	}
	
	/**
	 * 
	 * @return The current main directory
	 */
	public String getMainDirectory(){
		return mainDir;
	}
	
	/**
	 * 
	 * @return The current sub directory
	 */
	public String getSubDirectory(){
		return subDir;
	}
	
	public String getImageFormat(){
		return imageFormat;
	}
	
	public float getImageQuality(){
		return imageQuality;
	}
	
	public boolean getImageSuffix(){
		return imageSuffix;
	}
	
	public String getFirefoxProfile(){
		return firefoxProfile;
	}
	
	public String getDriverPath(){
		return driverPath;
	}
	
	public List<String> getSettings(){
		List<String> values = new ArrayList<String>();;
		for(Field var : this.getClass().getDeclaredFields()){
			String name = var.getName();
			if(!name.startsWith("DEFAULT_") && name != null && !name.isEmpty()){
				var.setAccessible(true);
				Object value;
				try {
					value = var.get(this);
					if(value != null)values.add(name+" = "+value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return values;
	}
	
	
	/**
	 * 
	 * @return PIIReader class for methods to read localized text from PII. Please see {@link PIIReader}
	 
	public PIIReader getPII(){
		return pii;
	}
	*/
	
	/**
	 * Configure TVTPIIReader to read localized text from PII files. 
	 * 
	 * @param piiDir The directory containing the PII files
	 
	public void initPIIDirectory(String piiDir){
		if(piiDir!=null){
			debug.debugVariable("initPIIDirectory","Current PII direcotry is "+piiDir);
			pii = new PIIReader(piiDir);
		}
	}
	*/
}
