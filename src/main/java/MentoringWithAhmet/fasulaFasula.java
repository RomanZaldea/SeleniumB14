package MentoringWithAhmet;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class fasulaFasula {
    @Test
    public void videoClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com/");
        Thread.sleep(5000);

        WebElement playButton= driver.findElement(By.xpath("//div[@class= 'jw-icon jw-icon-display jw-button-color jw-reset']"));
        playButton.click();
    }

    @Test
    public void inputsHeroku() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        WebElement inputs= driver.findElement(By.linkText("Inputs"));
        inputs.click();

        WebElement box= driver.findElement(By.xpath("//input[@type='number']"));
        String number="75";

        box.sendKeys( number);
        int x=Integer.parseInt(number);
        while (x!=70){
            Thread.sleep(1000);
            box.sendKeys(Keys.ARROW_DOWN);
            x--;
        }

    }
}
