package web.automation.core.widget;

import web.automation.core.element.BrowserElement;

public class WebMouseClickable {

	private BrowserElement autoElement;
	
	public WebMouseClickable(BrowserElement autoElement) {
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
	
	public void contextClickByAction(){
		autoElement.actionsByAction().contextClick();
	}
	
	public void contextClickByRobot(){
		autoElement.actionsByRobot().contextClick();
	}
	
	public void doubleClickByAction(){
		autoElement.actionsByAction().doubleClick();
	}
	
	public void doubleClickByRobot(){
		autoElement.actionsByRobot().doubleClick();
	}
}
