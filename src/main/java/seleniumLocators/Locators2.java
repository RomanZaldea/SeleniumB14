package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/User/Desktop/Techtorialhtml.html");

        //LOCATOR:LinkText
        WebElement java=driver.findElement(By.linkText("Java"));
        java.click();

        WebElement javaHeader= driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText().trim());
        driver.navigate().back();

        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();

        WebElement seleniumHeader= driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim());
        driver.navigate().back();

        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.click();

        WebElement cucumberHeader= driver.findElement(By.tagName("h1"));
        System.out.println(cucumberHeader.getText().trim());
        driver.navigate().back();

        WebElement testNG=driver.findElement(By.linkText("TestNG"));
        testNG.click();

        WebElement testNGHeader= driver.findElement(By.tagName("h2"));
        System.out.println(testNGHeader.getText().trim());
        driver.navigate().back();

        //LOCATOR: PartialLinkText

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());



    }
}
