package tvt.selenium.core.locator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;

public class WebLocator {

	WebBrowser browser;
	
	public WebLocator(WebBrowser browser){
		this.browser = browser;
	}
	
	/**
	 * Find the WebElement and return in <code>BrowserElement</code>.
	 * @param byLocator By locator from WebDriver for a single WebElement.
	 * @return BrowserElement which contains WebElement and related methods. Please see {@link BrowserElement}.
	 */
	public BrowserElement element(By byLocator){
		return new BrowserElement(browser,byLocator);
	}
	
	/**
	 * Find the list of WebElements and return in <code>BrowserElement</code>.
	 * @param byLocator By locator from WebDriver for more than one WebElement.
	 * @return BrowserElement which contains WebElement and related methods. Please see {@link BrowserElement}.
	 */
	public List<BrowserElement> elements(By byLocator){
		List<BrowserElement> tvtList = new ArrayList<BrowserElement>();
		List<WebElement> elementList = browser.getWebDriver().findElements(byLocator);
		for(int i=0;i<elementList.size(); i++){
			tvtList.add(new BrowserElement(browser,elementList.get(i)));
		}
		return tvtList;
	}
	
	public XPathLocator xpath(){
		return new XPathLocator(browser);
	}
}
