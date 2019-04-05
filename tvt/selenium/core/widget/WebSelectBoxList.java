/**
 * Selects are elements with select tag in the box list form which might allow multiple values selection.
 * 
 * Select element is recommend to use the select methods from WebDriver. 3rd party will be implemented in another class
 */

package tvt.selenium.core.widget;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;

public class WebSelectBoxList {

	private BrowserElement tvtElement;
	@SuppressWarnings("unused")
	private WebBrowser browser;
	
	public WebSelectBoxList(WebBrowser browser,BrowserElement tvtElement) {
		this.browser=browser;
		this.tvtElement = tvtElement;
	}
	
	public void selectByIndex(int... index){
		tvtElement.actionsByDriver().selectByIndex(index);
	}
	
	public void selectByValue(String... value){
		tvtElement.actionsByDriver().selectByValue(value);
	}
	
	public void selectByText(String... text){
		tvtElement.actionsByDriver().selectByText(text);
	}
	
	public void selectAll(){
		tvtElement.actionsByDriver().selectAll();
	}
	
	/**
	public void selectByPIIText(String fileName, String... id){
		List<String> piiText = new ArrayList<String>();
		for(int i=0;i<id.length;i++){
			piiText.add(browser.getPII().readString(fileName,id[i]));
		}
		tvtElement.actionsByDriver().selectByText(piiText.toArray(new String[piiText.size()]));
	}
	**/
}
