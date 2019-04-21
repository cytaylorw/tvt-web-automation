/**
 * Links are elements with url or href attribute. 
 * Link can be performed with the following actions:
 * 
 * click (driver, action, robot)
 * 
 * 
 */

package web.automation.core.widget;

import web.automation.core.element.BrowserElement;

public class WebLink {
	
	private BrowserElement autoElement;
	
	public WebLink(BrowserElement autoElement) {
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
	
}
