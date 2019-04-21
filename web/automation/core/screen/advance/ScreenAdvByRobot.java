/**
 * Similar methods in {@link ScreenAdvByDriver} and {@link ScreenAdvByAction} but by Java Robot.
 * @author Taylor Wong
 */
package web.automation.core.screen.advance;

import java.awt.image.BufferedImage;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import web.automation.core.browser.WebBrowser;
import web.automation.core.browser.handle.WebBrowserAlert;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.image.CompareImageFailureException;
import web.automation.core.locale.WebLocales;
import web.automation.core.screen.WebScreen;
import web.automation.core.screen.image.WebBufferedImage;
import web.automation.core.screen.image.WebBufferedImageByRobot;
import web.automation.core.tool.WebImage;

public class ScreenAdvByRobot {

	private WebScreen screen;
	private WebBrowser browser;
	
	public ScreenAdvByRobot(WebBrowser browser,WebScreen screen){
		this.browser = browser;
		this.screen = screen;
	}
	
	/**
	 * Save the browser screen taken with Java Robot.
	 * @param fileName  The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 */
	public void saveScreen(String fileName){
		screen.delay().bufferedImageByRobot().takeScreen().saveImage(fileName);
	}
	
	/**
	 * Save the WebElement in a image taken with Java Robot. Make sure the WebElement is in the viewport.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param crop The By locator of the WebElment to be taken.
	 */
	public void saveScreen(String fileName,By crop){
		screen.delay().bufferedImageByRobot().takeScreen(crop).saveImage(fileName);
	}
	
	public void saveScreen(String fileName,By crop,By... crops){
		screen.delay().bufferedImageByRobot().takeScreen(crop,crops).saveImage(fileName);
	}
	
	public void saveScreenWithEngRec(String fileName,By... rec){
		if(browser.getLocale().equals(WebLocales.English)){
			screen.delay().bufferedImageByRobot().takeScreen().drawEngRectangle(rec).saveImage(fileName);
		}else{
			saveScreen(fileName);
		}
	}
	
	/**
	 * Save the screen taken by Java Robot with title tooltips at the bottom. Please see {@link WebBufferedImage#addTitleTooltip(By...)} for limitation.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param tooltip The By locators for the WebElement with title attribute.
	 */
	public void saveScreenWithTitleTooltip(String fileName,By... tooltip){
		if(tooltip.length == 0)throw new IllegalArgumentException("Please specify at least one tooltip");
		screen.delay().bufferedImageByRobot().takeScreen().addTitleTooltip(tooltip).saveImage(fileName);
	}
	
	/**
	 * Save the screen taken by Java Robot with select options at the bottom.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param select The By locator for the select WebElement.
	 */
	public void saveScreenWithSelectOptions(String fileName,By select){
		screen.delay().bufferedImageByRobot().takeScreen().addSelectOptions(select).saveImage(fileName);
	}
	
	/**
	 * Save the tooltip by hover on hoverTarget and wait for the WebElement screen to be different. Save with full screen since browser tooltip can overlaps with task bar.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param compareArea The By locator for the compare area. Only for comparison.
	 */
	public void saveTooltipByCompareImage (String fileName,By hoverTarget,By compareArea){
		BufferedImage img1,img2;
		if(compareArea == null){
			img1=browser.screen().delay().bufferedImageByRobot().takeScreen().getImage();
		}else{
			img1=browser.screen().delay().bufferedImageByRobot().takeScreen(compareArea).getImage();
		}
	    int tooltipDelay = screen.getDelay()*10;
		//Must be a delay here to wait for the tooltip.
		if(tooltipDelay<1000)tooltipDelay = 1000;
		int i = 0;
	    do{
	    	if(i%3 == 0){
	    		browser.waitFor().displayed(hoverTarget).actionsByRobot().move(-1,-1);
	    		//screen.browser.waitFor().displayed(hoverTarget).actionsByRobot().move(1,1);
	    	}
	    	if(i*tooltipDelay > browser.getAutoProfile().getWaitTime()*1000) {
	    		
	    		throw new CompareImageFailureException(fileName+": "+hoverTarget.toString()+": Fail to capture tooltip within waitTime");
	    	}
	    	browser.waitFor().displayed(hoverTarget).actionsByRobot().move();
	    	if(compareArea == null){
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen().getImage();
			}else{
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen(compareArea).getImage();
			}
			i++;
	    		    	
	    }while (WebImage.compareImage(img1, img2));
	    //Browser tooltip can overlaps with window taskbar so taking the whole screen here
	    screen.delay(tooltipDelay/2).bufferedImageByRobot().takeFullScreen().saveImage(fileName);
	    moveOff();
	}
	
