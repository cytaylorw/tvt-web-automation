# Web Automation Framework
This framework was developed for TVT screen capturing while I was working as vendor in IBM Taiwan. I organized all the functions around one object named WebBrowser so I could quickly pick up the work that I done since last TVT automation project. I only upload this project to practice GitHub and have no plan to update this framework anymore. 

## Features
This is the first program that I wrote and used for my work. There might be some bad coding but it did help get my job done quicker than others. 

- Single object to access all the functions.
- A more flexible wait time that can be configured globally, locally and down to each WebElement or Action.
- Window and Frame are handled internally.
- Lots of screen capturing functions.
- Better readibility.
- Easy to use with the ***autocomplete*** feature in Eclipse IDE.

#### Disadvantages
- Can only be executed on local computor because the use of java.awt.Robot.


## Last Working Environment/Dependencies
I did not tested this framework for complete compatibility. The environment that I last used is provided for anyone who will be intrested.

- eclipse-java-2019-03-R-win32-x86_64
- Java 11.0.2
- Selenium server 3.141.59
- Chrome Driver 73.0.3683.68


## Example
An example file: web.automation.example.GitHub

#### Video
A demo video uploaded on [Youtube](https://youtu.be/83J638-JNVI). 

#### Instantiation
This declaration launches WebDriver with built-in settings.

~~~java
AutoProfile profile = new AutoProfile("ENG");
profile.setDebugLevel(9);
profile.setDirectory("C:\\auto","screen");
profile.setWait(10,100);
profile.setDelay(0,100);
profile.setDriverPath("C:\\auto\\chromedriver.exe");
WebBrowser browser=new WebBrowser("chrome",profile);
~~~

External WebDriver instance can be used. This was working for my AVT project.

~~~java
WebBrowser browser = new WebBrowser(webdriver,profile);
~~~


#### Test Case

A sample test case script.

~~~java
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
~~~

#### Next Step
Choice a testing framework (JUnit, TestNG, etc.) to manage test scripts. My workspace for example:

1. Core functions (This framework)
2. Product specific functions
3. General test suite setup 
4. Actual test scripts

## License
To be determined.
