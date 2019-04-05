/**
 * Managing browser windows and calculating the window offset for Java Robot use. 
 * Window location and size are using JavaScript since Selenium method return negative number when window is maximized.
 * @author Taylor Wong
 */
package tvt.selenium.core.browser.handle;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.exception.handle.window.NoNewWindowException;
import tvt.selenium.core.exception.handle.window.WindowHandlesIndexException;
import tvt.selenium.core.exception.handle.window.WindowOutOfBoundException;
import tvt.selenium.core.tool.WebJavaScript;

public class WebBrowserWindow {

	private WebBrowser browser;
	private WebDebug debug;
	private List<String> windowHandles;
	private Point browserMaxSizeLocation;
	private Dimension browserMaxSize;
	private Point windowOffset;
	private Dimension uploadFileSize;
	private Point uploadFileLocation;
	
	private String mode;
	/**
	 * WebBrowserWindow is initialized in the WebBrowser constructor and binded to the WebBrowser.
	 * @param browser {@link WebBrowser}
	 */
	public WebBrowserWindow(WebBrowser browser){
		this.browser=browser;
		debug=browser.debug();
		calculateBrowserMaxBound();
		calculateWindowOffset();
		calculateUploadFileSize();
		setMode();
	}
	
	/**
	 * Initialize a new array list for window handles. Can not use this method when there are pop-up opened.
	 */
	public void initWindowHandles(){
		if(windowHandles != null && windowHandles.size()>1) throw new UnsupportedOperationException("Please close all popup windows first.");
		windowHandles = new ArrayList<String>();
		windowHandles.add(browser.getWebDriver().getWindowHandle());
	}
	
	/**
	 * Return the maximum window bound location based on current screen resolution and window task bar location. Not current location.
	 * @return The maximum window bound location. Not current location.
	 */
	public Point getBrowserMaxSizeLocation(){
		return browserMaxSizeLocation;
	}
	
	/**
	 * Return the maximum window bound size based on current screen resolution and window task bar location. Not current size.
	 * @return The maximum window bound size. Not current size.
	 */
	public Dimension getBrowserMaxSize(){
		return browserMaxSize;
	}
	
	public Rectangle getUploadFile(){
		return new Rectangle(uploadFileLocation.getX(),uploadFileLocation.getY(),uploadFileSize.getWidth(),uploadFileSize.getHeight());
	}
	
	/**
	 * Maximize the current browser window. The window border will be out of the screen.
	 */
	public void maximize(){
		browser.getWebDriver().manage().window().maximize();
		calculateWindowOffset();
		calculateUploadFileLocation();
		mode = WindowMode.MAX;
	}
	
	/**
	 * Resize and move the current browser window to fit the screen. The window border will still be inside the screen.
	 */
	public void maxBound(){
		setPosition(browserMaxSizeLocation);
		setSize(browserMaxSize);
		calculateWindowOffset();
		calculateUploadFileLocation();
		mode = WindowMode.MAX;
	}
	
	/**
	 * Move the current browser window to the upper-left corner (the maximum window bound location.)
	 */
	public void moveToUpperLeftCorner(){
		setPosition(browserMaxSizeLocation);
	}
	
	/**
	 * Move the current browser window to the center of the maximum window bound.
	 */
	public void moveToCenter(){
		WebJavaScript js = new WebJavaScript(browser);
		int x = browserMaxSizeLocation.getX()+browserMaxSize.getWidth()/2-js.windowOuterWidth()/2;
		int y = browserMaxSizeLocation.getY()+browserMaxSize.getHeight()/2-js.windowOuterHeight()/2;
		setPosition(new Point(x,y));
	}
	
	/**
	 * Set the current browser window size. Can not be bigger than the maximum bound size in width or height.
	 * @param size The new browser window size.
	 */
	public void setSize(Dimension size){
		if(browser.getWebDriver().manage().window().getPosition().getX()<0 || 
				browser.getWebDriver().manage().window().getPosition().getY()<0){
			maxBound();
		}
		if(size.getWidth()>browserMaxSize.getWidth()){
			throw new WindowOutOfBoundException("The size width can not be bigger than the Max size width: "+browserMaxSize.getWidth());
		}else if(size.getHeight()>browserMaxSize.getHeight()){
			throw new WindowOutOfBoundException("The size height can not be bigger than the Max size height: "+browserMaxSize.getHeight());
		}
		browser.getWebDriver().manage().window().setSize(size);
	}
	
