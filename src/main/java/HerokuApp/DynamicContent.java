package HerokuApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicContent {
    @Test
    public void dynamicContent() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(1000);
        WebElement dynamicContent = driver.findElement(By.linkText("Dynamic Content"));
        dynamicContent.click();
        Thread.sleep(3000);
        WebElement firstImg = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
        WebElement firstText= driver.findElement(By.xpath("//div[@id='content']//div/div[1]/div[2]"));
        String firstTextElement= firstText.getText();
        String firstImgUrl = firstImg.getAttribute("src");
        WebElement secondImg = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img"));
        WebElement secondText= driver.findElement(By.xpath("//div[@id='content']//div/div[2]/div[2]"));
        String secondTextElement = secondText.getText();
        String secondImgUrl = secondImg.getAttribute("src");
        WebElement thirdImg = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img"));
        WebElement thirdText= driver.findElement(By.xpath("//div[@id='content']//div/div[3]/div[2]"));
        String thirdTextElement = thirdText.getText();
        String thirdImgUrl = thirdImg.getAttribute("src");
        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement firstImgAfter = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
        String firstImgUrlAfter = firstImgAfter.getAttribute("src");
        Thread.sleep(1000);
        WebElement secondImgAfter = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img"));
        String secondImgUrlAfter = secondImgAfter.getAttribute("src");
        WebElement thirdImgAfter = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img"));
        String thirdImgUrlAfter = thirdImgAfter.getAttribute("src");
        Thread.sleep(1000);
        WebElement firstTextAfter= driver.findElement(By.xpath("//div[@id='content']//div/div[1]/div[2]"));
        String firstTextElementAfter= firstTextAfter.getText();
        Thread.sleep(1000);
        WebElement secondTextAfter= driver.findElement(By.xpath("//div[@id='content']//div/div[2]/div[2]"));
        String secondTextElementAfter = secondTextAfter.getText();
        Thread.sleep(1000);
        WebElement thirdTextAfter= driver.findElement(By.xpath("//div[@id='content']//div/div[3]/div[2]"));
        String thirdTextElementAfter = thirdTextAfter.getText();
        Thread.sleep(1000);
        Assert.assertTrue(((firstImgUrl==firstImgUrlAfter) && (firstTextElement != firstTextElementAfter))||
                ((firstImgUrl!=firstImgUrlAfter) && (firstTextElement != firstTextElementAfter)));
        Assert.assertTrue(((secondImgUrl==secondImgUrlAfter) && (secondTextElement != secondTextElementAfter))||
                ((secondImgUrl!=secondImgUrlAfter) && (secondTextElement != secondTextElementAfter)));
        Assert.assertTrue(((thirdImgUrl==thirdImgUrlAfter) && (thirdTextElement != thirdTextElementAfter))||
                ((thirdImgUrl!=thirdImgUrlAfter) && (thirdTextElement != thirdTextElementAfter)));
    }
}
