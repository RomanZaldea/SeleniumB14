package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovingSlider {
    @Test
    public void validateSlider(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider= driver.findElement(By.xpath("//input[@type='range']"));

        WebElement range= driver.findElement(By.xpath("//span[@id='range']"));

        String rangeNumber="3.5";

        while (!BrowserUtils.getText(range).equals(rangeNumber)){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(BrowserUtils.getText(range), rangeNumber);





    }
}
