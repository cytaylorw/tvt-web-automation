/**
 * Basic method and configuration for screen capturing with Selenium.
 * @author Taylor Wong
 */
package tvt.selenium.core.screen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.exception.image.SaveImageErrorException;
import tvt.selenium.core.exception.image.WebScreenException;
import tvt.selenium.core.screen.advance.ScreenAdvByAction;
import tvt.selenium.core.screen.advance.ScreenAdvByDriver;
import tvt.selenium.core.screen.advance.ScreenAdvByRobot;
import tvt.selenium.core.screen.image.WebBufferedImageByDriver;
import tvt.selenium.core.screen.image.WebBufferedImageByRobot;

public class WebScreen {

	private WebBrowser browser;
	private int screenDelay;
	private String screenDir;
	private String format;
	private float quality;
	private String suffix;
	
	public WebScreen(WebBrowser browser){
		this.browser = browser;
		screenDelay = browser.getTVTProfile().getScreenDelay();
		screenDirectory();
		File dir = new File(screenDir);
		browser.debug().debugScreen("Creating Directory: "+screenDir);
		if(!dir.exists()){
			dir.mkdirs();
			if(dir.exists()){
				browser.debug().debugScreen("Directory created.");
			}else{
				throw new WebScreenException("Fail to create directory: "+screenDir);
			}
		}else if(!dir.isDirectory()){
			throw new WebScreenException("Not a directory: "+screenDir);
		}else{
			browser.debug().debugScreen("Directory already exists.");
		}
		format = browser.getTVTProfile().getImageFormat();
		browser.debug().debugScreen("Image format is "+format.toUpperCase());
		if(format.equals("png")){
			browser.debug().debugScreen("Image compression quality is not supported for PNG format. Quality will be ignored.");
		}else{
			quality = browser.getTVTProfile().getImageQuality();
			if(quality == 1){
				browser.debug().debugScreen("Image will be saved in original quality.");
			}else{
				browser.debug().debugScreen("Image will be saved with compression quality of "+quality);
			}
		}
		browser.debug().printSplitter(WebDebug.DEBUGSCREEN);
	}
	
	/**
	 * Screen capture by WebDriver.
	 * @return {@link ScreenAdvByDriver}
	 */
	public ScreenAdvByDriver advByDriver(){
		return new ScreenAdvByDriver(browser,this);
	}
	
	/**
	 * Screen capture by WebDriver and actions by WebDriver Actions.
	 * @return {@link ScreenAdvByAction}
	 */
	public ScreenAdvByAction advByAction(){
		return new ScreenAdvByAction(browser,this);
	}
	
	/**
	 * Screen capture and actions by Java Robot.
	 * @return {@link ScreenAdvByRobot}
	 */
	public ScreenAdvByRobot advByRobot(){
		return new ScreenAdvByRobot(browser,this);
	}
	
	/**
	 * Put to sleep with screenDelay. 
	 * @return {@link WebScreen}
	 * @throws Exception
	 */
	public WebScreen delay(){
		delay(screenDelay);
		return this;
	}
	
	/**
	 * Put to sleep with time in millisecond.
	 * @param delayTimeByMS The sleep time in millisecond.
	 * @return {@link WebScreen}
	 * @throws Exception
	 */
	public WebScreen delay(int delayTimeByMS){
		browser.sleep(delayTimeByMS);
		return this;
	}
	
	/**
	 * Set auto delay for screen capture with time in millisecond.
	 * @param delayTimeByMS The delay time in millisecond.
	 * @return {@link WebScreen}
	 */
	public WebScreen setDelay(int delayTimeByMS){
		screenDelay = delayTimeByMS;
		return this;
	}
	
	/**
	 * Get the current delay time for screen capture.
	 * @return The delay time in millisecond.
	 */
	public int getDelay(){
		return screenDelay;
	}
	
