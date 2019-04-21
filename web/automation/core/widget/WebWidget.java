package web.automation.core.widget;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.widget.dijit.WebDijitWidget;

public class WebWidget {

	private BrowserElement autoElement;
	private WebBrowser browser;
	
	public WebWidget(WebBrowser browser,BrowserElement autoElement){
		this.browser=browser;
		this.autoElement = autoElement;
	}
	
	public WebDijitWidget dijit(){
		return new WebDijitWidget(browser,autoElement);
	}
	
	public WebMouseClickable mouseClickable(){
		return new WebMouseClickable(autoElement);
	}
	
	// No verificaiton added to buttons.
	public WebButton button(){
		return new WebButton(autoElement);
	}
	
	// No verificaiton added to buttons.
	public WebTextInputField textInputField(){
		return new WebTextInputField(autoElement);
	}
	
	// Need to have href or url attribute
	public WebLink link(){
		try{
			if(!autoElement.getAttribute("href").isEmpty() || !autoElement.getAttribute("url").isEmpty()){
				return new WebLink(autoElement);
			}
		}catch (NullPointerException e){}
		throw new UnsupportedOperationException("Please make sure the element has 'href' or 'url' attribute and it's not empty");
	}
	
	// Have to be select element
	public WebSelectDropDown selectDropDown(){
		if(autoElement.getTagName().equals("select")){
			return new WebSelectDropDown(browser,autoElement);
		}
		throw new UnsupportedOperationException("Please make sure the element is a select element");
	}
	
	// Have to be select element
	public WebSelectBoxList selectBoxList(){
		if(autoElement.getTagName().equals("select")){
			return new WebSelectBoxList(browser,autoElement);
		}
		throw new UnsupportedOperationException("Please make sure the element is a select element");
	}
}
