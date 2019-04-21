/**
 * Do some actions by WebDriver Actions then take screen capture(s) with WebDriver.
 * @author Taylor Wong
 */
package web.automation.core.screen.advance;

import java.awt.image.BufferedImage;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.exception.image.CompareImageFailureException;
import web.automation.core.screen.WebScreen;
import web.automation.core.screen.image.WebBufferedImageByDriver;
import web.automation.core.tool.WebImage;

public class ScreenAdvByAction {

	private WebScreen screen;
	private WebBrowser browser;
	
	public ScreenAdvByAction(WebBrowser browser,WebScreen screen){
		this.browser = browser;
		this.screen = screen;
	}
	
	/**
	 * Save the tooltip by hovering on the hoverTarget then wait for tooltip WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param tooltip The By locator for the tooltip WebElement.
	 * @throws Exception
	 */
	public void saveTooltipWhenDisplayed (String fileName,By hoverTarget,By tooltip){
		
		browser.waitFor().displayed(hoverTarget).actionsByAction().move();
		browser.waitFor().displayed(tooltip);
		screen.delay().bufferedImageByDriver().takeScreen().saveImage(fileName);
	}
	
	/**
	 * Save only the tooltip by hovering on the hoverTarget then wait for tooltip WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param tooltip The By locator for the tooltip WebElement.
	 * @throws Exception
	 */
	public void saveTooltipOnlyWhenDisplayed (String fileName,By hoverTarget,By tooltip){
		
		browser.waitFor().displayed(hoverTarget).actionsByAction().move();
		browser.waitFor().displayed(tooltip);
		screen.delay().bufferedImageByDriver().takeScreen(hoverTarget,tooltip).saveImage(fileName);
		browser.waitFor().displayed(hoverTarget).actionsByAction().move(-1,-1);
		browser.waitFor().notDisplayed(tooltip);
	}
	
	/**
	 * Save the tooltip by hover on hoverTarget and wait for the WebElement screen to be different. Save with the full screen taken by WebDriver.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @param compareArea The By locator for the compare area. Only for comparison.
	 * @throws Exception
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
	    	if(i*tooltipDelay > browser.getAutoProfile().getWaitTime()*1000) {
	    		
	    		throw new CompareImageFailureException(fileName+": "+hoverTarget.toString()+": Fail to capture tooltip by comparison within waitTime");
	    	}
	    	browser.waitFor().displayed(hoverTarget).actionsByAction().move();
	    	if(compareArea == null){
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen().getImage();
			}else{
				img2=browser.screen().delay().bufferedImageByRobot().takeScreen(compareArea).getImage();
			}
			i++;
	    		    	
	    }while (WebImage.compareImage(img1, img2));
	    screen.delay(tooltipDelay/2).bufferedImageByDriver().takeScreen().saveImage(fileName);
	    browser.waitFor().displayed(hoverTarget).actionsByAction().move(-1,-1);
	    browser.screen().delay();
	}
	
	/**
	 * Save the tooltip by hover on hoverTarget with WebDriver Actions and wait for the screen to be different.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param hoverTarget The By locator for the hover target WebElement.
	 * @throws Exception
	 */
	public void saveTooltipByCompareImage (String fileName,By hoverTarget){
		saveTooltipByCompareImage (fileName, hoverTarget, null);
	}
	
	/**
	 * Save the options by click then add options to the bottom. Use this method if the option drop-down contains hidden cells with text.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 * @param textElement The By locator for the options elements containing the valid option text.
	 * @throws Exception
	 */
	public void saveOptionsByClickThenAddText (String fileName,By clickTarget,By option,By textElements){
		
		WebBufferedImageByDriver AutoImag = screen.delay().bufferedImageByDriver().takeScreen();
		browser.waitFor().displayed(clickTarget).actionsByAction().click();
		browser.waitFor().displayed(option);
		List<BrowserElement> options = browser.find().elements(textElements);
		AutoImag.addElementsText(options).saveImage(fileName);
	}
	
	/**
	 * Save the options by click then add options to the bottom. Use this method if the option drop-down does not contains hidden cells with text.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 * @throws Exception
	 */
	public void saveOptionsOnlyByClickThenAddText (String fileName,By clickTarget,By option,By textElements) throws Exception{
		
		WebBufferedImageByDriver AutoImag = screen.delay().bufferedImageByDriver().takeScreen(clickTarget);
		browser.waitFor().displayed(clickTarget).actionsByAction().click();
		browser.waitFor().displayed(option);
		List<BrowserElement> options = browser.find().elements(textElements);
		AutoImag.addElementsText(options).saveImage(fileName);
	}
	
	/**
	 * Save the option by click and wait for the drop-down WebElement to display.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param clickTarget The By locator for the clicking target WebElement.
	 * @param option The By locator for the option drop-down appeared after clicking.
	 * @throws Exception
	 */
	public void saveOptionsByClickThenDisplayed (String fileName,By clickTarget,By option){
		
		browser.waitFor().displayed(clickTarget).actionsByAction().click();
		browser.waitFor().displayed(option);
		screen.delay().bufferedImageByDriver().takeScreen().saveImage(fileName);
	}
	
	/**
	 * Save the scrolling WebElement by pressing page down key. Please make sure the focus is on the scrolling WebElement.
	 * @param fileName The file name prefix for the image. Please see {@link WebScreen#saveImage(java.awt.image.BufferedImage, String)}
	 * @param crop The By locator of the WebElment to be taken.
	 * @throws Exception
	 */
	public void saveScrollingScreenByPgDn (String fileName,By crop){
		
		BufferedImage img1,img2;
		if(crop == null){
			img1=browser.screen().delay().bufferedImageByDriver().takeScreen().getImage();
		}else{
			img1=browser.screen().delay().bufferedImageByDriver().takeScreen(crop).getImage();
		}
		int scollDelay = screen.getDelay()*3;
		//Must be a delay to wait for the screen refresh after scrolling.
		if(scollDelay<300)scollDelay=300;
		int i;
		for (i=1;;i++){
			browser.actionsByAction().key(Keys.PAGE_DOWN);
			if(crop == null){
				img2=browser.screen().delay().bufferedImageByDriver().takeScreen().getImage();
			}else{
				img2=browser.screen().delay().bufferedImageByDriver().takeScreen(crop).getImage();
			}
		    if (!WebImage.compareImage(img1, img2)){
		    	screen.saveImage(img1,fileName+"_"+i);
		    	img1=img2;
		    }else{
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
	 * @throws Exception
	 */
	public void saveScrollingScreenByPgDn (String fileName){
		saveScrollingScreenByPgDn(fileName, null);
	}
}
