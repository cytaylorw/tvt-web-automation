/**
 * Text input fields are elements which can type text into it. (Found text input field element without input tag for text attribute value) 
 * Text input can be performed with the following actions:
 * 
 * type (driver, action, robot)
 * submit (driver)
 * browse file (driver)
 */

package tvt.selenium.core.widget;

import tvt.selenium.core.element.BrowserElement;

public class WebTextInputField {

	private BrowserElement tvtElement;
	
	public WebTextInputField(BrowserElement tvtElement) {
		this.tvtElement = tvtElement;
	}
	
	public void typeByDriver(String text){
		tvtElement.actionsByDriver().sendKeys(text);
	}
	
	public void typeByAction(String text){
		tvtElement.actionsByAction().sendKeys(text);
	}
	
	public void typeByRobot(String text){
		tvtElement.actionsByRobot().sendKeys(text);
	}
	
	public void browserFileByDriver (String file){
		tvtElement.actionsByDriver().browseFile(file);
	}
}
