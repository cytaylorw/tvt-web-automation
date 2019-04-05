package tvt.selenium.core.widget.dijit;

import org.openqa.selenium.By;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;

public class WebDijitWidget {

	private BrowserElement tvtElement;
	private WebBrowser browser;
	
	public WebDijitWidget(WebBrowser browser,BrowserElement tvtElement){
		this.browser=browser;
		this.tvtElement = tvtElement;
	}
	
	public WebDijitComboBox comboBoxInput(By comboBoxMenu){
		return new WebDijitComboBox(browser,tvtElement,comboBoxMenu);
	}
	
	public WebDijitCalendar calendarButton(By calendarMenu){
		return new WebDijitCalendar(browser,tvtElement,calendarMenu);
	}
}
