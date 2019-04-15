/**
 * Selects are elements with select tag in the drop-down form which only allow single value selection. 
 * 
 * Select element is recommend to use the select methods from WebDriver. 3rd party will be implemented in another class
 */

package web.automation.core.widget;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

public class WebSelectDropDown {

	private BrowserElement autoElement;
	@SuppressWarnings("unused")
	private WebBrowser browser;
	
	public WebSelectDropDown(WebBrowser browser,BrowserElement autoElement) {
		this.browser=browser;
		this.autoElement = autoElement;
	}
	
	public void selectByIndex(int index){
		autoElement.actionsByDriver().selectByIndex(index);
	}
	
	public void selectByValue(String value){
		autoElement.actionsByDriver().selectByValue(value);
	}
	
	public void selectByText(String text){
		autoElement.actionsByDriver().selectByText(text);
	}
	
	/**
	public void selectByPIIText(String fileName, String id) throws Exception{
		autoElement.actionsByDriver().selectByText(browser.getPII().readString(fileName,id));
	}
	**/
}
