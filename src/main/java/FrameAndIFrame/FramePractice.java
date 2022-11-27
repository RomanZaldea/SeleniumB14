package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramePractice {
    /*
TASK 1:
1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
2-Click Pavillion and Click Selenium-java under Selenium option
3-Validate the header " Selenium-Java Tutorial – Basic to Advance"
*/


    @Test
    public void task1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");

        WebElement pavilion= driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver, "qavalidation");

        WebElement selenium= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();

        WebElement seleniumJava= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        seleniumJava.click();

        WebElement header= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header), "Selenium-Java Tutorial – Basic to Advance");


        //Task2
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Framename1");

        WebElement category1= driver.findElement(By.linkText("Category1"));
        category1.click();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");

        WebElement headerArchive=driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(headerArchive), "Category Archives: SeleniumTesting");

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().parentFrame();

        WebElement iframe2= driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(iframe2);

        //Task3
        WebElement category3= driver.findElement(By.linkText("Category3"));
        category3.click();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives: SeleniumTesting");

        WebElement headerSoftware= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(headerSoftware), "Category Archives: SoftwareTesting");


    }
/*
TASK 2:
1-Go back to the main page
2-click "category1"
3-validate the header "Category Archives: SeleniumTesting"
*/

    /*
TASK 3:
1-Go back to the main page
2-click category 3 and validate
3-validate the header "Category Archives: SoftwareTesting"

 */
}
