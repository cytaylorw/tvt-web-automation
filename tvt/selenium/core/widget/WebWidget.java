package tvt.selenium.core.widget;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.widget.dijit.WebDijitWidget;

public class WebWidget {

	private BrowserElement tvtElement;
	private WebBrowser browser;
	
	public WebWidget(WebBrowser browser,BrowserElement tvtElement){
		this.browser=browser;
		this.tvtElement = tvtElement;
	}
	
	public WebDijitWidget dijit(){
		return new WebDijitWidget(browser,tvtElement);
	}
	
	public WebMouseClickable mouseClickable(){
		return new WebMouseClickable(tvtElement);
	}
	
	// No verificaiton added to buttons.
	public WebButton button(){
		return new WebButton(tvtElement);
	}
	
	// No verificaiton added to buttons.
	public WebTextInputField textInputField(){
		return new WebTextInputField(tvtElement);
	}
	
	// Need to have href or url attribute
	public WebLink link(){
		try{
			if(!tvtElement.getAttribute("href").isEmpty() || !tvtElement.getAttribute("url").isEmpty()){
				return new WebLink(tvtElement);
			}
		}catch (NullPointerException e){}
		throw new UnsupportedOperationException("Please make sure the element has 'href' or 'url' attribute and it's not empty");
	}
	
	// Have to be select element
	public WebSelectDropDown selectDropDown(){
		if(tvtElement.getTagName().equals("select")){
			return new WebSelectDropDown(browser,tvtElement);
		}
		throw new UnsupportedOperationException("Please make sure the element is a select element");
	}
	
	// Have to be select element
	public WebSelectBoxList selectBoxList(){
		if(tvtElement.getTagName().equals("select")){
			return new WebSelectBoxList(browser,tvtElement);
		}
		throw new UnsupportedOperationException("Please make sure the element is a select element");
	}
}
