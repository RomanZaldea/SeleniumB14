package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrames {
    @Test
    public void NestedFrames(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");

        WebElement nestedFrame= driver.findElement(By.linkText("Nested Frames"));
        nestedFrame.click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement text= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(text));

        //Task--> Middle, Right
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement textMiddle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(textMiddle));

        driver.switchTo().parentFrame();
        WebElement frameRight = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        driver.switchTo().frame(frameRight); // with web element
        //driver.switchTo().frame("frame-right");

        WebElement textRight = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(textRight));
        //Task : Bottom
//        driver.switchTo().parentFrame(); //top
//        driver.switchTo().parentFrame();//html
        driver.switchTo().defaultContent(); // directly going to Html
        driver.switchTo().frame(1);

        WebElement textBottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(textBottom));
        Assert.assertEquals(BrowserUtils.getText(textBottom), "BOTTOM");
    }

}
