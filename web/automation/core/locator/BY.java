package web.automation.core.locator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

public abstract class BY extends org.openqa.selenium.By{
	
	public static By text(String text){
		return By.xpath("//*[text()='"+text+"']");
	}
	
	public static By partialText(String text){
		return By.xpath("//*[contains(text(),'"+text+"')]");
	}
	
	public static By attributeValue(String attirbute,String value){
		return By.xpath("//*[@"+attirbute+"='"+value+"']");
	}
	
	public static By partialAttributeValue(String attirbute,String value){
		return By.xpath("//*[contains(@"+attirbute+",'"+value+"')]");
	}
	
	public static By addAsChild(By by1,By by2){
		return By.xpath(convertToXpathAsDescendant(by1)+convertToXpathAsChild(by2));
	}
	
	public static By addAsDescendant(By by1,By by2){
		return By.xpath(convertToXpathAsDescendant(by1)
				+convertToXpathAsDescendant(by2));
	}
	
	public static By addIndex(By element,int index){
		return By.xpath(convertToXpathAsDescendant(element)+"["+index+"]");
	}
	
	public static By getChild(By parent,int number){
		return addAsChild(parent,By.xpath("/*["+number+"]"));
	}
	
	public static By addXPathExpression(By by,String expression){
		return By.xpath(convertToXpathThenAddExpression(by,expression));
	}
	
	private static String convertToXpathAsDescendant (By by){
		String test = by.toString();
		String value;
		if(test.startsWith("By.id:")){
			value = test.substring(7);
			return "//*[@id='"+value+"']";
		}else if(test.startsWith("By.name:")){
			value = test.substring(9);
			return "//*[@name='"+value+"']";
		}else if(test.startsWith("By.xpath:")){
			value = test.substring(10);
			if (value.startsWith("//")){
				return value;
			}else if(value.startsWith("/")){
				return "/"+value;
			}else {
				throw new IllegalArgumentException(value+" does not start with '/'");
			}
		}else if(test.startsWith("By.tagName:")){
			value = test.substring(12);
			return "//"+value;
		}else if(test.startsWith("By.linkText:")){
			value = test.substring(13);
			return "//a[text()='"+value+"']";
		}else if(test.startsWith("By.partialLinkText:")){
			value = test.substring(20);
			return "//a[contains(text(),'"+value+"')]";
		}else if(test.startsWith("By.className:")){
			value = test.substring(14);
			return "//*[contains(concat(' ', normalize-space(@class), ' '), ' "+value+" ')]";
		}else if(test.startsWith("By.cssSelector:")){
			throw new UnsupportedOperationException("cssSelector is not supported.");
		}else{
			throw new UnsupportedOperationException(test+" is unknown for a By class.");
		}
	}
	
	private static String convertToXpathAsChild (By by){
		String test = by.toString();
		String value;
		if(test.startsWith("By.id:")){
			value = test.substring(7);
			return "/*[@id='"+value+"']";
		}else if(test.startsWith("By.name:")){
			value = test.substring(9);
			return "/*[@name='"+value+"']";
		}else if(test.startsWith("By.xpath:")){
			value = test.substring(10);
			if (value.startsWith("//")){
				return value.substring(1);
			}else if(value.startsWith("/")){
				return value;
			}else {
				throw new IllegalArgumentException(value+" does not start with '/'");
			}
		}else if(test.startsWith("By.tagName:")){
			value = test.substring(12);
			return "/"+value;
		}else if(test.startsWith("By.linkText:")){
			value = test.substring(13);
			return "/a[text()='"+value+"']";
		}else if(test.startsWith("By.partialLinkText:")){
			value = test.substring(20);
			return "/a[contains(text(),'"+value+"')]";
		}else if(test.startsWith("By.className:")){
			value = test.substring(14);
			return "/*[contains(concat(' ', normalize-space(@class), ' '), ' "+value+" ')]";
		}else if(test.startsWith("By.cssSelector:")){
			throw new UnsupportedOperationException("cssSelector is not supported.");
		}else{
			throw new UnsupportedOperationException(test+" is unknown for a By class.");
		}
	}
	
