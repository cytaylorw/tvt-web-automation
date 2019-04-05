package tvt.selenium.core.locator;

import org.openqa.selenium.By;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.exception.timeout.NotFoundException;

public class XPathLocator {

	WebBrowser browser;
	
	public XPathLocator(WebBrowser browser){
		this.browser = browser;
	}
	
	public By childHasDescendant(By parent, By descendant){
		int i=1;
		By child= BY.addAsChild(parent, BY.xpath("/*["+i+"]"));
		while(browser.condition().isFound(child)){
			if(browser.condition().isFound(BY.addAsDescendant(child,descendant))){
				return child;
			}
			i++;
			child=BY.addAsChild(parent, BY.xpath("/*["+i+"]"));
		}
		throw new NotFoundException(browser,"Not Found: "+BY.addAsDescendant(parent,descendant).toString());
		
	}
}
