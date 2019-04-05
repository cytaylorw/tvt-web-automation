/**
 * Web buffered image methods based on {@Link WebScreen}
 * @author Taylor Wong
 */
package tvt.selenium.core.screen.image;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tvt.selenium.core.browser.WebBrowser;
import tvt.selenium.core.element.BrowserElement;
import tvt.selenium.core.exception.image.NoImageForModificationException;
import tvt.selenium.core.screen.WebScreen;
import tvt.selenium.core.tool.WebImage;

public class WebBufferedImage {

	protected WebBrowser browser;
	protected BufferedImage currentImage;
	protected boolean locateElement;
	
	//Text size in BufferedImage
	//private final int SCREENTEXTSIZE = 12;
	private final int LINEWIDTH = 2;
	
	public WebBufferedImage(WebBrowser browser){
		this.browser = browser;
		clear();
	}
	
	/**
	 * Add the title attribute as a tooltip image to the bottom of the current BufferedImage. Limitation: no line break and HTML tag conversion.
	 * @param locators The By locators for the WebElement with title attribute.
	 * @return {@link WebBufferedImage}
	 */
	public WebBufferedImage addTitleTooltip (By... locators){
		BrowserElement TVTelement;
		for (int i=0; i<locators.length; i++){
			TVTelement = browser.find().element(locators[i]);
			//currentImage = WebImage.addTitleTooltip2Btm (currentImage,SCREENTEXTSIZE,TVTelement.getWebElement());
			addImage(WebImage.createTitleTooltip(TVTelement.getText()));
		}
		return this;
	}
		
	/**
	 * Add the visible text of the WebElement to the bottom of the current BufferedImage.
	 * @param locators The By locators for the WebElement with visible text.
	 * @return {@link WebBufferedImage}
	 */
	public WebBufferedImage addElementText (By... locators){
		BrowserElement TVTelement;
		for (int i=0; i<locators.length; i++){
			TVTelement = browser.find().element(locators[i]);
			addImage(WebImage.createElementText(TVTelement.getWebElement()));
			//currentImage = WebImage.addElementText2Btm (currentImage,TVTelement.getWebElement());
		}
		return this;
	}
	
	/**
	 * Add the visible text of the list of WebElement to the bottom of the current BufferedImage with no line break. WebElement without text or disabled will be ignored.
	 * @param elements The list of {@link BrowserElement}.
	 * @return {@link WebBufferedImage}
	 */
	public WebBufferedImage addElementsText (List<BrowserElement> elements){
		BrowserElement current;
		
		for (int i=0; i<elements.size(); i++){
			current = elements.get(i);
			if(!current.getText().isEmpty() && current.condition().isEnabled()){
				addElementText(elements.get(i));
			}
		}
		return this;
	}
	
	/**
	 * Add the option text of the select WebElement to the bottom of the current BufferedImage.
	 * @param select The By locators for the select WebElement.
	 * @return {@link WebBufferedImage}
	 */
	public WebBufferedImage addSelectOptions (By select){
		List<WebElement> options = new Select(browser.getWebDriver().findElement(select)).getOptions();
		List<BrowserElement> TVToptions = new ArrayList<BrowserElement>();;
		for(int i=0;i<options.size(); i++){
			TVToptions.add(new BrowserElement(browser,options.get(i)));
		}
		addElementsText(TVToptions);
		WebImage.drawBorder(currentImage);
		return this;
	}
	
	public WebBufferedImage createHeaderTitle (){
		currentImage = WebImage.createTitleTooltip(browser.getWebDriver().getTitle());
		return this;
	}
	
	public WebBufferedImage addHeaderTitle (){
		currentImage = WebImage.addImg2Btm(WebImage.createTitleTooltip(browser.getWebDriver().getTitle()), currentImage);
		return this;
	}
	
	
	/**
	 * Add the BufferedImage to the bottom of the current BufferedImage.
	 * @param image The BufferedImage to be added.
	 * @return {@link WebBufferedImage}
	 */
	public WebBufferedImage addImage(BufferedImage image){
		currentImage = WebImage.addImg2Btm(currentImage, image);
		return this;
	}
	
