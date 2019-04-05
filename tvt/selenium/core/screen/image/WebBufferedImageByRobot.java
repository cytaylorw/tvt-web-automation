/**
 * Create the {@Link WebBufferedImage} with Java Robot.
 * @author Taylor Wong
 */
package tvt.selenium.core.screen.image;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.browser.handle.WindowMode;
import tvt.selenium.core.debug.WebDebug;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.image.ImageModificationNotAllowedException;
import tvt.selenium.core.exception.image.WebScreenException;
import tvt.selenium.core.locale.WebLocales;
import tvt.selenium.core.tool.WebImage;
import tvt.selenium.core.tool.WebJavaScript;

public class WebBufferedImageByRobot extends WebBufferedImage{
	
	private boolean ignoreWinLocation;
	private Point offset;

	public WebBufferedImageByRobot(WebBrowser browser) {
		super(browser);
		browser.debug().debugRobot("Robot images");
		offset=browser.robotSetup().robotOffset();
	}

	/**
	 * Take the buffered image of the browser including window title with Java Robot.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws AWTException 
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeScreen(){
		WebJavaScript js = new WebJavaScript(browser);
		Rectangle browserWindow = new Rectangle(new java.awt.Point(js.windowLocationX(),js.windowLocationY()),
				new Dimension(js.windowOuterWidth(),js.windowOuterHeight()));
		if(browserWindow.getX() < browser.window().getBrowserMaxSizeLocation().getX() ||  browserWindow.getY() < browser.window().getBrowserMaxSizeLocation().getY() || 
				browserWindow.getHeight() > browser.window().getBrowserMaxSize().getHeight() || browserWindow.getWidth() > browser.window().getBrowserMaxSize().getWidth()){
			takeMaxBoundScreen();
		}else{
			currentImage = browser.robotSetup().robot().createScreenCapture(browserWindow);
		}
		if(browser.window().getMode().equals(WindowMode.NON_ORIGIN)){
			ignoreWinLocation = true;
		}else{
			ignoreWinLocation = false;
		}
		locateElement=true;
		return this;
	}
	
	public WebBufferedImageByRobot drawEngRectangle(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangle(by);
		}
		return this;
	}
	
	public WebBufferedImageByRobot drawEngRectangle(int adjust,By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangle(adjust,by);
		}
		return this;
	}
	
	public WebBufferedImageByRobot drawEngRectangleInside(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangleInside(by);
		}
		return this;
	}
	
	public WebBufferedImageByRobot drawEngCrossOut(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawBlueCrossOut(by);
		}
		return this;
	}
	
	public WebBufferedImageByRobot drawEngCrossOut(int adjust,By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawBlueCrossOut(adjust,by);
		}
		return this;
	}
	
	/**
	 * Take the buffered image of the WebElement with Java Robot.
	 * @param crop The By locator of the WebElment to be taken.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeScreen(By crop){
		BrowserElement TVTelement = browser.waitFor().found(crop);
		currentImage = browser.robotSetup().robot().createScreenCapture(getElementRec(TVTelement));
		locateElement=false;
		return this;
	}
	
	/**
	 * Take the buffered image of the WebElements with Java Robot.
	 * @param crop1 The By locator of the WebElment to be taken.
	 * @param crops The By locators of the WebElments to be taken.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeScreen(By crop1,By... crops){
		Rectangle area = getElementRec(browser.waitFor().found(crop1));
		for(int i=0; i<crops.length; i++){
			BrowserElement element = browser.waitFor().found(crops[0]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		currentImage = browser.robotSetup().robot().createScreenCapture(area);
		locateElement=false;
		return this;
	}
	
	/**
	 * Take the buffered image of the browser document viewport with Java Robot.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeDocScreen(){
		WebJavaScript js = new WebJavaScript(browser);
		currentImage = browser.robotSetup().robot().createScreenCapture(new Rectangle(
				browser.window().getOffset().getX(),browser.window().getOffset().getY(),
				js.windowInnerWidth(),js.windowInnerHeight()));
		locateElement=false;
		return this;
	}
	
	/**
	 * Take the buffered image of the full screen including the OS task bar with Java Robot.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeFullScreen(){
		currentImage = browser.robotSetup().robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		locateElement=true;
		ignoreWinLocation = false;
		return this;
	}
	
	/**
	 * Take the buffered image of the full screen excluding the OS task bar with Java Robot.
	 * @return {@link WebBufferedImageByRobot}
	 * @throws AWTException 
	 * @throws Exception
	 */
	public WebBufferedImageByRobot takeMaxBoundScreen(){
		currentImage = browser.robotSetup().robot().createScreenCapture(new Rectangle(
				browser.window().getBrowserMaxSizeLocation().getX(),browser.window().getBrowserMaxSizeLocation().getY(),
				browser.window().getBrowserMaxSize().getWidth(),browser.window().getBrowserMaxSize().getHeight()));
		locateElement=true;
		ignoreWinLocation = false;
		return this;
	}
	
