package SeleniumRecap;

public class SeleniumRecapAndInterviewQuestions {

     /*            COMMON INTERVIEW QUESTION IN SELENIUM:
    1. What are the advantages and disadvantages of Selenium?
              Advantage                                    Disadvantages
    -open source                                  - you can't automate CAPTCHA
    -it supports multiple programming             mobile applications(APPIUM)
    languages (java, python, C#)                 -No customer support
    - It supports multiple browsers               - It only automates web applications
    (Chrome, Firefox, Safari... etc)              - Doesn't have any system to generate report(can be done with TestNg)
    2. What type of testing can you automate with Selenium?
    * Regression
    * Smoke
    * Functional Testing (positive, negative...etc)
    3. What are the test types that you can't automate with Selenium?
   * Performance Testing
   * Manual Testing
   * Non-Functional Testing (Stress, Load Testing...etc)
   4. What are  Locators? Which one do you use the most?
   * With locators, we can find the elements from DOM (Document Object Model)
   There are several locators:
   * ID, ClassName, Name, TagName, LinkText, PartialLinkText, Xpath, CSS;
   I mostly use CSS and XPATH since they are really fast and useful.
   5. How do you handle dynamic elements? (CVS --> job question)
    In my Project I faced many dynamic elements, (facebook example) and I use different ways to handle this situation,
    and based on my "research":
    --> I used parent-child relationship to locate the element
    --> I used different attributes to locate the element
    --> I used Xpath methods (following-sibling, contains, preceding-sibling)
   6. What is the difference between driver.get() and driver.navigate.to()?
   * driver.get() --> it goes to the website and waits for all the elements to be loaded then continues
   driver.get() --> doesn't have any methods
   * driver.navigate.to() --> it goes to the website but waits for only certain elements to be loaded
   driver.navigate.to() --> it has methods (to, refresh, back, quit())
   7. What is the difference between driver.close() and driver.quit()?
   * driver.close() --> it closes the only page that is open(getWindowHandle, one tab)
   * driver.quit() --> it closes the all pages that are open (all pages)
   8. What is Xpath? Can you tell me how many types of Xpath are there ? Which one do you use in your Framework?
   * Xpath --> it is used to find the location of the element on the webpage by using HTML structure
   -absolute Xpath (/) : it goes all the way from parent to child(/HTML/div/img/a/p)
   -relative Xpath (//) : It directly or parent-child fids an element
   Example --> driver. find_element_by_xpath("//input[@id='job']/parent::div")
   * In my Project I mostly use relative Xpath, because it focuses on the child which I need
   to locate. I need to locate (It saves lots of time and effort)
   9. What is the difference between absolute and relative Xpath?
   * Absolute Xpath -->  It goes from all the of parent-child, syntax is different , it has a single slash
   * Relative Xpath -->  it has (//), syntax is different, It directly or parent-child fids an element
   10. How do you handle Dropdowns?
   --> In my Project I was handling dropdowns in different ways:
   -I would check the tagName of the location, if the location has Select tagName --> I use Select Class
   Select select = new Select(location)
   - If the location doesn't have the tagName --> I just find the element and sendKeys()
   - I can also use ACTION CLASS to Hover Over my element (moveToElement().perform())
   11 . What kind of methods do you use for Select Class?
   Select Class is really important for my Project, to be able to use it element must have select tagName
   - SelectByVisibleText()
   - SelectByValue()
   - SelectByIndex()
   I generally call my BrowserUtils method which takes care of these types.
   12. What kind of EXCEPTIONS have you ever faced during UI Automation?
   - NoSuchElement Exception --> if path is wrong, different window, iframe, wait times
   - NullPointer Exception --> driver or the web Page is not initialized
   - StaleElementReference Exception --> changing the values on  DOM is update or refreshed
   - ElementNotInteractable Exception --> element is not visible (Scroll down)
   - TimeOut Exception --> it happens for wait times (Explicit Wait and Fluent Wait)
   - NoSuchFrame Exception --> if the frame is wrong (id = 'Pup'] you accidentally put something wrong
   - AlertUnhandled Exception --> when you try to switch to alert (driver) and no alert the moment
   13. In what condition do you gt StaleElementReference Exception? How do you handle it?
   * In my project, I had a hard time with StaleElementReference Exception to handle :
   --> Once the element is not in DOM anymore
   --> Once the element is updated (changed value) the value in DOM (document object model)
   Based on my research I found 3 ways:
   - I can reassign the web element that i already found
   - I use Thread.sleep() before   StaleElementReference Exception
   - I refresh the page
   14. How do handle ALERTS / POP-UPS?
   There are different types of Alerts, I faced in my framework:
   - Operation System (OS) Alerts --> I can handle it directly with "robot class"
   - HTML Alert --> just find the element and lick on it
   - Javascript Alert --> I handle this alert with ALERT INTERFACE
   Alert alert = driver.switchTo().Alert()
   15. For the Alert Interface what kind of methods do you use to handle?
   * First, Alert is an Interface and  has some methods to handle JS pop-ups:
    * Alert alert = driver.switchTo().Alert()
    - alert.accept() --> it clicks "OK"
    -alert.dismiss() --> it clicks "CANCEL"
    -alert.GetText() --> it gets the text from JS alert
    - alert.sendKeys() --> it sends keys to JS alert
   16. What do you know about Iframe? Can you tell me the type you used before and how do you handle Iframe in Selenium?
  Scenario: We have a website, and I would like to get the price from products. All Xpath are correct and there is no problem with windows,
  but I am still having issue to get the text from website, wht would be your approach?
  - Iframe is basically html inside html, the reason people are using iframe to encapsulate some ads, videos docs.
  - the reason could be Iframe, so basically I would go to the website and check HTML has an Iframe tag name. If there is an iframe on HTML,
  I would definitely check that my element is under this iframe
  - I can handle iframe: driver.switchTo().frame(id, element, index)
  - parent frame (goes to parent frame) and defaultContent(goes directly to the HTML)
  17. What do you know about ACTIONS Class?
  * Actions class basically "mouse" functionality (Keys is all about Keyboard)
  It is really useful in my Project to handle some dropdowns and do some mouse actions:
  - *** perform()***
  - moveToElement()
  - DragAndDrop()
  - ClickAndHold()release()
  - contextClick() <-- we do right click
  - click()
  - doubleClick()
  -sendKeys()
  18. What is the difference between FindElement() and FindElements()?
  FindElement(): driver.findElement(By.(""))
  return the single web element, if it fails  it throws "NoSuchElement" exception
  FindElement(): driver.findElements(By.(""))
  returns a List<WebElements>, if it fails it gives and empty arrayList []
  No exception
  19. What are the driver and webElement methods do you use in your Framework?
  Driver Methods:
  driver.Get(), navigate(), findElement(), getCurrentUrl(), getPageSource()
  GetWindowHandle(), SwitchTo(), close(), quit(), manage()
  WebElement Methods : sendKeys(), getTitle(), isEnabled(), isSelected(), getAttribute()
  getCssValue(), clear(), click()
  20. What is the difference between Check-Box and Radio Button?
  -Check-Box : you can click multiple buttons at the time
  -Radio Button: you can choose only one option
  21. What is the difference between isDisplayed(), isSelected() and isEnabled()?
  - all of them return boolean conditions
  - isDisplayed() - it checks if the element is visible or not
  - isSelected() - it checks (radio buttons, box) if the element is selected or not
  - isEnabled() - it checks if the element is enabled or not (disabled button)
  22. How do you handle windows in Selenium?
  - I can use  driver.windowGetWindowHandle() and driver.windowGetWindowHandles() to switch my windows,
  and get element which is in another window. I have a browserUtils package that has a specific implementation to handle it
  --> I use contains method for title/url to switch my window(BrowserUtils)
   Syntax --> driver.switchTo().window(id)
  23. What is the difference between GetWindowHandle() and GetWindowHandles()
  - GetWindowHandle() --> returns a String
  - GetWindowHandles() --> returns a Set (window is unique)
  24. How do you scroll-down or scroll-up on the web Page?
  - ***I would use JAVASCRIPT SCROLL INTO VIEW method (mostly)***
  - Actions class --> ScrollByAmount(x, y), KEYS_Arrow-up, KEYS_Arrow-down
  25. How do you upload or download files in Selenium?
  - I know how to upload: we need to find the choose file which is a button, that triggers the Operating System pop-up.
   -We'll find the location of the file to be uploaded.(/C/desktop/usa.png)
  - choosefile.sendKeys(location of the file)
  26. What is the difference between Assert and SoftAssert?
  - Assert :  is a class that has methods to validate actual and expected values.
  (Assert.assertEquals .. ), when it fails it immediately throws an Exception then stops the execution of the next code line
  - SoftAssert: is a class that has methods to validate actual and expected values
    (SoftAssert.assertAll .. ) when it fals it keeps executing next code lines .
  To activate SoftAssert we need to create an Object:
  SoftAssert softassert = new SoftAssert();
  softAssert.assertAll()
  27. Can you tell me about Singleton Pattern? Can you make your Constructor Private?
  - first, it is a nice question since I like the design logic in my Framework.
  - while I was working on some test cases I was getting the NULLPOINTEREXCEPTION many times
  because the driver was not centralized. With the help of Singleton, the amount of Exception it decreased
  significantly and saved my effort on Automation-testing.
  --> How do you create the Singleton Pattern:
  - I need to make a private Constructor
  - I create a public static method to call from classes (Driver Helper.getDriver())
  - I use a condition to check my "Status OF DRIVER" (it is null or not)
  28. What do you know about TestNG annotations?
  --> @Test --> it executes your code
  --> @BeforeMethod --> it runs every test annotation
  --> @AfterMethod --> it runs every test annotation
  --> @Parameter --> it provides parameters from xml file
  --> @DataProvider --> it runs same test with different set of data
  29. How do you handle wait time in your Project?
  --> Implicit Wait, Explicit Wait, Fluent Wait --> Thread.sleep(not professional)
  30. Can you tell me how do you provide pictures once you find the bug?
  In my Project, I have a good implementation for screenshot.
  - I follow the bug cycle and during that process I use screenshot as a guidance to identify the problem.
  --> Talk about Bug Cycle (Soft Skill Class)
     */
}
