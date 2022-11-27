package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.time.Duration;
import java.util.List;

public class YahooRealInterviewQuestion {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement news=driver.findElement(By.xpath(("//a[contains(text(),'News')]")));
        news.click();

        List<WebElement> allTabs=driver.findElements(By.xpath("//h3"));
        for (WebElement tab:allTabs){
            System.out.println(tab.getText().trim());
        }





    }
}
