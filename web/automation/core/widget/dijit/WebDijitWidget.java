package web.automation.core.widget.dijit;

import org.openqa.selenium.By;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

public class WebDijitWidget {

	private BrowserElement autoElement;
	private WebBrowser browser;
	
	public WebDijitWidget(WebBrowser browser,BrowserElement autoElement){
		this.browser=browser;
		this.autoElement = autoElement;
	}
	
	public WebDijitComboBox comboBoxInput(By comboBoxMenu){
		return new WebDijitComboBox(browser,autoElement,comboBoxMenu);
	}
	
	public WebDijitCalendar calendarButton(By calendarMenu){
		return new WebDijitCalendar(browser,autoElement,calendarMenu);
	}
}
