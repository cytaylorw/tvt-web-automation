package tvt.selenium.core.widget;

import tvt.selenium.core.element.BrowserElement;

public class WebMouseClickable {

	private BrowserElement tvtElement;
	
	public WebMouseClickable(BrowserElement tvtElement) {
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
	
	public void contextClickByAction(){
		tvtElement.actionsByAction().contextClick();
	}
	
	public void contextClickByRobot(){
		tvtElement.actionsByRobot().contextClick();
	}
	
	public void doubleClickByAction(){
		tvtElement.actionsByAction().doubleClick();
	}
	
	public void doubleClickByRobot(){
		tvtElement.actionsByRobot().doubleClick();
	}
}
