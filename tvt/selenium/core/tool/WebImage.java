package tvt.selenium.core.tool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

import org.openqa.selenium.WebElement;

import tvt.selenium.core.exception.image.NoImageForModificationException;
import tvt.selenium.core.exception.timeout.element.EmptyTextException;
import tvt.selenium.core.exception.timeout.element.NoPartialTextException;

public class WebImage {

	public static boolean compareImage(BufferedImage biA,BufferedImage biB) {        
	    try {
	        // take buffer data from btm image files //
	        DataBuffer dbA = biA.getData().getDataBuffer();
	        int sizeA = dbA.getSize();                      
	        DataBuffer dbB = biB.getData().getDataBuffer();
	        int sizeB = dbB.getSize();
	        // compare data-buffer objects //
	        if(sizeA == sizeB) {
	            for(int i=0; i<sizeA; i++) { 
	                if(dbA.getElem(i) != dbB.getElem(i)) {
	                    return false;
	                }
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    } 
	    catch (Exception e) { 
	        System.out.println("Failed to compare image files ...");
	        return  false;
	    }
	}
	
	public static BufferedImage addImg2Btm (BufferedImage img,BufferedImage img2){	
		BufferedImage buffImg;
		
		if (img != null){
			Graphics2D graphic;
			int img2_w = img2.getWidth();
			int img2_h = img2.getHeight();
			
			// Create the enlarge image to add the 2nd image
			int img_w = img.getWidth();
			int img_h = img.getHeight();
			
			if (img_w >= img2_w){
				buffImg = new BufferedImage(img_w, img_h+img2_h+2, BufferedImage.TYPE_INT_ARGB);
			}else{
				buffImg = new BufferedImage(img2_w+4, img_h+img2_h+2, BufferedImage.TYPE_INT_ARGB);
			}
			graphic = buffImg.createGraphics();
			graphic.drawImage(img, 0, 0, null);
			graphic.drawImage(img2, 3, img_h+1, null);
			graphic.dispose();
		}else{
			buffImg = img2;
			/*
			buffImg = new BufferedImage(img2_w+3, img2_h+2, BufferedImage.TYPE_INT_ARGB);
			graphic = buffImg.createGraphics();
			graphic.drawImage(img2, 3, 1, null);
			*/
		}
		//graphic.dispose();
		return buffImg;
	}
	/**
	public static BufferedImage createTitleTooltip (int size,WebElement element){
		
		String text = element.getAttribute("title");
		String text_font = element.getCssValue("font-family");
		int tooltip_h = size+7;
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D tooltip = img.createGraphics();
		tooltip.setFont(new Font(text_font, Font.TRUETYPE_FONT, size));
		int tooltip_w = tooltip.getFontMetrics().stringWidth(text)+7;
		img = new BufferedImage(tooltip_w, tooltip_h, BufferedImage.TYPE_INT_ARGB);
		tooltip = img.createGraphics();
		tooltip.setFont(new Font(text_font, Font.TRUETYPE_FONT, size));
		tooltip.setPaint(Color.decode("#F5FCDE"));
		tooltip.fillRect(0, 0, tooltip_w, tooltip_h);
		tooltip.setPaint(Color.black);
		tooltip.draw3DRect(0, 0, tooltip_w-1, tooltip_h-1, true);
		tooltip.drawString(text,3,tooltip_h-5);
		tooltip.dispose();
		
		return img;
		
	}
	
	public static BufferedImage createTitleTooltip (WebElement element){
		return createTitleTooltip(WebCSS.convertCssSizeToInt(element.getCssValue("font-size")),element);
		
	}
	**/
	/**
	public static BufferedImage createHeaderTitleTooltip (int size,WebDriver driver){
		return createTooltip(driver.getTitle());
		/**
		String text = driver.getTitle();
		String text_font = driver.findElement(BY.xpath("/html")).getCssValue("font-family");
		int tooltip_h = size+7;
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D tooltip = img.createGraphics();
		tooltip.setFont((Font) Toolkit.getDefaultToolkit().getDesktopProperty("win.tooltip.font"));
		tooltip.setFont(new Font(text_font, Font.TRUETYPE_FONT, size));
		int tooltip_w = tooltip.getFontMetrics().stringWidth(text)+7;
		img = new BufferedImage(tooltip_w, tooltip_h, BufferedImage.TYPE_INT_ARGB);
		tooltip = img.createGraphics();
		tooltip.setFont((Font) Toolkit.getDefaultToolkit().getDesktopProperty("win.tooltip.font"));
		//tooltip.setFont(new Font(text_font, Font.TRUETYPE_FONT, size));
		System.out.println(((Color)Toolkit.getDefaultToolkit().getDesktopProperty("win.tooltip.backgroundColor")).toString());
		tooltip.setPaint((Color)Toolkit.getDefaultToolkit().getDesktopProperty("win.tooltip.backgroundColor"));
		//tooltip.setPaint(Color.decode("#F5FCDE"));
		tooltip.fillRect(0, 0, tooltip_w, tooltip_h);
		tooltip.setPaint(Color.black);
		tooltip.draw3DRect(0, 0, tooltip_w-1, tooltip_h-1, true);
		tooltip.drawString(text,3,tooltip_h-5);
		tooltip.dispose();
		
		return img;
		
	}
	**/
	public static BufferedImage createTitleTooltip(String text){
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Font text_font = (Font) tk.getDesktopProperty("win.tooltip.font");
		int tooltip_h = text_font.getSize()+7;
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D tooltip = img.createGraphics();
		tooltip.setFont(text_font);
		int tooltip_w = tooltip.getFontMetrics().stringWidth(text)+7;
		img = new BufferedImage(tooltip_w, tooltip_h, BufferedImage.TYPE_INT_ARGB);
		tooltip = img.createGraphics();
		tooltip.setFont(text_font);
		tooltip.setPaint((Color)tk.getDesktopProperty("win.tooltip.backgroundColor"));
		tooltip.fillRect(0, 0, tooltip_w, tooltip_h);
		tooltip.setPaint((Color)tk.getDesktopProperty("win.tooltip.textColor"));
		tooltip.draw3DRect(0, 0, tooltip_w-1, tooltip_h-1, true);
		tooltip.drawString(text,3,tooltip_h-5);
		tooltip.dispose();
		
		return img;
	}
	
	/**
	public static BufferedImage addTitleTooltip2Btm (BufferedImage img,int size,WebElement element){
		return addImg2Btm(img,createTitleTooltip(size,element));
	}
	
	public static BufferedImage addTitleTooltip2Btm (BufferedImage img,WebElement element){
		return addImg2Btm(img,createTitleTooltip(element));
	}
	**/
	
	public static BufferedImage createElementText (WebElement element){
		
		String text = element.getText();
		if (text.isEmpty()== true) throw new EmptyTextException("Text value is empty.");
		int size = WebCSS.convertCssSizeToInt(element.getCssValue("font-size"));
		String text_font = element.getCssValue("font-family");
		
		int text_h = size+7;
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D textImg = img.createGraphics();
		textImg.setFont(new Font(text_font, Font.PLAIN,size));
		int text_w = textImg.getFontMetrics().stringWidth(text)+7;
		img = new BufferedImage(text_w, text_h, BufferedImage.TYPE_INT_ARGB);
		textImg = img.createGraphics();
		textImg.setFont(new Font(text_font, Font.PLAIN, size));
		textImg.setPaint(Color.white);
		textImg.fillRect(0, 0, text_w, text_h);
		textImg.setPaint(Color.black);
		textImg.drawString(text,3,text_h-5);
		textImg.dispose();
		
		return img;
		
	}
	
	public static BufferedImage drawBorder (BufferedImage img){
		
		Graphics2D g2d = img.createGraphics();
		g2d.setPaint(Color.black);
		g2d.draw3DRect(0, 0, img.getWidth()-1, img.getHeight()-1, true);
		g2d.dispose();
		return img;
	}
	
	/**
	public static BufferedImage createElementText (WebElement element){
		return createElementText (WebCSS.convertCssSizeToInt(element.getCssValue("font-size")),element);
	}
	
	public static BufferedImage addElementText2Btm (BufferedImage img,int size,WebElement element){
		return addImg2Btm(img,createElementText(size,element));
	}
	
	public static BufferedImage addElementText2Btm (BufferedImage img,WebElement element){
		return addImg2Btm(img,createElementText(element));
	}
	**/
	public static Rectangle expandRectangle(Rectangle area1,Rectangle area2){
		int x1 = (int) area1.getX();
		int y1 = (int) area1.getY();
		int x2 = (int) (x1+area1.getWidth());
		int y2 = (int) (y1+area1.getHeight());
		int x3 = (int) area2.getX();
		int y3 = (int) area2.getY();
		int x4 = (int) (x3+area2.getWidth());
		int y4 = (int) (y3+area2.getHeight());
		if(x3 < x1) x1=x3;
		if(y3 < y1) y1=y3;
		if(x4 > x2) x2=x4;
		if(y4 > y2) y2=y4;
		int width = x2-x1;
		int height = y2-y1;
		return new Rectangle(x1,y1,width, height);
	}
	
	public static Rectangle adjustRectangle(Rectangle area1,int adjust){
		int x1 = (int) area1.getX()-adjust;
		int y1 = (int) area1.getY()-adjust;
		int x2 = (int) (x1+area1.getWidth())+(adjust*2);
		int y2 = (int) (y1+area1.getHeight())+(adjust*2);
		int width = x2-x1;
		int height = y2-y1;
		return new Rectangle(x1,y1,width, height);
	}
	
	public static BufferedImage drawRedRectangle(BufferedImage img,int lineW,int x,int y,int width,int height){
		Graphics2D g2d;
		try{
			g2d = img.createGraphics();
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first before drawing rectangle.");
		}
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(lineW));
		int adjust = (lineW+2)/2;
		g2d.drawRect(x-adjust, y-adjust, width+(adjust*2), height+(adjust*2));
		g2d.dispose();
		return img;
	}
	
	public static BufferedImage drawBlueCrossOut(BufferedImage img,int lineW,int x,int y,int width,int height){
		Graphics2D g2d;
		try{
			g2d = img.createGraphics();
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first before drawing rectangle.");
		}
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(lineW));
		int adjust = lineW/2;
		x=x+adjust;
		y=y+adjust;
		width=width-(adjust*2);
		height=height-(adjust*2);
		g2d.drawLine(x,y, x+width, y+height);
		g2d.drawLine(x,y+height, x+width,y);
		g2d.drawRect(x, y, width, height);
		g2d.dispose();
		return img;
	}
	
