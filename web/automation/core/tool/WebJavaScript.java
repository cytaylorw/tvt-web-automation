package web.automation.core.tool;

import org.openqa.selenium.Point;

import web.automation.core.browser.WebBrowser;
import web.automation.core.element.BrowserElement;

import org.openqa.selenium.JavascriptExecutor;

public class WebJavaScript {

	private WebBrowser browser;
	
	public WebJavaScript(WebBrowser browser){
		this.browser = browser;
	}
	
	public Object execute(String js){
		return ((JavascriptExecutor)browser.getWebDriver()).executeScript(js);
	}
	
	public Object execute(String js,BrowserElement element){
		return ((JavascriptExecutor)browser.getWebDriver()).executeScript(js,element.getWebElement());
	}
	
	public Point scrolledDocumentOffset(){
		int x = ((Long) execute("return document.documentElement.scrollLeft")).intValue();
		int y = ((Long) execute("return document.documentElement.scrollTop")).intValue();
		return new Point(x,y);
	}
	
	public Point scrolledDocumentBodyOffset(){
		int x = ((Long) execute("return document.body.scrollLeft")).intValue();
		int y = ((Long) execute("return document.body.scrollTop")).intValue();
		return new Point(x,y);
	}
	
	public int windowInnerHeight(){
		return ((Long) execute("return window.innerHeight")).intValue();
	}
	
	public int windowInnerWidth(){
		return ((Long) execute("return window.innerWidth")).intValue();
	}
	
	
	public int windowOuterHeight(){
		return ((Long) execute("return window.outerHeight")).intValue();
	}
	
	public int windowOuterWidth(){
		return ((Long) execute("return window.outerWidth")).intValue();
	}
	
	public int windowLocationX(){
		return ((Long) execute("return window.screenX")).intValue();
	}
	
	public int windowLocationY(){
		return ((Long) execute("return window.screenY")).intValue();
	}
	
	public int elementOffsetTop(BrowserElement element){
		return ((Long) execute("return arguments[0].offsetTop",element)).intValue();
	}
	
	public int elementOffsetLeft(BrowserElement element){
		return ((Long) execute("return arguments[0].offsetLeft",element)).intValue();
	}
	
	// Used in WebBrowserCondition
	public boolean isDocumentVerticalScrollBar (){
		return (boolean)execute("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
	}
	
	// Used in WebBrowserCondition
	public boolean isDocumentHorizontalScrollBar (){
		return (boolean)execute("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
	}
	
	// Used in WebBrowserCondition
	public boolean isDocumentBodyVerticalScrollBar (){
		return (boolean)execute("return document.body.scrollHeight>document.body.clientHeight;");
	}
	
	// Used in WebBrowserCondition
	public boolean isDocumentBodyHorizontalScrollBar (){
		return (boolean)execute("return document.body.scrollWidth>document.body.clientWidth;");
	}
	
	// Used in WebBrowserCondition
	public boolean isVerticalScrollBar (BrowserElement element){
		return (boolean)execute("return arguments[0].scrollHeight>arguments[0].clientHeight;",element);
	}
		
	// Used in WebBrowserCondition
	public boolean isHorizontalScrollBar (BrowserElement element){
		return (boolean)execute("return arguments[0].scrollWidth>arguments[0].clientWidth;",element);
	}
	
	public void openNewPopup(){
		execute("window.open('', '_blank', 'toolbar=0');");
	}
	
	public void scrollIntoView(BrowserElement element, boolean alignToTop){
		execute("arguments[0].scrollIntoView("+alignToTop+")",element);
	}
	
	public void scrollTop(BrowserElement element, int scrollTop){
		execute("arguments[0].scrollTop="+scrollTop,element);
	}
	
	public void scrollTopMax(BrowserElement element){
		int scrollTopMax = ((Long) execute("return arguments[0].scrollTopMax;",element)).intValue();
		execute("arguments[0].scrollTop="+scrollTopMax,element);
	}
	
	public void scrollLeft(BrowserElement element, int scrollLeft){
		execute("arguments[0].scrollLeft="+scrollLeft,element);
	}
	
	public void scrollLeftMax(BrowserElement element){
		int scrollLeftMax = ((Long) execute("return arguments[0].scrollLeftMax;",element)).intValue();
		execute("arguments[0].scrollLeft="+scrollLeftMax,element);
	}
	
	public int offsetTop(BrowserElement element){
		return ((Long) execute("return arguments[0].offsetTop;",element)).intValue();
	}
	
	public int offsetLeft(BrowserElement element){
		return ((Long) execute("return arguments[0].offsetLeft;",element)).intValue();
	}
	
	public int layoutOuterTop(BrowserElement element){
		int margin = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.marginTop;",element));
		int border = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.borderTopWidth;",element));
		int padding = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.paddingTop;",element));
		return margin+border+padding;
	}
	
	public int layoutOuterRight(BrowserElement element){
		int margin = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.marginRight;",element));
		int border = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.borderRightWidth;",element));
		int padding = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.paddingRight;",element));
		return margin+border+padding;
	}
	
	public int layoutOuterBottom(BrowserElement element){
		int margin = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.marginBottom;",element));
		int border = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.borderBottomWidth;",element));
		int padding = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.paddingBottom;",element));
		return margin+border+padding;
	}
	
	public int layoutOuterLeft(BrowserElement element){
		int margin = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.marginLeft;",element));
		int border = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.borderLeftWidth;",element));
		int padding = WebCSS.convertCssSizeToInt((String) execute("return arguments[0].style.paddingLeft;",element));
		return margin+border+padding;
	}
}
