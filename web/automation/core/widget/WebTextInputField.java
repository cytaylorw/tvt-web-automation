/**
 * Text input fields are elements which can type text into it. (Found text input field element without input tag for text attribute value) 
 * Text input can be performed with the following actions:
 * 
 * type (driver, action, robot)
 * submit (driver)
 * browse file (driver)
 */

package web.automation.core.widget;

import web.automation.core.element.BrowserElement;

public class WebTextInputField {

	private BrowserElement autoElement;
	
	public WebTextInputField(BrowserElement autoElement) {
		this.autoElement = autoElement;
	}
	
	public void typeByDriver(String text){
		autoElement.actionsByDriver().sendKeys(text);
	}
	
	public void typeByAction(String text){
		autoElement.actionsByAction().sendKeys(text);
	}
	
	public void typeByRobot(String text){
		autoElement.actionsByRobot().sendKeys(text);
	}
	
	public void browserFileByDriver (String file){
		autoElement.actionsByDriver().browseFile(file);
	}
}