	public static BufferedImage drawBlueStrikethrough(BufferedImage img,int lineW,int x,int y,int width,int height){
		Graphics2D g2d;
		try{
			g2d = img.createGraphics();
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first before drawing rectangle.");
		}
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(lineW));
		g2d.drawLine(x,y+(height/2), x+width, y+(height/2));
		g2d.dispose();
		return img;
	}
	
	public static BufferedImage drawRedRectangleInside(BufferedImage img,int lineW,int x,int y,int width,int height){
		Graphics2D g2d;
		try{
			g2d = img.createGraphics();
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first before drawing rectangle.");
		}
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(lineW));
		int adjust = lineW/2;
		g2d.drawRect(x+adjust, y+adjust, width-(adjust*2), height-(adjust*2));
		g2d.dispose();
		return img;
	}
	
	public static BufferedImage strikeOutPartialText(BufferedImage img,int lineW,WebElement element,String partialText){
		Graphics2D g2d;
		try{
			g2d = img.createGraphics();
		}catch (NullPointerException e){
			throw new NoImageForModificationException("Please take a screen capture first before drawing line.");
		}
		String text = element.getText();
		if(text.isEmpty()){
			throw new EmptyTextException("Text is empty in the WebElement.");
		}else if (!text.contains(partialText)){
			throw new NoPartialTextException("Text is empty in the WebElement.");
		}
		//calculate line length
		String text_font = element.getCssValue("font-family");
		String value = element.getCssValue("font-size");
		g2d.setFont(new Font(text_font, Font.PLAIN, WebCSS.convertCssSizeToInt(value)));
		int lineLength = g2d.getFontMetrics().stringWidth(partialText);
		//calculate line offset
		int lineX = element.getLocation().getX();
		int lineY = element.getLocation().getY();
		if (!(value=element.getCssValue("margin-top")).isEmpty()){
			lineX = lineX+WebCSS.convertCssSizeToInt(value);
		}
		if (!(value=element.getCssValue("border-top")).isEmpty()){
			lineX = lineX+WebCSS.convertCssSizeToInt(value);
		}
		if (!(value=element.getCssValue("padding-top")).isEmpty()){
			lineX = lineX+WebCSS.convertCssSizeToInt(value);
		}
		if (!(value=element.getCssValue("margin-left")).isEmpty()){
			lineY = lineY+WebCSS.convertCssSizeToInt(value);
		}
		if (!(value=element.getCssValue("border-left")).isEmpty()){
			lineY = lineY+WebCSS.convertCssSizeToInt(value);
		}
		if (!(value=element.getCssValue("padding-left")).isEmpty()){
			lineY = lineY+WebCSS.convertCssSizeToInt(value);
		}
		lineY = lineY+(g2d.getFontMetrics().getHeight()/2);
		int partialTextIndex = text.indexOf(partialText);
		int preLength;
		if(partialTextIndex > 0){
			preLength = g2d.getFontMetrics().stringWidth(text.substring(0,partialTextIndex));
		}else{
			preLength = 0;
		}
		
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(lineW));
		g2d.drawLine(lineX+preLength, lineX+preLength+lineLength, lineY, lineY);
		g2d.dispose();
		return img;
	}
	
}
