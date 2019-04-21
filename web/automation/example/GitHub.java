package web.automation.example;

import org.openqa.selenium.Keys;

import web.automation.core.browser.WebBrowser;
import web.automation.core.driver.AutoProfile;
import web.automation.core.locator.BY;

public class GitHub {
	
	private static WebBrowser browser;

	public static void main(String[] args) {
		int i=1;
		String driverPath="C:\\auto";
		AutoProfile profile = new AutoProfile("ENG");
		profile.setDebugLevel(9);
		profile.setDirectory(driverPath,"screen");
		profile.setWait(10,100);
		profile.setDelay(0,100);
		profile.setDriverPath(driverPath+"\\chromedriver.exe");
		
		/*
		 * Declare your own WebDriver instance
		 */
		//System.setProperty("webdriver.chrome.driver",("C:\\auto\\chromedriver.exe"));
		//WebDriver driver = new ChromeDriver();
		//browser=new WebBrowser(driver,profile);

		browser=new WebBrowser("chrome",profile);
		browser.window().maxBound();
		browser.navigate().initURL("https://github.com");
		browser.waitFor().displayed(BY.xpath("//header//a[contains(@href,'github.com')]"));
		browser.screen().advByRobot().saveScreen("test"+i++);
		browser.screen().advByRobot().saveScreen("test"+i++,BY.name("q"));
		browser.screen().advByDriver().saveScreen("test"+i++);
		browser.screen().advByDriver().saveScreen("test"+i++,BY.name("q"));
		browser.window().maximize();
		browser.screen().advByRobot().saveScreen("test"+i++);
		browser.screen().advByRobot().saveScreen("test"+i++,BY.name("q"));
		browser.screen().advByDriver().saveScreen("test"+i++);
		browser.screen().advByDriver().saveScreen("test"+i++,BY.name("q"));
		browser.waitFor().enabled(BY.name("q")).actionsByDriver().sendKeys("cytaylorw").actionsByAction().sendKeys(Keys.ENTER);
		browser.waitFor().enabled(BY.xpath("//nav//a[contains(@href,'Users')]")).actionsByDriver().click();
		browser.waitFor().enabled(BY.addAsDescendant(BY.id("user_search_results"), BY.xpath("/a[contains(@href,'cytaylorw')]"))).actionsByDriver().click();
		browser.waitFor().enabled(BY.xpath("//a[contains(@href,'web-automation')]")).actionsByDriver().click();
		browser.waitFor().displayed(BY.id("readme"));
		browser.screen().advByRobot().saveScrollingScreenByPgDn("test"+i++);
	}
	
	

}
