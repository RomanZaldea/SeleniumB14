package seleniumLocators;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubePractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com");

        WebElement searchBar= driver.findElement(By.name("search_query"));
        searchBar.sendKeys("Justin Bieber");

        WebElement searchButton= driver.findElement(By.id("search-icon-legacy"));
        Thread.sleep(4000);
        searchButton.click();
        Thread.sleep(4000);


        List<WebElement> list=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement element:list){
            if (element.getText().equals("Justin Bieber - Baby ft. Ludacris")){
                element.click();
            }
        }

    }
}
