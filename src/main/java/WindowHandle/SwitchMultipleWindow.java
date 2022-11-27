package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindow {
    @Test
    public void multipleBrowserWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about-us')");
        js.executeScript("window.open('https://www.techtorialacademy.com/programs')");

        /*Set<String> allPages=driver.getWindowHandles();
        for (String id:allPages){
            driver.switchTo().window(id);
            if (driver.getTitle().contains("About Us")){
                break;
            }
        }*/

        BrowserUtils.switchByTitle(driver, "About Us");
        Assert.assertEquals(driver.getTitle().trim(),"About Us - Techtorial");
        Thread.sleep(3000);

        BrowserUtils.switchByTitle(driver,"Programs");
        Assert.assertEquals(driver.getTitle().trim(), "Programs - Techtorial");
        driver.quit();
    }


    @Test
    public void practice3() throws InterruptedException {
        /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(4000);


        WebElement button4=driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollIntoView(driver, button4);
        button4.click();

        BrowserUtils.switchByTitle(driver,"Basic Controls");

        WebElement firstName= driver.findElement(By.id("firstName"));
        firstName.sendKeys("Kiril");

        WebElement lastName= driver.findElement(By.id("lastName"));
        lastName.sendKeys("Voloc");

        WebElement maleFemale= driver.findElement(By.id("malerb"));
        if (!maleFemale.isSelected()){
            maleFemale.click();
        }

        WebElement language= driver.findElement(By.id("frenchchbx"));
        if (!language.isSelected()){
            language.click();
        }

        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("Kiril.Voloc@kifal.com");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("fasula");

        WebElement registerButton= driver.findElement(By.id("registerbtn"));
        BrowserUtils.scrollIntoView(driver, registerButton);
        registerButton.click();

        WebElement message= driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertEquals(message.getText().trim(), "Registration is Successful");

        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Window Handles Practice");
        Assert.assertEquals(driver.getTitle().trim(), "Window Handles Practice - H Y R Tutorials");

        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "AlertsDemo");

        WebElement promptBox= driver.findElement(By.id("promptBox"));
        promptBox.click();

        driver.quit();
    }

}
