package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        WebElement multipleWindow= driver.findElement(By.linkText("Multiple Windows"));
        multipleWindow.click();

        WebElement clickHere= driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        String mainPageId=driver.getWindowHandle();
        System.out.println(mainPageId);

        Set <String> allPagesId=driver.getWindowHandles();
        System.out.println(allPagesId);

        for (String id:allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Window");

    }

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        /*
TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Click click me button
  6-Quit the tabs
 */


        WebElement newTab= driver.findElement(By.id("newTabBtn"));
        newTab.click();

        String mainIdPage=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();

        for (String id:allPagesId){
            if (!id.equals(mainIdPage)){
                driver.switchTo().window(id);
            }
        }
        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");

        WebElement header= driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo");

        WebElement alertBox=driver.findElement(By.id("alertBox"));
        alertBox.click();
        driver.quit();

    }
}
