package web.automation.core.widget.dijit;

import org.openqa.selenium.By;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;
import web.automation.core.locator.BY;

public class WebDijitCalendar {

	private WebBrowser browser;
	private BrowserElement element;
	private By calendar;
	
	public WebDijitCalendar(WebBrowser webBrowser,BrowserElement browserElement,By calendarMenu){
		browser=webBrowser;
		element=browserElement;	
		calendar=calendarMenu;
	}
	
	public void selectEnableDateByAction(int index){
		element.actionsByAction().click();
		browser.waitFor().displayed(calendar);
		browser.waitFor().enabled(BY.addAsDescendant(calendar, BY.xpath("//*[contains(@class,'dijitCalendarEnabledDate')]["+index+"]"))).actionsByAction().click();
		browser.waitFor().notDisplayed(calendar);
	}
	
	public void selectIndexByAction(int row,int column){
		element.actionsByAction().click();
		browser.waitFor().displayed(calendar);
		browser.waitFor().enabled(BY.addAsDescendant(calendar, BY.xpath("//*[@data-dojo-attach-point='dateRowsNode')]/*["+row+"]/*["+column+"]"))).actionsByAction().click();
		browser.waitFor().notDisplayed(calendar);
	}
}
