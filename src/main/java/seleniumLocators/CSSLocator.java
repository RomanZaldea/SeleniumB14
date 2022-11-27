package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBar= driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("Watch", Keys.ENTER);
//        WebElement searchButton=driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
//        searchButton.click();



    }
}
