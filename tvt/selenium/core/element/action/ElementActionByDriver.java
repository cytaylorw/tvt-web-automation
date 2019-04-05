/**
 * WebDriver actions on a WebElement.
 * @author Taylor Wong
 */
package tvt.selenium.core.element.action;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;

public class ElementActionByDriver {

	private BrowserElement element;
	@SuppressWarnings("unused")
	private WebBrowser browser;
	private int delay;
	
	public ElementActionByDriver(WebBrowser browser,BrowserElement element,int time) {
		this.browser = browser;
		this.element = element;
		delay = time;
	}
	
	/**
	 * WebElement.clear()
	 * @return {@link BrowserElement}
	 * @throws Exception
	 */
	public BrowserElement clear(){
		element.delay(delay).waitFor().enabled();
		element.getWebElement().clear();
		return element;
	}
	
	/**
	 * WebElement.click()
	 * @return {@link BrowserElement}
	 */
	public BrowserElement click() {
		element.delay(delay).waitFor().enabled();
		element.getWebElement().click();
		return element;
	}
	
	/**
	 * WebElement.sendKeys(text)
	 * @param text The text to send to the WebElement.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement sendKeys(String text){
		element.delay(delay).waitFor().enabled();
		element.getWebElement().sendKeys(text);
		return element;
	}
	
	/**
	 * WebElement.submit()
	 * @return {@link BrowserElement}
	 */
	public BrowserElement submit(){
		element.delay(delay).waitFor().enabled();
		element.getWebElement().submit();
		return element;
	}
	
	/**
	 * Select.selectByVisibleText(text)
	 * @param text The text for the select option(s).
	 * @return {@link BrowserElement}
	 */
	public BrowserElement selectByText(String... text){
		element.delay(delay).waitFor().enabled();
		Select select = new Select(element.getWebElement());
		
		if(select.isMultiple()){
			select.deselectAll();
			for (int i=0; i<text.length;i++){
				select.selectByVisibleText(text[i]);
			}
		}else if(text.length > 1){
			throw new UnsupportedOperationException("Cannot select multiple values");
		}else{
			select.deselectByVisibleText(text[0]);
		}
		return element;
	}
	
	/**
	 * Select.selectByValue(value)
	 * @param value The value for the select option(s).
	 * @return {@link BrowserElement}
	 */
	public BrowserElement selectByValue(String... value){
		element.delay(delay).waitFor().enabled();
		Select select = new Select(element.getWebElement());
		
		if(select.isMultiple()){
			select.deselectAll();
			for (int i=0; i<value.length;i++){
				select.selectByValue(value[i]);
			}
		}else if(value.length > 1){
			throw new UnsupportedOperationException("Cannot select multiple values");
		}else{
			select.selectByValue(value[0]);
		}
		return element;
	}
	
	/**
	 * Select.selectByIndex(index)
	 * @param index The index for the select option(s).
	 * @return {@link BrowserElement}
	 */
	public BrowserElement selectByIndex(int... index){
		element.delay(delay).waitFor().enabled();
		Select select = new Select(element.getWebElement());
		
		if(select.isMultiple()){
			select.deselectAll();
			for (int i=0; i<index.length;i++){
				select.selectByIndex(index[i]);
			}
		}else if(index.length > 1){
			throw new UnsupportedOperationException("Cannot select multiple values");
		}else{
			select.selectByIndex(index[0]);
		}
		return element;
	}
	
	/**
	 * Get the select options and select all by visible text.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement selectAll(){
		element.delay(delay).waitFor().enabled();
		Select select = new Select(element.getWebElement());
		
		if(select.isMultiple()){
			select.deselectAll();
			List<WebElement> options = select.getOptions();
			for (int i=0; i<options.size();i++){
				select.selectByVisibleText(options.get(i).getText());
			}
		}else{
			throw new UnsupportedOperationException("Cannot select multiple values");
		}
		return element;
	}
	
	/**
	 * Browse the file with WebElement.sendKeys(file). The WebElement will be enabled by JavaScript if it's disabled so it can be interact with.
	 * @param file The full path for the file.
	 * @return {@link BrowserElement}
	 */
	public BrowserElement browseFile(String file){
		/**
		if(!element.condition().isDisplayed()){
			//(new WebJavaScript(browser)).visibleWebElement(element);
			(new WebJavaScript(browser)).sendKeys(element, file);
		}else{
			element.getWebElement().sendKeys(file);
		}
		**/
		element.getWebElement().sendKeys(file);
		return element;
	}
	
}
