/**
 * Selects are elements with select tag in the drop-down form which only allow single value selection. 
 * 
 * Select element is recommend to use the select methods from WebDriver. 3rd party will be implemented in another class
 */

package tvt.selenium.core.widget;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;

public class WebSelectDropDown {

	private BrowserElement tvtElement;
	@SuppressWarnings("unused")
	private WebBrowser browser;
	
	public WebSelectDropDown(WebBrowser browser,BrowserElement tvtElement) {
		this.browser=browser;
		this.tvtElement = tvtElement;
	}
	
	public void selectByIndex(int index){
		tvtElement.actionsByDriver().selectByIndex(index);
	}
	
	public void selectByValue(String value){
		tvtElement.actionsByDriver().selectByValue(value);
	}
	
	public void selectByText(String text){
		tvtElement.actionsByDriver().selectByText(text);
	}
	
	/**
	public void selectByPIIText(String fileName, String id) throws Exception{
		tvtElement.actionsByDriver().selectByText(browser.getPII().readString(fileName,id));
	}
	**/
}