	private static String convertToXpathThenAddExpression (By by, String expression){
		String test = by.toString();
		String value;
		String byXpath;
		if(test.startsWith("By.id:")){
			value = test.substring(7);
			byXpath = "//*[@id='"+value+"']";
		}else if(test.startsWith("By.name:")){
			value = test.substring(9);
			byXpath = "//*[@name='"+value+"']";
		}else if(test.startsWith("By.xpath:")){
			value = test.substring(10);
			if (value.startsWith("//")){
				byXpath = value;
			}else if(value.startsWith("/")){
				byXpath = "/"+value;
			}else {
				throw new IllegalArgumentException(value+" does not start with '/'");
			}
		}else if(test.startsWith("By.tagName:")){
			value = test.substring(12);
			byXpath = "//"+value;
		}else if(test.startsWith("By.linkText:")){
			value = test.substring(13);
			byXpath = "//a[text()='"+value+"']";
		}else if(test.startsWith("By.partialLinkText:")){
			value = test.substring(20);
			byXpath = "//a[contains(text(),'"+value+"')]";
		}else if(test.startsWith("By.className:")){
			value = test.substring(14);
			byXpath = "//*[contains(concat(' ', normalize-space(@class), ' '), ' "+value+" ')]";
		}else if(test.startsWith("By.cssSelector:")){
			throw new UnsupportedOperationException("cssSelector is not supported.");
		}else{
			throw new UnsupportedOperationException(test+" is unknown for a By class.");
		}
		if(expression.startsWith(" ")){
			return byXpath.substring(0,byXpath.length()-1)+expression+"]";
		}else{
			return byXpath.substring(0,byXpath.length()-1)+" "+expression+"]";
		}
	}
	
	@SuppressWarnings("unused")
	private static String convertToXpathAsChild_regex(By by){
		Pattern p = Pattern.compile("By.([\\S]*):\\s([[[\\S]*]\\s]*)");
		Matcher m = p.matcher(by.toString());
		switch(m.group(1)){
		case "id": return "/*[@"+m.group(1)+"='"+m.group(2)+"']";
		case "name": return "/*[@"+m.group(1)+"='"+m.group(2)+"']";
		case "xpath": 
			if (m.group(2).startsWith("//")){
				return m.group(2).substring(1);
			}else{
				return m.group(2);
			}
		case "tagName": return "/"+m.group(2);
		case "linkText": return "/a[text()='"+m.group(2)+"']";
		case "partialLinkText": return "/a[contains(text(),'"+m.group(2)+"')]";
		case "className": return "/*[contains(@class,'"+m.group(2)+"')]";
		case "cssSelector": throw new UnsupportedOperationException(m.group(1)+" is not supported.");
		default:
			throw new UnsupportedOperationException(m.group(1)+" is unknown for a By class.");
		}
	}
	
	@SuppressWarnings("unused")
	private static String convertToXpathAsDescendant_regex(By by){
		String test = by.toString();
		Pattern p = Pattern.compile("By\\.(\\S*):\\s([\\S*\\s*]*)\\s*");
		try{
		Matcher m = p.matcher(test);
		switch(m.group(1)){
		case "id": return "//*[@"+m.group(1)+"='"+m.group(2)+"']";
		case "name": return "//*[@"+m.group(1)+"='"+m.group(2)+"']";
		case "xpath": 
			if (m.group(2).startsWith("//")){
				return m.group(2);
			}else{
				return "/"+m.group(2);
			}
		case "tagName": return "//"+m.group(2);
		case "linkText": return "//a[text()='"+m.group(2)+"']";
		case "partialLinkText": return "//a[contains(text(),'"+m.group(2)+"')]";
		case "className": return "//*[contains(@class,'"+m.group(2)+"')]";
		case "cssSelector": throw new UnsupportedOperationException(m.group(1)+" is not supported.");
		default:
			throw new UnsupportedOperationException(m.group(1)+" is unknown for a By class.");
		}
		}catch (IllegalStateException e){
			throw new IllegalStateException(e.getMessage()+": "+ test);
		}
	}
	
	/**
	private static By findChildHasDescendant(WebBrowser browser,By parent,By descendant){
		int i=1;
		By child= BY.addAsChild(parent, BY.xpath("/*["+i+"]"));
		while(browser.condition().isFound(child)){
			if(browser.condition().isFound(addAsDescendant(child,descendant))){
				return child;
			}
			i++;
			child=BY.addAsChild(parent, BY.xpath("/*["+i+"]"));
		}
		throw new NotFoundException(browser,"Not Found: "+addAsDescendant(parent,descendant).toString());
		
	}
	**/
}
