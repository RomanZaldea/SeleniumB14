package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class HoverOver {
    @Test
    public void HoverOverPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allNames=driver.findElements(By.tagName("h5"));
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions action=new Actions(driver);

        for (int i=0;i<allImages.size();i++){
            Thread.sleep(3000);
            action.moveToElement(allImages.get(i)).perform();
            System.out.println(BrowserUtils.getText(allNames.get(i)));
            actualNames.add(allNames.get(i).getText().trim());
        }
        Assert.assertEquals(actualNames, expectedNames);
    }

    @Test
    public void HoverOverPractice2(){


        /*
1-Navigate to the website
2-If you have accept cookies then click it
3-Get all the names and store them in the list<STRING>
4-Get all the prices and store them in the List<Double>
5-Put them all of the names and prices in the map(LOOP)

CLUES:You can use 1 regular loop for adding the name and prices into the lists
CLUES:You can use 1 loop for putting into the map
CLUES:TO be able to get the names and prices you need to hoverover
CLUES:DO not forget perform

 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));//30 pictures
        List<WebElement> allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));//30 names
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));//30 prices
        WebElement acceptCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();
        Actions actions=new Actions(driver);
        Map<String,String> foodAndPrice=new HashMap<>();
        for(int i = 0;i<allImages.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            foodAndPrice.put(allNames.get(i).getText().trim(),allPrices.get(i).getText().trim());
        }
        System.out.println(foodAndPrice);

    }
}
