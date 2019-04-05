/**
 * Managing browse frame and calculate the Java Robot offset result from frame switching.
 * @author Administrator
 */
package tvt.selenium.core.browser.handle;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;

public class WebBrowserFrame {

	private WebBrowser browser;
	private List<WebElement> frames;
	private Point frameOffset;
	private Point scrollOffset;
	
	
	/**
	 * WebBrowserFrame is initialized in the WebBrowser constructor and binded to the WebBrowser.
	 * @param browser {@link WebBrowser}
	 * @throws Exception 
	 */
	public WebBrowserFrame(WebBrowser browser){
		this.browser=browser;
		defaultContent();
	}
	
	/**
	 * Switch the frame to the default content and set all frame related offsets to (0,0).
	 * @return {@link WebBrowserFrame}
	 * @throws Exception 
	 */
	public WebBrowserFrame defaultContent(){
		browser.getWebDriver().switchTo().defaultContent();
		frames = new ArrayList<WebElement>();
		clearFrameOffset();
		clearScrolledOffset();
		return this;
	}
	
	/**
	 * Add the current frame scrolled offset and the new frame location to frame offset. Then switch to it.
	 * @param saveScolled Set true to add the current frame scrolled offset.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link WebBrowserFrame}
	 * @throws Exception
	 */
	public WebBrowserFrame switchTo(boolean saveScolled,By byLocator){
		if(saveScolled){
			addToScrolledOffset(browser.getScrolledOffset());
			browser.debug().debugBrowser("Frame scrolled offset: "+scrollOffset);
		}
		WebElement current=browser.waitFor().found(byLocator).getWebElement();
		Point location = current.getLocation();
		if(browser.robotSetup() != null){
			frames.add(current);
			browser.debug().debugBrowser("Frame location: "+location);
			addToFrameOffset(location);
			browser.debug().debugBrowser("Frame offset: "+frameOffset);
		}
		browser.getWebDriver().switchTo().frame(current);
		return this;
	}
	
	/**
	 * Add the new frame location to frame offset. Then switch to it.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return {@link WebBrowserFrame}
	 * @throws Exception
	 */
	public WebBrowserFrame switchTo(By byLocator){
		return switchTo(false,byLocator);
	}
	
	/**
	 * Get the current browser frame offset.
	 * @return The current browser frame offset.
	 */
	public Point getOffset(){
		return frameOffset;
	}
	
	/**
	 * Get the current browser scrolled offset stored from previous frames.
	 * @return The scrolled offset stored from previous frames.
	 */
	public Point getScrolledOffset(){
		return scrollOffset;
	}
	
	/**
	 * Set frame offset to (0,0).
	 */
	private void clearFrameOffset(){
		frameOffset = new Point(0,0);
	}
	
	/**
	 * Add the frame location to frame offset.
	 * @param frameLocation The frame location to be switched to.
	 */
	private void addToFrameOffset(Point frameLocation){
		frameOffset.x += frameLocation.getX();
		frameOffset.y += frameLocation.getY();
	}
	
	private void clearScrolledOffset(){
		scrollOffset = new Point(0,0);
	}
	
	private void addToScrolledOffset(Point scrolled){
		scrollOffset.x += scrolled.getX();
		scrollOffset.y += scrolled.getY();
	}
}
