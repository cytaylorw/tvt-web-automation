package web.automation.core.widget.dijit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

public class WebDijitComboBox {

	private WebBrowser browser;
	private BrowserElement element;
	private By menu;
	
	public WebDijitComboBox(WebBrowser webBrowser,BrowserElement browserElement,By comboBoxMenu){
		browser=webBrowser;
		element=browserElement;	
		menu=comboBoxMenu;
	}
	
	public void sendKeysByAction(String text,int menuItem){
		element.actionsByAction().sendKeys(text);
		browser.waitFor().displayed(menu);
		for(int i=0; i<menuItem; i++){
			element.actionsByAction().sendKeys(Keys.ARROW_DOWN);
		}
		element.actionsByAction().sendKeys(Keys.ENTER);
	}
	
	public void sendKeysByAction(String text) throws Exception{
		sendKeysByAction(text,1);
	}
	
	public void sendKeysByRobot(String text,int menuItem){
		element.actionsByRobot().sendKeys(text);
		browser.waitFor().displayed(menu);
		for(int i=0; i<menuItem; i++){
			element.actionsByRobot().sendKeys(Keys.ARROW_DOWN);
		}
		element.actionsByRobot().sendKeys(Keys.ENTER);
	}
	
	public void sendKeysByRobot(String text){
		sendKeysByRobot(text,1);
	}
	
	public void selectByAction(int menuItem) throws Exception{
		element.actionsByAction().sendKeys(Keys.ARROW_DOWN);
		browser.waitFor().displayed(menu);
		for(int i=0; i<menuItem; i++){
			element.actionsByAction().sendKeys(Keys.ARROW_DOWN);
		}
		element.actionsByAction().sendKeys(Keys.ENTER);
	}
	
	public void selectByRobot(int menuItem){
		element.actionsByRobot().sendKeys(Keys.ARROW_DOWN);
		browser.waitFor().displayed(menu);
		for(int i=0; i<menuItem; i++){
			element.actionsByRobot().sendKeys(Keys.ARROW_DOWN);
		}
		element.actionsByRobot().sendKeys(Keys.ENTER);
	}
}
