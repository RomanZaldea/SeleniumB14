package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chromedriver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");


        WebElement horizontalSlider= driver.findElement(By.linkText("Horizontal Slider"));
        horizontalSlider.click();

        WebElement horizontalSliderHeader= driver.findElement(By.tagName("h3"));
        System.out.println(horizontalSliderHeader.getText().trim());

        WebElement paragraph=driver.findElement(By.tagName("h4"));
        System.out.println(paragraph.getText().trim());

        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
        driver.quit();
    }
}