	/**
	 * Save the BufferedImage with the file name.
	 * @param image The BufferedImage to be saved.
	 * @param fileName The file name prefix of the image.
	 * @throws Exception
	 */
	public void saveImageDirect (BufferedImage image,String fileName) {
		String location;
		
		if (image == null) throw new NullPointerException("The image to be saved is null.");

		location = imageLocation(fileName);
		browser.debug().debugScreen("Saving File: "+location);
		try {
			ImageIO.write(image, format, new File(location));
		} catch (IOException e) {
			throw new SaveImageErrorException("Error during writing",e);
		}
		browser.debug().debugScreen("File saved.");
		browser.debug().printSplitter(WebDebug.DEBUGSCREEN);
	}
	
	public void saveImage (BufferedImage image,String fileName){
		saveImage(image,fileName,quality);
	}
	
	public void saveImage (BufferedImage image,String fileName,float imageQuality) {
		String location;
		
		if (image == null) throw new NullPointerException("The image to be saved is null.");

		location = imageLocation(fileName);
		browser.debug().debugScreen("Saving File: "+location);

		Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName(format);
		ImageWriter writer = (ImageWriter)iter.next();
		ImageWriteParam iwp = writer.getDefaultWriteParam();
		if(iwp.canWriteCompressed()){
			iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			if(iwp.getCompressionType() == null){
				if(format.equals("gif"))iwp.setCompressionType("LZW");
				if(format.equals("bmp"))iwp.setCompressionType("BI_BITFIELDS");
			}
			iwp.setCompressionQuality(imageQuality);
		}
		File file = new File(location);
		FileImageOutputStream output;
		try {
			output = new FileImageOutputStream(file);
			writer.setOutput(output);
		} catch (IOException e) {
			throw new SaveImageErrorException("Error during creating file: "+location,e);
		}
		IIOImage io = new IIOImage(image, null, null);
		try {
			writer.write(null, io, iwp);
		} catch (IOException e) {
			throw new SaveImageErrorException("Error during writing to file.",e);
		}
		writer.dispose();
		browser.debug().debugScreen("File saved.");
		browser.debug().printSplitter(WebDebug.DEBUGSCREEN);
	}
	
	public void deleteImage(String fileName){
		String location = screenDir+"\\"+fileName+"."+format;
		browser.debug().debugScreen("Deleting File: "+location);
		File image = new File(location);
		if(image.exists()){
			image.delete();
			if(image.exists()){
				browser.debug().debugScreen("File not deleted.");
			}else{
				browser.debug().debugScreen("File deleted.");
			}
		}else{
			browser.debug().debugScreen("File does not exist.");
		}
		browser.debug().printSplitter(WebDebug.DEBUGSCREEN);
	}
		
	/**
	 * Create a buffered image by WebDriver.
	 * @return {@link WebBufferedImageByDriver}
	 * @throws Exception
	 */
	public WebBufferedImageByDriver bufferedImageByDriver() {
		return new WebBufferedImageByDriver(browser);
	}
	
	/**
	 * Create a buffered image by Java Robot.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws Exception
	 */
	public WebBufferedImageByRobot bufferedImageByRobot() {
		return new WebBufferedImageByRobot(browser);
	}
	
	private void screenDirectory(){
		String main = browser.getTVTProfile().getMainDirectory();
		String sub = browser.getTVTProfile().getSubDirectory();
		if(main != null && !main.isEmpty()){
			if(sub != null && !sub.isEmpty()){
				if(main.endsWith("\\")){
					screenDir = main+sub;
				}else{
					screenDir = main+"\\"+sub;
				}
				if(browser.getTVTProfile().getImageSuffix()) suffix=sub;
			}else{
				screenDir = main;
				if(browser.getTVTProfile().getImageSuffix()) throw new WebScreenException("Sub Directory is not configured for the suffix.");
			}
			browser.debug().debugScreen("All screen captures will be save to directory: "+screenDir);
		}else{
			browser.debug().debugScreen("Screen capture is disabled since the main directory is not set");
		}
		if(suffix == null){
			browser.debug().debugScreen("Image suffix is disabled");
		}else{
			browser.debug().debugScreen("Image suffix is "+suffix);
		}
	}
	
	private String imageLocation(String name){
		if(suffix == null){
			return screenDir+"\\"+name+"."+format;
		}else{
			return screenDir+"\\"+name+"_"+suffix+"."+format;
		}
	}
}
