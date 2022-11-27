package SelectClass;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
     /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX-350
}
     */

    public void validateDreamCar() throws InterruptedException {
        WebDriverManager.chromedriver();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:www.cars.com");
        WebElement newCar= driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newCar,"new", "value" );

        WebElement brands= driver.findElement(By.id("makes"));
        BrowserUtils.selectBy(brands,"lexus", "value");

        WebElement models= driver.findElement(By.id("models"));
        BrowserUtils.selectBy(models,"lexus-rx_350", "value");

        WebElement priceBox= driver.findElement(By.id("make-model-max-price"));
        Select price= new Select(priceBox);

        WebElement firstOptionPrice=price.getFirstSelectedOption();
        String actualMessage=firstOptionPrice.getText().trim();
        String expectedMessage= "No max price";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement distance= driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40", "value");

        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        zipCode.sendKeys("60625");
        Thread.sleep(3000);

        WebElement searchButton= driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText().trim();
        String expectedHeader= "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);


        WebElement sortBy =driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Lowest price", "text");
        Thread.sleep(3000);
        List<WebElement> titles= driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement title:titles){
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));

        }
    }

    @Test
    public void validateHeaders(){
        WebDriverManager.chromedriver();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:www.cars.com");


        WebElement newUsed= driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"New", "text" );

        WebElement make= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");

        WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "RX 350", "text");

        WebElement price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceOption=new Select(price);
        WebElement firstOption=priceOption.getFirstSelectedOption();
        Assert.assertEquals(BrowserUtils.getText(firstOption), "No max price");

        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"3", "index");

        WebElement zipCode= driver.findElement(By.id("make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        //

        WebElement searchButton= driver.findElement(By.xpath("//*[@id=\"by-make-tab\"]/div/div[7]/button"));
        searchButton.click();

        WebElement header= driver.findElement(By.xpath("//*[@id=\"search-live-content\"]/header/div[1]/h1"));
        Assert.assertEquals(BrowserUtils.getText(header), "New Lexus RX 350 for sale");

        WebElement sorting= driver.findElement(By.id("sort-dropdown"));
        BrowserUtils.selectBy(sorting,"Lowest price","text");

        List<WebElement>allTitles=driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title:allTitles){
            System.out.println(BrowserUtils.getText(title));
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
            Assert.assertEquals(title.getText().trim().contains("Lexus RX 350"), true);
        }
    }

    @Test
    public void dreamCar2() throws InterruptedException {
        //HOMEWORK:
/*
1-Choose any car you want to buy
2-Whenever you choose the lowest price from sorting
3-VALIDATE the prices are from lowest to highest(remember 2 list)
4-After that choose the highest price from sorting
5-VALIDATE the prices are from highest to lowest(remember 2 list)
NOTE:I would think about replacing "$" and "," with nothing or with "." (if you want to use double)
NOTE:I would use lists for comparison
NOTE:Good luck
 */

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://www.cars.com/");
            WebElement newUsedButton = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
            newUsedButton.click();
            BrowserUtils.selectBy(newUsedButton,"new","value");
            WebElement pickLexus = driver.findElement(By.xpath("//select[@id='makes']"));
            BrowserUtils.selectBy(pickLexus,"toyota","value");
            WebElement allMakes= driver.findElement(By.xpath("//select[@id='models']"));
            BrowserUtils.selectBy(allMakes,"toyota-highlander_hybrid","value");
            WebElement priceValidation= driver.findElement(By.xpath("//select[@id= 'make-model-max-price']"));
            Select dropdown= new Select(priceValidation);
            WebElement firstSelected = dropdown.getFirstSelectedOption();
            Assert.assertEquals(BrowserUtils.getText(firstSelected),"No max price" );
            WebElement distanceBox= driver.findElement(By.id("make-model-maximum-distance"));
            BrowserUtils.selectBy(distanceBox,"150","value");
            WebElement zipBox= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
            zipBox.clear();
            zipBox.sendKeys("28226");
            WebElement searchBox= driver.findElement(By.xpath("//button[contains(text(), 'Search') and @data-searchtype='make']"));
            searchBox.click();
            Thread.sleep(2000);
            WebElement sortBox= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
            BrowserUtils.selectBy(sortBox,"Lowest price","text");
            Thread.sleep(3000);
            List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='primary-price']"));
            List<String> actualPrices = new ArrayList<>();
            List<String> expectedPrices = new ArrayList<>();
            expectedPrices.add("42656");
            expectedPrices.add("44177");
            expectedPrices.add("44800");
            expectedPrices.add("46902");
            expectedPrices.add("48757");
            expectedPrices.add("52685");
            expectedPrices.add("NotPriced");
            expectedPrices.add("NotPriced");
            for(int i = 0; i < allPrices.size(); i++ ){
                Thread.sleep(1000);
                actualPrices.add(allPrices.get(i).getText().trim().replaceAll("[^0-9A-Za-z]",""));
            }
            Thread.sleep(1000);
            System.out.println(actualPrices);
            System.out.println(expectedPrices);
            Assert.assertEquals(actualPrices,expectedPrices);
            Thread.sleep(3000);
            WebElement sortBoxHigh= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
            BrowserUtils.selectBy(sortBoxHigh,"Highest price","text");
            Thread.sleep(3000);
            List<WebElement> allPrices2 = driver.findElements(By.xpath("//span[@class='primary-price']"));
            List<String> actualPrices2 = new ArrayList<>();
            for(int i = 0; i < allPrices2.size(); i++ ){
                Thread.sleep(1000);
                actualPrices2.add(allPrices2.get(i).getText().trim().replaceAll("[^0-9A-Za-z]",""));
            }
            Thread.sleep(1000);
            Collections.reverse(expectedPrices);
            System.out.println(actualPrices2);
            System.out.println(expectedPrices);
            Assert.assertEquals(actualPrices2, expectedPrices);
            driver.quit();

    }
}