	/**
	 * Set the current browser window location. Can not move the window out of screen view.
	 * @param location The new browser window location.
	 */
	public void setPosition(Point location){
		if(browser.getWebDriver().manage().window().getPosition().getX()<0 || 
				browser.getWebDriver().manage().window().getPosition().getY()<0){
			maxBound();
		}
		if(location.getX()<browserMaxSizeLocation.getX() || 
				location.getX()>browserMaxSizeLocation.getX()+browserMaxSize.getWidth() ||
				location.getY()<browserMaxSizeLocation.getY() || 
				location.getY()>browserMaxSizeLocation.getY()+browserMaxSize.getHeight()){
			throw new WindowOutOfBoundException("The new position has to be inside of screen view excluding the window taskbar. New Position: "+location.toString());
		}
		browser.getWebDriver().manage().window().setPosition(location);
		uploadFileLocation=location;
		setMode();
	}
	
	/**
	 * Select the first new opened window which has not been selected before.
	 */
	public void selectNew(){
		// add delay for a new opened window
		delay();
		Set<String> allWindows = browser.getWebDriver().getWindowHandles();
		if(allWindows.size() == windowHandles.size()){
			throw new NoNewWindowException("No new window handle found.");
		}
		
		Iterator<String> ite = allWindows.iterator();
		while(ite.hasNext()){
			String popupHandle=ite.next();
			if(!windowHandles.contains(popupHandle)){
				browser.getWebDriver().switchTo().window(popupHandle);
				windowHandles.add(browser.getWebDriver().getWindowHandle());
				browser.waitFor().displayed(By.xpath("/html"));
				delay();
				calculateWindowOffset();
				calculateUploadFileLocation();
				browser.frame().defaultContent();
			}
		}
		setMode();
	}
	
	/**
	 * Select the browser window which already has record in the window handle with its index.
	 * @param index The index of the selected browser window handle.
	 */
	public void select(int index){
		if(index >= windowHandles.size()){
			if(windowHandles.size()== 1){
				throw new WindowHandlesIndexException("Only have 1 window available. (index=0)");
			}else{
				throw new WindowHandlesIndexException("Only have "+windowHandles.size()+" window available. (index:0-"+(windowHandles.size()-1)+")");
			}
		}else{
			delay();
			browser.getWebDriver().switchTo().window(windowHandles.get(index));
			browser.waitFor().displayed(By.xpath("/html"));
			calculateWindowOffset();
			calculateUploadFileLocation();
			browser.frame().defaultContent();
		}
		setMode();
	}
	
	/**
	 * Close the current browser window.
	 */
	public void close(){
		if(windowHandles.size()<2)throw new WindowHandlesIndexException("Do not close all the windows");
		if(browser.getWebDriver().getWindowHandle().equals(windowHandles.get(0)))throw new WindowHandlesIndexException("Do not close the main window");
		windowHandles.remove(browser.getWebDriver().getWindowHandle());
		browser.getWebDriver().close();
		delay();
		browser.getWebDriver().switchTo().window(windowHandles.get(windowHandles.size()-1));
		browser.waitFor().displayed(By.xpath("/html"));
		calculateWindowOffset();
		calculateUploadFileLocation();
		browser.frame().defaultContent();
		setMode();
	}
	
	/**
	 * Close the browser window which already has record in the window handle with its index.
	 * @param index The index of the selected browser window handle.
	 */
	public void close(int index){
		if(windowHandles.size()== 1 || index == 0){
			throw new WindowHandlesIndexException("Do not close the main window");
		}else if(index >= windowHandles.size()){
			throw new WindowHandlesIndexException("Only have "+windowHandles.size()+"window available. (index:0-"+(windowHandles.size()-1)+")");
		}else{
			String currentHandle = browser.getWebDriver().getWindowHandle();
			if(currentHandle == windowHandles.get(index)){
				close();
			}else{
				delay();
				browser.getWebDriver().switchTo().window(windowHandles.get(index));
				browser.waitFor().displayed(By.xpath("/html"));
				windowHandles.remove(browser.getWebDriver().getWindowHandle());
				browser.getWebDriver().close();
				delay();
				browser.getWebDriver().switchTo().window(windowHandles.get(windowHandles.size()-1));
				browser.waitFor().displayed(By.xpath("/html"));
				calculateWindowOffset();
				calculateUploadFileLocation();
				browser.frame().defaultContent();
				setMode();
			}
		}
	}
	