	public WebBufferedImage addImageAtTop(BufferedImage image){
		currentImage = WebImage.addImg2Btm(image, currentImage);
		return this;
	}
	
	/**
	 * Set the BufferedImage in {@link WebBufferedImage} to null.
	 */
	public void clear(){
		currentImage = null;
	}
	
	/**
	 * Crop the the BufferedImage in {@link WebBufferedImage}.
	 * @param offsetX The X coordinate of the upper-left corner of the specified rectangular region.
	 * @param offsetY The Y coordinate of the upper-left corner of the specified rectangular region.
	 * @param width The width of the specified rectangular region.
	 * @param height The height of the specified rectangular region.
	 */
	public void subImage(int offsetX,int offsetY,int width,int height){
		int finalWidth;
		int finalHeight;
		//calculate final width
		int imgWidth = currentImage.getWidth();
		if((offsetX+width) > imgWidth){
			finalWidth = imgWidth-offsetX;
		}else{
			finalWidth=width;
		}
		//calculate final height
		int imgHeight = currentImage.getHeight();
		if((offsetY+height) > imgHeight){
			finalHeight = imgHeight-offsetY;
		}else{
			finalHeight=height;
		}
		try{
			currentImage = currentImage.getSubimage(offsetX, offsetY,finalWidth, finalHeight);
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first.");
			
		}catch (java.awt.image.RasterFormatException e){
			throw new java.awt.image.RasterFormatException(e.getMessage()+"\nImage(w,h): "+currentImage.getWidth()+","+currentImage.getHeight()+" New Area(x,y,w,h): "+offsetX+","+offsetY+","+finalWidth+","+finalHeight);
		}
	}
	
	/**
	 * Crop the the BufferedImage in {@link WebBufferedImage}.
	 * @param area The rectangular region.
	 */
	public WebBufferedImage subImage(Rectangle area){
		subImage((int) area.getX(), (int) area.getY(), (int) area.getWidth(), (int) area.getHeight());
		return this;
	}
	
	/**
	 * Crop the the BufferedImage in {@link WebBufferedImage} with the same width.
	 * @param offsetY The Y coordinate of the upper-left corner of the specified rectangular region.
	 * @param height The height of the specified rectangular region.
	 */
	public void subImageKeepWidth(int offsetY,int height){
		int offsetX = currentImage.getMinX();
		int width = currentImage.getWidth();
		try{
			currentImage = currentImage.getSubimage(offsetX, offsetY, width, height);
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first.");
			
		}catch (java.awt.image.RasterFormatException e){
			throw new java.awt.image.RasterFormatException(e.getMessage()+"\nImage(w,h): "+currentImage.getWidth()+","+currentImage.getHeight()+" New Area(x,y,w,h): "+offsetX+","+offsetY+","+width+","+height);
		}
	}
	
	/**
	 * Crop the the BufferedImage in {@link WebBufferedImage} with the same height.
	 * @param offsetX The X coordinate of the upper-left corner of the specified rectangular region.
	 * @param width The width of the specified rectangular region.
	 */
	public void subImageKeepHeight(int offsetX,int width){
		int offsetY = currentImage.getMinY();
		int height = currentImage.getHeight();
		try{
			currentImage = currentImage.getSubimage(offsetX, offsetY, width, height);
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first.");
			
		}catch (java.awt.image.RasterFormatException e){
			throw new java.awt.image.RasterFormatException(e.getMessage()+"\nImage(w,h): "+currentImage.getWidth()+","+currentImage.getHeight()+" New Area(x,y,w,h): "+offsetX+","+offsetY+","+width+","+height);
		}
	}
	
	protected void drawRedRectangle(int x,int y,int width,int height){
		currentImage = WebImage.drawRedRectangle(currentImage, LINEWIDTH, x, y, width, height);
	}
	
