/**
 *  Buttons are any clickable elements and sometime just with a image. (Found button element without input tag for button attribute value)
 *  Button can be performed with the following actions:
 *  
 *  Click (driver, action, robot)
 *  Browse button (robot only)
 */

package web.automation.core.widget;

import web.automation.core.element.BrowserElement;

public class WebButton {

	private BrowserElement autoElement;
	
	public WebButton(BrowserElement autoElement) {
		this.autoElement = autoElement;
	}

	public void clickByDriver(){
		autoElement.actionsByDriver().click();
	}
	
	public void clickByAction(){
		autoElement.actionsByAction().click();
	}
	
	public void clickByRobot(){
		autoElement.actionsByRobot().click();
	}
	
	public void browseFileByRobot(String file){
		autoElement.actionsByRobot().browseFile(file);
	}
}
