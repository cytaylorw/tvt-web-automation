package tvt.selenium.core.element;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.tool.WebJavaScript;

public class BrowserElementCondition {

	private WebBrowser browser;
	private BrowserElement element;
	
	public BrowserElementCondition(WebBrowser browser, BrowserElement element) {
		this.browser = browser;
		this.element = element;
	}
	
	/**
	 * Checking if the current {@link BrowserElement} is displayed.
	 * @return The status on whether the current {@link BrowserElement} is displayed.
	 */
	public boolean isDisplayed(){
		try {
			return element.getWebElement().isDisplayed();
	    } catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the current {@link BrowserElement} is enabled.
	 * @return The status on whether the current {@link BrowserElement} is enabled.
	 */
	public boolean isEnabled(){
		try {
			return element.getWebElement().isEnabled();
	    } catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the current {@link BrowserElement} is selected.
	 * @return The status on whether the current {@link BrowserElement} is selected.
	 */
	public boolean isSelected(){
		try {
	    	return element.getWebElement().isSelected();
	    }  catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the current {@link BrowserElement} can be found.
	 * @return The status on whether the current {@link BrowserElement} can be found.
	 */
	public boolean isFound() {
	    try {
	    	element.getTagName();
	    	return true;
	    }  catch (org.openqa.selenium.StaleElementReferenceException e){
	    	return false;
	    }
	}
	
	/**
	 * Checking if the current {@link BrowserElement} value attribute(input value) is empty.
	 * @return The status on whether the current {@link BrowserElement} value attribute is empty.
	 */
	public boolean isEmptyValueAttribute(){
		return element.getAttribute("value").isEmpty();
	}
	
	/**
	 * Checking if the current {@link BrowserElement} text is empty.
	 * @return The status on whether the current {@link BrowserElement} text is empty.
	 */
	public boolean isEmptyText(){
		try {
			return element.getText().isEmpty();
	    }  catch (NullPointerException e){
	    	return true;
	    }
	}
	
	/**
	 * Checking if the current {@link BrowserElement} text is equal to the text parameter.
	 * @param text The text parameter.
	 * @return The status on whether the current {@link BrowserElement} text is equal to the text parameter.
	 */
	public boolean isEqualText(String text){
		try {
			return element.getText().equals(text);
		} catch (NullPointerException e){
			return false;
		}
	}
	
	/**
	 * Checking if the current {@link BrowserElement} contains the attribute. If a Boolean attribute is set to false, this method will also return false.
	 * @param attribute The attribute name.
	 * @return The status on whether the current {@link BrowserElement} contains the attribute.
	 */
	public boolean isSetAttribute(String attribute){
		try {
			if(element.getAttribute(attribute) != null){
				return true;
			}else{
				return false;
			}	
		} catch (NullPointerException e){
			return false;
		}
	}
	
	/**
	 * Checking if the current {@link BrowserElement} has the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return The status on whether the current {@link BrowserElement} has the attribute equals to the value.
	 */
	public boolean isEqualAttributeValue(String attribute, String value){
		try {
			if(element.getAttribute(attribute).equals(value)){
				return true;
			}else{
				return false;
			}	
		} catch (NullPointerException e){
			return false;
		}
	}
	
	/**
	 * Checking if the current {@link BrowserElement} to have the attribute equals to the value.
	 * @param attribute The attribute name.
	 * @param value The attribute value.
	 * @return The status on whether the current {@link BrowserElement} has the attribute equals to the value.
	 */
	public boolean isContainedAttributeValue(String attribute, String value){
		try {
			if(element.getAttribute(attribute).contains(value)){
				return true;
			}else{
				return false;
			}	
		} catch (NullPointerException e){
			return false;
		}
	}
	
	public boolean isVerticalScrollBar(){
		return new WebJavaScript(browser).isVerticalScrollBar(element);
	}
	
	public boolean isHorizontalScrollBar(){
		return new WebJavaScript(browser).isHorizontalScrollBar(element);
	}
}