	/**
	 * Save the tooltip by hover on hoverTarget and wait for the browser screen to be different. Save with full screen.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 */
	public void saveTooltipByCompareImage (String fileName, By hoverTarget){
		saveTooltipByCompareImage (fileName, hoverTarget, null);
	}
	
	/**
	 * 
	 * @param fileName fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param heightMultiplier The multiplier to the height of the hover target WebElement.
	 */
	public void saveTooltipOnlyByCompareImage (String fileName,By hoverTarget,int heightMultiplier){
		BufferedImage img1,img2;
		
		img1=browser.screen().delay().bufferedImageByRobot().takeTooltip(hoverTarget,heightMultiplier).getImage();

	    int tooltipDelay = screen.getDelay()*10;
		//Must be a delay here to wait for the tooltip.
		if(tooltipDelay<1000)tooltipDelay = 1000;
		int i = 0;
	    do{
	    	if(i%3 == 0){
	    		browser.waitFor().displayed(hoverTarget).actionsByRobot().move(-1,-1);
	    		//screen.browser.waitFor().displayed(hoverTarget).actionsByRobot().move(1,1);
	    	}
	    	if(i*tooltipDelay > browser.getAutoProfile().getWaitTime()*1000) {
	    		
	    		throw new CompareImageFailureException(fileName+": "+hoverTarget.toString()+": Fail to capture tooltip within waitTime");
	    	}
	    	browser.waitFor().displayed(hoverTarget).actionsByRobot().move();
	    	img2=browser.screen().delay().bufferedImageByRobot().takeTooltip(hoverTarget,heightMultiplier).getImage();
			i++;
	    		    	
	    }while (WebImage.compareImage(img1, img2));
	    //Browser tooltip can overlaps with window taskbar so taking the whole screen here
	    screen.delay(tooltipDelay/2).bufferedImageByRobot().takeTooltip(hoverTarget,heightMultiplier).saveImage(fileName);
	    moveOff();
	}
	
	/**
	 * Save the tooltip by hovering on hoverTarget then wait for tooltip WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param tooltip The By locator for the tooltip WebElement.
	 */
	public void saveTooltipWhenDisplayed (String fileName,By hoverTarget,By tooltip){
		
		browser.waitFor().displayed(hoverTarget).actionsByRobot().move();
		browser.waitFor().displayed(tooltip);
		screen.delay().bufferedImageByRobot().takeScreen().saveImage(fileName);
		moveOff();
		browser.waitFor().notDisplayed(tooltip);
	}
	/**
	 * Save only the tooltip by hovering on hoverTarget then wait for tooltip WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param tooltip The By locator for the tooltip WebElement.
	 */
	public void saveTooltipOnlyWhenDisplayed (String fileName, By hoverTarget, By tooltip){
		
		browser.waitFor().displayed(hoverTarget).actionsByRobot().move();
		browser.waitFor().displayed(tooltip);
		screen.delay().bufferedImageByRobot().takeScreen(hoverTarget,tooltip).saveImage(fileName);
		moveOff();
		browser.waitFor().notDisplayed(tooltip);
	}
	
