/**
 *  Buttons are any clickable elements and sometime just with a image. (Found button element without input tag for button attribute value)
 *  Button can be performed with the following actions:
 *  
 *  Click (driver, action, robot)
 *  Browse button (robot only)
 */

package tvt.selenium.core.widget;

import tvt.selenium.core.element.BrowserElement;

public class WebButton {

	private BrowserElement tvtElement;
	
	public WebButton(BrowserElement tvtElement) {
		this.tvtElement = tvtElement;
	}

	public void clickByDriver(){
		tvtElement.actionsByDriver().click();
	}
	
	public void clickByAction(){
		tvtElement.actionsByAction().click();
	}
	
	public void clickByRobot(){
		tvtElement.actionsByRobot().click();
	}
	
	public void browseFileByRobot(String file){
		tvtElement.actionsByRobot().browseFile(file);
	}
}
