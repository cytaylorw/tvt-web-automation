/**
 * Links are elements with url or href attribute. 
 * Link can be performed with the following actions:
 * 
 * click (driver, action, robot)
 * 
 * 
 */

package tvt.selenium.core.widget;

import tvt.selenium.core.element.BrowserElement;

public class WebLink {
	
	private BrowserElement tvtElement;
	
	public WebLink(BrowserElement tvtElement) {
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
	
}
