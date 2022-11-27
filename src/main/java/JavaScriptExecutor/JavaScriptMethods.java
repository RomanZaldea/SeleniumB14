package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptMethods {
    /*
    JavaScript is really efficient once your normal selenium methods are not working as expected

    JavaScript is a different language, so it is not recomended to not use java and JavaScript all the time.
    JavaScript should be your last option to use.
    For example, you try to click the element and webelement.click is not working
    then you should try Actions.click, if it is not working
    Use JavaScript click method
     */

    @Test
    public void getTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        System.out.println("Get title with driver " + driver.getTitle() );
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get the title with js " + title );
    }
    @Test
    public void clickJavaScript() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement onlineCourse = driver.findElement(By.xpath("//a[.= 'Online Course']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",onlineCourse);
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle = "Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void scrollIntoView() throws InterruptedException { // scroll into whatever element to view
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(), '© Copyrights 2022 Techtorial - All Rights Reserved')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", copyRight);
        Thread.sleep(3000);
        WebElement onlineCourse = driver.findElement(By.xpath("//a[.= 'Online Course']"));
        js.executeScript("arguments[0].scrollIntoView(true)",onlineCourse);
    }
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browseButton = driver.findElement(By.xpath("//a[contains(text(), 'Browse Course')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", browseButton);
        js.executeScript("arguments[0].click()",browseButton);
        Thread.sleep(1000);
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle = "Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(1000);
        WebElement informationButton = driver.findElement(By.xpath("//h2[.='information']"));
        js.executeScript("arguments[0].scrollIntoView(true)", informationButton);
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        js.executeScript("arguments[0].scrollIntoView(true)", loginButton);
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void shorCutTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement browser=driver.findElement(By.linkText("Browse Course"));
        BrowserUtils.scrollIntoView(driver,browser);
        BrowserUtils.clickWithJavaScript(driver,browser);
        String actualTitle=BrowserUtils.getTitleWithJavaScript(driver);
        String expectedTitle="Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement information=driver.findElement(By.xpath("//h2[.='information']"));
        BrowserUtils.scrollIntoView(driver,information);
        WebElement studentLogin=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        BrowserUtils.scrollIntoView(driver,studentLogin);
    }

    @Test
    public void validatingTheSDET(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
    }
}
