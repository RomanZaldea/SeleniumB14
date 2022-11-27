package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestDiaryPractice {
     /*
NOTE:You can use any locator you want(id,classname,xpath,tagname....)
TASK 1:
1-Navigate to the website http://www.testdiary.com/training/selenium/selenium-test-page/
2-print out selenium test page from website
3-print out the paragraph from the  page
4-Check the selenium box is displayed or not, if it is displayed and not selected then click
5-Click java radio button
6-Click Save
*/
    /*
TASK 2:HyperLink Task:
1-Click the Test Dairy link with linktext
2-print out the header,title and currentUrl of Test Dairy from opening page
3-Navigate back to main page
4-Click Test Diary Selenium learning with PartialLinkText
5-print out the header,title and currentUrl of Test Dairy from opening page
6-Navigate back to the mainpage
TASK 3:Contact Form

1-Fill the all the boxes (yourname,youremail,subject and your message)
2-Click save button
3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."
 */

    /*
NOTE:You can use any locator you want(id,classname,xpath,tagname....)
TASK 1:
1-Navigate to the website http://www.testdiary.com/training/selenium/selenium-test-page/
2-print out selenium test page from website
3-print out the paragraph from the  page
4-Check the selenium box is displayed or not, if it is displayed and not selected then click
5-Click java radio button
6-Click Save
*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement seleniumHeader=driver.findElement(By.xpath("//h1[contains(text(),'Selenium Test Page')]"));
        System.out.println(seleniumHeader.getText().trim());
        WebElement paragraph=driver.findElement(By.tagName("strong"));
        System.out.println(paragraph.getText().trim());
        WebElement seleniumBox=driver.findElement(By.id("seleniumbox"));
        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }
        WebElement javaRadioButton=driver.findElement(By.id("java1"));
        javaRadioButton.click();
        WebElement saveButton=driver.findElement(By.xpath("//button[@id='demo']"));
        saveButton.click();
            /*
TASK 2:HyperLink Task:
1-Click the Test Dairy link with linktext
2-print out the header,title and currentUrl of Test Dairy from opening page
3-Navigate back to main page
4-Click Test Diary Selenium learning with PartialLinkText
5-print out the header,title and currentUrl of Test Dairy from opening page
6-Navigate back to the mainpage
        */
        WebElement testDiaryLink=driver.findElement(By.linkText("Test Diary"));
        testDiaryLink.click();
        WebElement headerTest=driver.findElement(By.xpath("//h1"));
        System.out.println(headerTest.getText().trim());
        System.out.println(driver.getTitle().trim());
        System.out.println(driver.getCurrentUrl().trim());
        driver.navigate().back();
        WebElement diarySelenium=driver.findElement(By.partialLinkText("Selenium Learning"));//it must have a tag and text
        diarySelenium.click();
        WebElement headerDiarySelenium=driver.findElement(By.tagName("h1"));
        System.out.println(headerDiarySelenium.getText().trim());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
            /*
1-Fill the all the boxes (yourname,youremail,subject and your message)
2-Click save button
3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."
            */
        WebElement username=driver.findElement(By.name("your-name"));
        username.sendKeys("Ahmet");
        WebElement email=driver.findElement(By.name("your-email"));
        email.sendKeys("ahmet@gmail.com");
        WebElement subject=driver.findElement(By.xpath("//input[@name='your-subject']"));
        subject.sendKeys("Information Technology");
        WebElement textArea=driver.findElement(By.name("your-message"));
        textArea.sendKeys("Hello from Outside -->Adele");
        WebElement sendButton=driver.findElement(By.xpath("//input[@value='Send']"));
        sendButton.click();
        WebElement message=driver.findElement(By.xpath("//div[@style='display: block;']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="Your message was sent successfully. Thanks.";
        if(actualMessage.equals(expectedMessage)){
            System.out.println("your message is correct");
        }else{
            System.out.println("your message is incorrect");
        }
    }
}