	/**
	 * Save the options by click then add options to the bottom. Use this method if the option drop-down contains hidden cells with text.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 * @param textPattern The By locator for the options elements containing the valid option text.
	 */
	public void saveOptionsByClickThenAddText (String fileName,By clickTarget,By option,By textPattern){
		
		WebBufferedImageByRobot AutoImag = screen.delay().bufferedImageByRobot().takeScreen();
		browser.waitFor().displayed(clickTarget).actionsByRobot().click();
		browser.waitFor().displayed(option);
		List<BrowserElement> options = browser.find().elements(textPattern);
		AutoImag.addElementsText(options).saveImage(fileName);
		moveOff();
	}
	
	/**
	 * Save the options by click then add options to the bottom. Use this method if the option drop-down does not contains hidden cells with text.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 */
	public void saveOptionsOnlyByClickThenAddText (String fileName,By clickTarget,By option,By textPattern){
		
		WebBufferedImageByRobot AutoImag = screen.delay().bufferedImageByRobot().takeScreen(clickTarget);
		browser.waitFor().displayed(clickTarget).actionsByRobot().click();
		browser.waitFor().displayed(option);
		List<BrowserElement> options = browser.find().elements(textPattern);
		AutoImag.addElementsText(options).saveImage(fileName);
		moveOff();
	}
	
	/**
	 * Save the option by click and wait for the drop-down WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 */
	public void saveOptionsByClickThenDisplayed (String fileName,By clickTarget,By option){
		
		browser.waitFor().displayed(clickTarget).actionsByRobot().click();
		browser.waitFor().displayed(option);
		screen.delay().bufferedImageByRobot().takeScreen().saveImage(fileName);
		moveOff();
	}
	
	/**
	 * Save the scrolling WebElement by pressing page down key. Please make sure the focus is on the scrolling WebElement.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param crop The By locator of the WebElment to be taken.
	 */
	public void saveScrollingScreenByPgDn (String fileName,By crop){
		
		BufferedImage img1,img2;
		if(crop == null){
			img1=browser.screen().delay().bufferedImageByRobot().takeScreen().getImage();
		}else{
			img1=browser.screen().delay().bufferedImageByRobot().takeScreen(crop).getImage();
		}
		int scollDelay = screen.getDelay()*3;
		//Must be a delay to wait for the screen refresh after scrolling.
		if(scollDelay<300)scollDelay=300;
		int i;
		for (i=1;;i++){
			browser.actionsByRobot().key(Keys.PAGE_DOWN);
		    if(crop == null){
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen().getImage();
			}else{
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen(crop).getImage();
			}
		    if (!WebImage.compareImage(img1, img2)){
		    	screen.saveImage(img1,fileName+"_"+i);
		    	img1=img2;
		    }else{
		    	if(i==1)screen.saveImage(img1,fileName);
		    	break;
		    }
		}
		if(i==1){
	    	screen.saveImage(img1,fileName);
	    }else{
	    	screen.saveImage(img1,fileName+"_"+i);
	    }
	}
	
	/**
	 * Save the scrolling page by pressing page down key. Please make sure the focus is on the scrolling page.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 */
	public void saveScrollingScreenByPgDn (String fileName){
		saveScrollingScreenByPgDn (fileName, null);
	}
	
	/**
	 * Save the browser alert.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @return {@link WebBrowserAlert}
	 */
	public WebBrowserAlert saveBrowserAlert (String fileName){
		WebBrowserAlert alert = browser.waitFor().alertPresent();
		screen.delay().bufferedImageByRobot().takeFullScreen().saveImage(fileName);
		return alert;
	}
	
	public void saveScreenWithHeaderTitle(String fileName){
		screen.bufferedImageByRobot().takeScreen().addHeaderTitle().saveImage(fileName);
	}
	
	private void moveOff(){
		browser.actionsByRobot().move(1,1);
	}
}
