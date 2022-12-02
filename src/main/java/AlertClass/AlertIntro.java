package AlertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JsAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        JsAlert.click();

        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        WebElement message= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message), "You successfully clicked an alert");
    }

    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JsPrompt= driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        JsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Ahmet");
        alert.accept();

        WebElement message= driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(BrowserUtils.getText(message), "You entered: Ahmet");


    }
}
