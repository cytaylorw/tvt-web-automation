/**
 * Create the {@Link WebBufferedImage} with WebDriver.
 * @author Taylor Wong
 */
package web.automation.core.screen.image;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.image.ImageModificationNotAllowedException;
import web.automation.core.exception.image.ImageReadErrorException;
import web.automation.core.exception.image.WebScreenException;
import web.automation.core.locale.WebLocales;
import web.automation.core.tool.WebImage;

public class WebBufferedImageByDriver extends WebBufferedImage{

	public WebBufferedImageByDriver(WebBrowser browser) {
		super(browser);
	}

	/**
	 * Take the buffered image with WebDriver.
	 * @return {@link WebBufferedImageByDriver}
	 * @throws Exception
	 */
	public WebBufferedImageByDriver takeScreen(){
		File screenshot=((TakesScreenshot)browser.getWebDriver()).getScreenshotAs(OutputType.FILE);
		try {
			currentImage = ImageIO.read(screenshot);
		} catch (IOException e) {
			throw new ImageReadErrorException(e);
		}
		locateElement=true;
		return this;
	}
	
	/**
	 * Take the buffered image of the WebElement with WebDriver.
	 * @param crop The By locator of the WebElment to be taken.
	 * @return {@link WebBufferedImageByDriver}
	 * @throws Exception
	 */
	public WebBufferedImageByDriver takeScreen(By crop){
		takeScreen();
		subImage(crop);
		return this;
	}
	
	/**
	 * Take the buffered image of the WebElements with WebDriver.
	 * @param crop1 The By locator of the WebElment to be taken.
	 * @param crops The By locators of the WebElments to be taken.
	 * @return {@link WebBufferedImageByDriver}
	 * @throws Exception
	 */
	public WebBufferedImageByDriver takeScreen(By crop1,By... crops){
		takeScreen();
		Rectangle area = getElementRec(browser.waitFor().found(crop1));
		for(int i=0; i<crops.length; i++){
			BrowserElement element = browser.waitFor().found(crops[0]);
			area = WebImage.expandRectangle(area, getElementRec(element));
		}
		//area.setLocation((int)(browser.frame().getOffset().getX()+area.getX()), (int)(browser.frame().getOffset().getY()+area.getY()));
		subImage(area);
		return this;
	}
	
	public WebBufferedImageByDriver drawEngRectangle(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangle(by);
		}
		return this;
	}
	
	public WebBufferedImageByDriver drawEngRectangle(int adjust,By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangle(adjust,by);
		}
		return this;
	}
	
	public WebBufferedImageByDriver drawEngRectangleInside(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawRedRectangleInside(by);
		}
		return this;
	}
	
	public WebBufferedImageByDriver drawEngCrossOut(By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawBlueCrossOut(by);
		}
		return this;
	}
	
	public WebBufferedImageByDriver drawEngCrossOut(int adjust,By... by){
		if(browser.condition().isLocaleEqualAnyOf(WebLocales.English)){
			drawBlueCrossOut(adjust,by);
		}
		return this;
	}
	
	public WebBufferedImageByDriver subImage(By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement AutoElement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(AutoElement);
		for(int i=1; i<area.length; i++){
			AutoElement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(AutoElement));
		}
		subImage(finalArea);
		locateElement=false;
		return this;
	}
	
	public WebBufferedImageByDriver subImage(int adjust,By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement AutoElement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(AutoElement);
		for(int i=1; i<area.length; i++){
			AutoElement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(AutoElement));
		}
		subImage(WebImage.adjustRectangle(finalArea,adjust));
		return this;
	}
	
	public WebBufferedImageByDriver subImageKeepWidth(By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement AutoElement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(AutoElement);
		for(int i=1; i<area.length; i++){
			AutoElement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(AutoElement));
		}
		subImageKeepWidth((int)finalArea.getY(),(int)finalArea.getHeight());
		return this;
	}
	
	public WebBufferedImageByDriver subImageKeepHeight(By... area){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		if(area.length == 0) throw new WebScreenException("At least on parameter is required.");
		BrowserElement AutoElement = browser.waitFor().found(area[0]);
		Rectangle finalArea = getElementRec(AutoElement);
		for(int i=1; i<area.length; i++){
			AutoElement = browser.waitFor().found(area[i]);
			finalArea = WebImage.expandRectangle(finalArea, getElementRec(AutoElement));
		}
		subImageKeepHeight((int)finalArea.getX(),(int)finalArea.getWidth());
		return this;
	}
	
	private WebBufferedImageByDriver drawRedRectangle(By... by){
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
	
	private WebBufferedImageByDriver drawRedRectangle(int adjust,By... by){
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
	
	private WebBufferedImageByDriver drawRedRectangleInside(By... by){
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
	
	private WebBufferedImageByDriver drawBlueCrossOut(By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
		element = browser.waitFor().found(by[i]);
		area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawBlueCrossOut(area);
		return this;
	}
	
	private WebBufferedImageByDriver drawBlueCrossOut(int adjust,By... by){
		if(!locateElement) throw new ImageModificationNotAllowedException("Element can not be located correctly in the image in current state.");
		BrowserElement element = browser.waitFor().found(by[0]);
		Rectangle area = getElementRec(element);
		for(int i=1; i<by.length; i++){
		element = browser.waitFor().found(by[i]);
		area = WebImage.expandRectangle(area, getElementRec(element));
		}
		drawBlueCrossOut(WebImage.adjustRectangle(area,adjust));
		return this;
	}
	
	private Rectangle getElementRec(BrowserElement AutoElement){
		int x, y, scrollX, scrollY, frameX, frameY;
		x = AutoElement.getLocation().getX();
		y = AutoElement.getLocation().getY();
		scrollX = browser.getScrolledOffset().getX()+browser.frame().getScrolledOffset().getX();
		scrollY = browser.getScrolledOffset().getY()+browser.frame().getScrolledOffset().getY();
		frameX = browser.frame().getOffset().getX();
		frameY = browser.frame().getOffset().getY();
		if (frameX !=  0 || frameY != 0){
			//In sub frame
			if(scrollX !=  0){
				throw new ImageModificationNotAllowedException("Element location inside a frame on a scrolled WebDriver image is unpredictable using WebDriver. Please use Java Robot method.\n"
						+ "Previous Frame scrolledX="+browser.frame().getScrolledOffset().getX()+", Current frame scrolledX="+browser.getScrolledOffset().getX());
			}
			if(scrollY != 0){
				throw new ImageModificationNotAllowedException("Element location inside a frame on a scrolled WebDriver image is unpredictable using WebDriver. Please use Java Robot method.\n"
						+ "Previous Frame scrolledY="+browser.frame().getScrolledOffset().getY()+", Current frame scrolledY="+browser.getScrolledOffset().getY());
			}
			x += frameX;
			y += frameY;
		}
		int width = AutoElement.getSize().getWidth();
		int height = AutoElement.getSize().getHeight();
		Rectangle area =  new Rectangle(x,y, width, height);
		browser.debug().debugScreen("Area = "+area.toString());
		return area;
	}
}