	public WebBufferedImageByRobot takeTooltip(By tooltip,int heightMultipier){
		BrowserElement TVTelement = browser.waitFor().found(tooltip);
		int y = TVTelement.getLocation().getY()+browser.robotSetup().robotOffset().getY();
		int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = TVTelement.getSize().getHeight();
		if(heightMultipier > 0){
			height = height*heightMultipier;
		}else if(heightMultipier < 0){
			height = -height*heightMultipier;
			y = y - height;
		}
		currentImage = browser.robotSetup().robot().createScreenCapture(new Rectangle(0,y,width,height));
		locateElement=false;
		return this;
	}
	
	/**
	public WebBufferedImageByRobot subImage(By area){
		BrowserElement TVTelement = browser.waitFor().found(area);
		subImage(getElementRec(TVTelement));
		return this;
	}
	**/
	
	public WebBufferedImageByRobot subImage(By... area){
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement TVTelement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(TVTelement);
		for(int i=1; i<area.length; i++){
			TVTelement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(TVTelement));
		}
		subImage(finalArea);
		locateElement=false;
		return this;
	}
	
	public WebBufferedImageByRobot subImage(int adjust,By... area){
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement TVTelement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(TVTelement);
		for(int i=1; i<area.length; i++){
			TVTelement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(TVTelement));
		}
		subImage(WebImage.adjustRectangle(finalArea,adjust));
		locateElement=false;
		return this;
	}
	/**
	public WebBufferedImageByRobot subImageKeepWidth(By area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		BrowserElement TVTelement = browser.waitFor().found(area);
		Rectangle rec = getElementRec(TVTelement);
		subImageKeepWidth((int)rec.getY(),(int)rec.getHeight());
		return this;
	}
	**/
	public WebBufferedImageByRobot subImageKeepWidth(By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement TVTelement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(TVTelement);
		for(int i=1; i<area.length; i++){
			TVTelement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(TVTelement));
		}
		subImageKeepWidth((int)finalArea.getY(),(int)finalArea.getHeight());
		return this;
	}
	
	public WebBufferedImageByRobot subImageKeepHeight(By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement TVTelement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(TVTelement);
		for(int i=1; i<area.length; i++){
			TVTelement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(TVTelement));
		}
		subImageKeepHeight((int)finalArea.getX(),(int)finalArea.getWidth());
		return this;
	}
	
	private WebBufferedImageByRobot drawRedRectangle(By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(by.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
			element = browser.waitFor().found(by[i]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawRedRectangle(area);
		return this;
	}
	
	private WebBufferedImageByRobot drawRedRectangle(int adjust,By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(by.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
			element = browser.waitFor().found(by[i]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawRedRectangle(WebImage.adjustRectangle(area,adjust));
		return this;
	}
	
	private WebBufferedImageByRobot drawRedRectangleInside(By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(by.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
			element = browser.waitFor().found(by[i]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawRedRectangleInside(area);
		return this;
	}
	
	private WebBufferedImageByRobot drawBlueCrossOut(By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(by.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
			element = browser.waitFor().found(by[i]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawBlueCrossOut(area);
		return this;
	}
	
	private WebBufferedImageByRobot drawBlueCrossOut(int adjust,By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(by.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
			element = browser.waitFor().found(by[i]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawBlueCrossOut(WebImage.adjustRectangle(area,adjust));
		return this;
	}
	
	private Rectangle getElementRec(BrowserElement TVTelement){
		browser.debug().debugScreen("Calculate element area for Robot");
		int x = TVTelement.getLocation().getX()+offset.getX();
		int y = TVTelement.getLocation().getY()+offset.getY();
		int width = TVTelement.getSize().getWidth();
		int height = TVTelement.getSize().getHeight();
		if(ignoreWinLocation){
			x-=browser.window().getLocation().getX();
			y-=browser.window().getLocation().getY();
		}
		Rectangle area =  new Rectangle(x,y, width, height);;
		browser.debug().debugScreen("Area = "+area.toString());
		browser.debug().printSplitter(WebDebug.DEBUGSCREEN);
		return area;
	}
}
