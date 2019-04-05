/**
 * Scroll on a WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.element.action;

import org.openqa.selenium.By;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.tool.WebJavaScript;

public class ElementScroll {

	private BrowserElement element;
	private WebBrowser browser;
	private int delay;
	private WebJavaScript js;
	
	public ElementScroll(WebBrowser browser, BrowserElement element,int time) {
		this.browser = browser;
		this.element = element;
		delay = time;
		js = new WebJavaScript(browser);
	}
	
	public BrowserElement defaultOffset(){
		js.scrollLeft(element,0);
		js.scrollTop(element,0);
		return element.delay(delay);
	}
	
	public BrowserElement intoView(By locator){
		BrowserElement child = browser.waitFor().found(locator);
		if(element.condition().isHorizontalScrollBar()){
			js.scrollLeft(element,js.offsetLeft(child));
		}
		if(element.condition().isVerticalScrollBar()){
			js.scrollTop(element,js.offsetTop(child));
		}
		return element.delay(delay);
	}
	
	public BrowserElement setScrollTop(int scrollTop){
		js.scrollTop(element,scrollTop);
		return element.delay(delay);
	}
	
	public BrowserElement topMax(){
		js.scrollTopMax(element);
		return element.delay(delay);
	}
	
	public BrowserElement setScrollLeft(int scrollLeft){
		js.scrollLeft(element,scrollLeft);
		return element.delay(delay);
	}
	
	public BrowserElement leftMax(){
		js.scrollLeftMax(element);
		return element.delay(delay);
	}
}