	/**
	 * Close all windows except the first window.
	 * @throws Exception
	 */
	public void closeAllPopup() throws Exception{
		//Close all existing windows first
		for(int i=windowHandles.size()-1; i>0; i--){
			close(i);
		}
		select(0);
		//Check and close unexpected windows
		Set<String> allWindows = browser.getWebDriver().getWindowHandles();
		if(allWindows.size()>1){
			Iterator<String> ite = allWindows.iterator();
			while(ite.hasNext()){
				String popupHandle=ite.next();
				if(!popupHandle.equals(windowHandles.get(0))){
					browser.getWebDriver().switchTo().window(popupHandle);
					browser.waitFor().displayed(By.xpath("/html"));
					browser.getWebDriver().close();
					delay();
				}
			}
			select(0);
		}
		
	}
	
	/**
	 * Get the current window location using JavaScript. It will return (0,0) when maximized while WebDriver will return negative number.
	 * @return The current window location using JavaScript.
	 */
	public Point getLocation(){
		WebJavaScript js = new WebJavaScript(browser);
		int windowLocationX = js.windowLocationX();
		int windowLocationY = js.windowLocationY();
		return new Point(windowLocationX,windowLocationY);
	}
	
	/**
	 * Get the current browser window offset for Java Robot.
	 * @return The current browser window offset for Java Robot.
	 */
	public Point getOffset(){
		return windowOffset;
	}
	
	public String getMode(){
		return mode;
	}
	
	/**
	 * Remove the last window handle. Use after a window is closed automatically to update {@param windowHandles}.
	 */
	public void removeLastHandle(){
		windowHandles.remove(windowHandles.size()-1);
		select(windowHandles.size()-1);
	}
	/**
	 * Calculate browserMaxSizeLocation and browserMaxSize.
	 */
	private void calculateBrowserMaxBound(){
		Rectangle envWinSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		browserMaxSizeLocation = new Point((int)envWinSize.getLocation().getX(),(int)envWinSize.getLocation().getY());
		browserMaxSize = new Dimension((int)envWinSize.getSize().getWidth(),(int)envWinSize.getSize().getHeight());
		debug.debugBrowser("browserMaxSizeLocation = "+browserMaxSizeLocation.toString());
		debug.debugBrowser("browserMaxSize = "+browserMaxSize.toString());
		browser.debug().printSplitter(WebDebug.DEBUGBROWSER);
	}
	
	private void calculateUploadFileSize(){
		Rectangle envWinSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		uploadFileSize = new Dimension((int)envWinSize.getSize().getWidth()/2,(int)envWinSize.getSize().getHeight()/3);
	}
	
	private void calculateUploadFileLocation(){
		uploadFileLocation = getLocation();
	}
	
	public void increaseWidth(int increnment){
		WebJavaScript js = new WebJavaScript(browser);
		int width = js.windowOuterWidth();
		int height = js.windowOuterHeight();
		setSize(new Dimension(width+increnment,height));
	}
	
	public void increaseHeight(int increnment){
		WebJavaScript js = new WebJavaScript(browser);
		int width = js.windowOuterWidth();
		int height = js.windowOuterHeight();
		setSize(new Dimension(width,height+increnment));
	}
	
	/**
	 * Calculate the window offset for  Java Robot.
	 */
	private void calculateWindowOffset(){
		WebJavaScript js = new WebJavaScript(browser);
		int docWidth = js.windowInnerWidth();
		int browserWidth = js.windowOuterWidth();
		int winBorder = (browserWidth-docWidth)/2;
		debug.debugRobot("browserWidth = "+browserWidth);
		debug.debugRobot("docWidth = "+docWidth);
		debug.debugRobot("winBorder = "+winBorder);
		int docHeight = js.windowInnerHeight();
		int browserHeight = js.windowOuterHeight();
		//assume there is no status bar below the browser
		windowOffset = new Point(winBorder,browserHeight-docHeight-winBorder);
		debug.debugRobot("browserHeight = "+browserHeight);
		debug.debugRobot("docHeight = "+docHeight);
		debug.debugRobot("windowOffset = "+windowOffset.toString());
		browser.debug().printSplitter(WebDebug.DEBUGBROWSER);
	}

	private void setMode(){
		if(getLocation() == new Point(0,0)){
			if(browser.getWebDriver().manage().window().getSize().getWidth() >= browserMaxSize.getWidth() && browser.getWebDriver().manage().window().getSize().getHeight() >= browserMaxSize.getHeight()){
				mode = WindowMode.MAX;
			}else{
				mode = WindowMode.ORIGIN;
			}
		}else{
			mode = WindowMode.NON_ORIGIN;
		}
	}
	
	private void delay(){
		browser.sleep(browser.getTVTProfile().getActionDelay());
	}
}
