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

public class AlertPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");

        WebElement previewFirst= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewFirst.click();

        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Oops, something went wrong!");
        alert.accept();

        WebElement previewSecond= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewSecond.click();

        WebElement message= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        Assert.assertTrue(BrowserUtils.getText(message).contains("Something went wrong!"));

        WebElement okButton= driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


    }
}