	protected void drawRedRectangle(Rectangle area){
		currentImage = WebImage.drawRedRectangle(currentImage, LINEWIDTH, (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight());
	}
	
	protected void drawBlueCrossOut(int x,int y,int width,int height){
		currentImage = WebImage.drawBlueCrossOut(currentImage, LINEWIDTH, x, y, width, height);
	}
	
	protected void drawBlueCrossOut(Rectangle area){
		currentImage = WebImage.drawBlueCrossOut(currentImage, LINEWIDTH, (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight());
	}
	
	protected void drawBlueStrikethrough(int x,int y,int width,int height){
		currentImage = WebImage.drawBlueStrikethrough(currentImage, LINEWIDTH, x, y, width, height);
	}
	
	protected void drawBlueStrikethrough(Rectangle area){
		currentImage = WebImage.drawBlueStrikethrough(currentImage, LINEWIDTH, (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight());
	}
	
	protected void drawRedRectangleInside(int x,int y,int width,int height){
		currentImage = WebImage.drawRedRectangleInside(currentImage, LINEWIDTH, x, y, width, height);
	}
	
	protected void drawRedRectangleInside(Rectangle area){
		currentImage = WebImage.drawRedRectangleInside(currentImage, LINEWIDTH, (int)area.getX(), (int)area.getY(), (int)area.getWidth(), (int)area.getHeight());
	}
	
	/**
	 * Get the BufferedImage in {@link WebBufferedImage}.
	 * @return BufferedImage
	 */
	public BufferedImage getImage(){
		return currentImage;
	}
	
	/**
	 * Save the BufferedImage in {@link WebBufferedImage}. Please also see {@link WebScreen#saveImage(BufferedImage, String)}.
	 * @param fileName The file name for the image.
	 */
	public void saveImage (String fileName){
		browser.screen().saveImage(currentImage,fileName);
	}
	
	public void saveImage (String fileName,float quality){
		browser.screen().saveImage(currentImage,fileName,quality);
	}
	
	public void saveImageDirect (String fileName){
		browser.screen().saveImageDirect(currentImage,fileName);
	}
	
	/**
	protected Rectangle areaWithLineInside(Rectangle area){
		int x =  (int) (area.getX()+LINEWIDTH);
		int y =  (int) (area.getY()+LINEWIDTH);
		int width = (int) (area.getWidth()-(LINEWIDTH*2));
		int height = (int) (area.getHeight()-(LINEWIDTH*2));
		return new Rectangle(x,y,width,height);
	}
	**/
	/*
	 * Private methods
	 */
	private void addTitleTooltip (BrowserElement... elements){
		
		for (int i=0; i<elements.length; i++){
			//currentImage = WebImage.addTitleTooltip2Btm (currentImage,SCREENTEXTSIZE,elements[i].getWebElement());
			addImage(WebImage.createTitleTooltip(elements[i].getText()));
		}
		
	}
	
	/**
	 * Add the title attribute from a list of {@link BrowserElement} as a tooltip image to the bottom of the current BufferedImage with no line break in each title.
	 * @param elements
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void addTitleTooltips (List<BrowserElement> elements){
		String current;
		
		for (int i=0; i<elements.size(); i++){
			current = elements.get(i).getWebElement().getAttribute("title");
			if(current.isEmpty() != true){
				if (elements.get(i).getWebElement().getCssValue("display") != "none" && 
						elements.get(i).getWebElement().getCssValue("visibility") != "hidden" &&
						elements.get(i).getWebElement().isDisplayed()){
					addTitleTooltip (elements.get(i));
				}
			}
		}
		
	}
	
	/**
	 * Add WebElement text to the bottom of the current BufferedImage with no line break.
	 * @param elements
	 * @throws Exception
	 */
	private void addElementText (BrowserElement... elements){
		
		for (int i=0; i<elements.length; i++){
			addImage(WebImage.createElementText(elements[i].getWebElement()));
			//currentImage = WebImage.addElementText2Btm (currentImage,SCREENTEXTSIZE,elements[i].getWebElement());
			//currentImage = WebImage.addElementText2Btm (currentImage,elements[i].getWebElement());
		}

	}
	
}
