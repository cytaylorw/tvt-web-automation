/**
 * Take screen capture with WebDriver. Add widget (tooltip, select option, etc.) text by WebDriver method.
 * @author Taylor Wong
 */
package tvt.selenium.core.screen.advance;

import org.openqa.selenium.By;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.locale.WebLocales;
import tvt.selenium.core.screen.WebScreen;
import tvt.selenium.core.screen.image.WebBufferedImage;

public class ScreenAdvByDriver {

	private WebScreen screen;
	private WebBrowser browser;
	
	public ScreenAdvByDriver(WebBrowser browser,WebScreen screen){
		this.browser = browser;
		this.screen = screen;
	}
	
	/**
	 * Save the screen taken with WebDriver.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @throws Exception
	 */
	public void saveScreen(String fileName){
		screen.delay().bufferedImageByDriver().takeScreen().saveImage(fileName);
	}
	
	/**
	 * Save the WebElement in a image taken with WebDriver. 
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param crop The By locator of the WebElment to be taken.
	 * @throws Exception
	 */
	public void saveScreen(String fileName,By crop){
		screen.delay().bufferedImageByDriver().takeScreen(crop).saveImage(fileName);
	}
	
	public void saveScreen(String fileName,By crop,By... crops){
		screen.delay().bufferedImageByDriver().takeScreen(crop,crops).saveImage(fileName);
	}
	
	public void saveScreenWithEngRec(String fileName,By... rec){
		if(browser.getLocale().equals(WebLocales.English)){
			screen.delay().bufferedImageByDriver().takeScreen().drawEngRectangle(rec).saveImage(fileName);
		}else{
			saveScreen(fileName);
		}
	}
	
	/**
	 * Save the screen taken by WebDriver with title tooltips at the bottom. Please see {@link WebBufferedImage#addTitleTooltip(By...)} for limitation.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param tooltip The By locators for the WebElement with title attribute.
	 * @throws Exception
	 */
	public void saveScreenWithTitleTooltip(String fileName,By... tooltipTitle){
		if(tooltipTitle.length == 0)throw new IllegalArgumentException("Please specify at least one tooltip");
		screen.delay().bufferedImageByDriver().takeScreen().addTitleTooltip(tooltipTitle).saveImage(fileName);
	}
	
	/**
	 * Save the WebElement taken by WebDriver with title tooltip at the bottom. Please see {@link WebBufferedImage#addTitleTooltip(By...)} for limitation.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param tooltip The By locator for the WebElement with title attribute.
	 * @throws Exception
	 */
	public void saveTitleTooltip(String fileName, By tooltipTitle){
		screen.bufferedImageByDriver().takeScreen(tooltipTitle).addTitleTooltip(tooltipTitle).saveImage(fileName);
	}
	
	/**
	 * Save the screen taken by WebDriver with select options at the bottom.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param select The By locator for the select WebElement.
	 * @throws Exception
	 */
	public void saveScreenWithSelectOptions(String fileName, By select){
		screen.delay().bufferedImageByDriver().takeScreen().addSelectOptions(select).saveImage(fileName);
	}
	
	/**
	 * Save the WebElement taken by WebDriver with select options at the bottom.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param select The By locator for the select WebElement.
	 * @throws Exception
	 */
	public void saveSelectOptions(String fileName,By select){
		screen.bufferedImageByDriver().takeScreen(select).addSelectOptions(select).saveImage(fileName);
	}
	
	public void saveScreenWithHeaderTitle(String fileName){
		screen.bufferedImageByDriver().takeScreen().addHeaderTitle().saveImage(fileName);
	}
	
	public void saveHeaderTitle(String fileName){
		screen.bufferedImageByDriver().createHeaderTitle().saveImage(fileName);
	}
}
