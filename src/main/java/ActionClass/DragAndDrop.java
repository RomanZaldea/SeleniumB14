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
public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies= driver.findElement(By.xpath("//button[@id= 'onetrust-accept-btn-handler']"));
        acceptCookies.click();
        WebElement dragButton = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox2 = driver.findElement(By.xpath("//div[@class= 'test2']"));
        Thread.sleep(2000);
        String actual = BrowserUtils.getText(dropBox2);
        String expected = "... Or here.";
        Assert.assertEquals(actual,expected); // validating the message
        Thread.sleep(2000);
        // we need to create the object for drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragButton,dropBox2).perform();
        dropBox2 = driver.findElement(By.xpath("//div[@class= 'test2']"));
        String actualMessageAfterDrop = BrowserUtils.getText(dropBox2);
        String expectedMessageAfterDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
        Thread.sleep(2000);
        String orangeBackgroundColor= dropBox2.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(orangeBackgroundColor, expectedBackgroundColor);
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void validateBox1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies= driver.findElement(By.xpath("//button[@id= 'onetrust-accept-btn-handler']"));
        acceptCookies.click();
        WebElement dragButton = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox1 = driver.findElement(By.xpath("//div[@class= 'test1']"));
        String actual = BrowserUtils.getText(dropBox1);
        String expected = "Drag the small circle here ...";
        Assert.assertEquals(actual,expected); // validating the message
        Thread.sleep(2000);
        // we need to create the object for drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragButton,dropBox1).perform();
        dropBox1 = driver.findElement(By.xpath("//div[@class= 'test1']"));
        String actualMessageAfterDrop = BrowserUtils.getText(dropBox1);
        String expectedMessageAfterDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDrop,expectedMessageAfterDrop);
        Thread.sleep(2000);
        String orangeBackgroundColor= dropBox1.getCssValue("background-color");
        String expectedBackgroundColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(orangeBackgroundColor, expectedBackgroundColor);
        Thread.sleep(2000);
        driver.quit();
    }
    /*
        1-navigate to the website https://demoqa.com/droppable
        2-Validate the message inside of the Big box us "Drop Here" -->first validation
        3-Get the "Drag me" box and put it into Big box -->DragAndDrop Method
        4-Validate the message turned to the "Dropped"
        5-Validate the color turned to the "rgba(....)-->you guys know how to get it.
         */
    @Test
    public  void  clickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Assert.assertEquals(BrowserUtils.getText(drop),"Drop here");
        actions.clickAndHold(drag).moveToElement(drop).release().perform();
        Assert.assertEquals(BrowserUtils.getText(drop),"Dropped!");
        Assert.assertEquals(drop.getCssValue("color"), "rgba(33, 37, 41, 1)");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public  void  clickAndHold2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement click = driver.findElement(By.id("notAcceptable"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Assert.assertTrue(BrowserUtils.getText(drop).equals("Drop here"));
        actions.clickAndHold(click).moveToElement(drop).release().perform();
        drop = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Assert.assertTrue(BrowserUtils.getText(drop).equals("Drop here"));
        Thread.sleep(2000);
        driver.quit();

    }
}