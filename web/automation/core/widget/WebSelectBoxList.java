/**
 * Selects are elements with select tag in the box list form which might allow multiple values selection.
 * 
 * Select element is recommend to use the select methods from WebDriver. 3rd party will be implemented in another class
 */

package web.automation.core.widget;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

public class WebSelectBoxList {

	private BrowserElement autoElement;
	@SuppressWarnings("unused")
	private WebBrowser browser;
	
	public WebSelectBoxList(WebBrowser browser,BrowserElement autoElement) {
		this.browser=browser;
		this.autoElement = autoElement;
	}
	
	public void selectByIndex(int... index){
		autoElement.actionsByDriver().selectByIndex(index);
	}
	
	public void selectByValue(String... value){
		autoElement.actionsByDriver().selectByValue(value);
	}
	
	public void selectByText(String... text){
		autoElement.actionsByDriver().selectByText(text);
	}
	
	public void selectAll(){
		autoElement.actionsByDriver().selectAll();
	}
	
	/**
	public void selectByPIIText(String fileName, String... id){
		List<String> piiText = new ArrayList<String>();
		for(int i=0;i<id.length;i++){
			piiText.add(browser.getPII().readString(fileName,id[i]));
		}
		autoElement.actionsByDriver().selectByText(piiText.toArray(new String[piiText.size()]));
	}
	**/
}
