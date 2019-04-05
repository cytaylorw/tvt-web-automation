# TVT Web Automation Framework
This framework was developed for TVT screen capturing while I was working as vendor in IBM Taiwan. I organized all the functions around one object named WebBrowser so I could quickly pick up the work that I done since last TVT automation project. The last project would usually be from 3 monthes to 1 year ago. I only upload this project to practice GitHub and have no plan to update this framework anymore. 

## Features
This is the first program that I wrote and used for my work. I did not handle some problems well in the detail of the code but it did help to get my job done quicker than others. I could implement over 120 TVT test cases per day for an automation ready product with proper locator. The screen captures were generating stably at one image every 2 to 5 seconds.

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

- Eclipse version: eclipse-java-mars-1-win32-x86_64
- Eclipse plug-in: TestNG 6.9.5.201508210528
- Java 1.8 (JDK 8u92)
- Selenium server 2.53.0
- Chrome Driver 2.20


## Example

#### Video
A demo video uploaded on [Youtube](https://youtu.be/83J638-JNVI). 

#### Instantiation
This declaration launches WebDriver with built-in settings.

~~~java
TVTProfile profile = new TVTProfile(locale);
profile.setDebugLevel(debugLVL);
profile.setDirectory(mainDir,locale);
profile.setWait(waitTime,waitInterval);
profile.setDelay(actionDelay,screenDelay);
profile.setDriverPath(driverPath);
browser = new WebBrowser(browserType,profile);
~~~

External WebDriver instance can be used. This was working for my AVT project.

~~~java
browser = new WebBrowser(webdriver,tvtProfile);
~~~


#### Test Case

A sample test case script.

~~~java
browser.navigate().initURL("https://"+hostname);
browser.window().maxBound();
browser.waitFor().enabled(By.name("j_username")).actionsByDriver().sendKeys(username);
browser.waitFor().enabled(By.name("j_password")).actionsByDriver().sendKeys(password);
browser.waitFor().enabled(By.xpath("//*[@id='submitButton']/input")).actionsByDriver().click().delay(3000);
browser.frame().defaultContent();
browser.frame().switchTo(By.id(ID.qr_frame_rightPane));
browser.frame().switchTo(By.id(ID.qr_frame_rightPane));
browser.waitFor().displayed(By.xpath("//*[contains(@url,'pageId=DeviceExtensionList')]")).actionsByAction().move().delay(2000);
browser.waitFor().displayed(By.xpath("//*[contains(@url,'pageId=DeviceExtensionList')]")).actionsByDriver().click();
browser.window().selectNew();
browser.window().maximize();
browser.waitFor().enabled(By.name("mi.eventviewer.toolbar.newDeviceExtensionButton")).actionsByDriver().click();
browser.waitFor().enabled(By.id("saveButton")).actionsByDriver().click();
browser.waitFor().displayed(By.xpath("//*[@class='errorMessage']"));
browser.screen().advByDriver().saveScreen("08.420.010");
~~~

#### Next Step
Choice a testing framework (JUnit, TestNG, etc.) to manage test cases.

## License
To be determined.