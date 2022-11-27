package TestNG;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.security.Key;
import java.time.Duration;
import java.util.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class TestNGPractice {
    ///*
    //        TASK:
    //        1-login successfully-->username--demo password -->demo
    //        2-validate(ASSERT) title -->Dashboard
    //         */
    @Test
    public void validateTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName= driver.findElement(By.xpath("//input[@name= 'username']"));
        userName.sendKeys("demo");

        WebElement password= driver.findElement(By.xpath("//input[@name= 'password']"));
        password.sendKeys("demo");

        WebElement login= driver.findElement(By.xpath("//button[@class= 'btn btn-primary']"));
        login.click();

        WebElement xButton= driver.findElement(By.xpath("//button[@class= 'btn-close']"));
        xButton.click();

        String actualTitle= driver.getTitle();
        String expectedTitle= "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void validateUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.xpath("//input[@name= 'username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@name= 'password']"));
        password.sendKeys("demo");
        WebElement login= driver.findElement(By.xpath("//button[@class= 'btn btn-primary']"));
        login.click();

        Thread.sleep(1000);
        WebElement xButton= driver.findElement(By.xpath("//button[@class= 'btn-close']"));
        xButton.click();

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "https://demo.opencart.com/admin/index.php?route=common/dashboard&user_token=";
        //Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void validateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.xpath("//input[@name= 'username']"));
        userName.sendKeys("demo");

        WebElement password= driver.findElement(By.xpath("//input[@name= 'password']"));
        password.sendKeys("demo");

        WebElement login= driver.findElement(By.xpath("//button[@class= 'btn btn-primary']"));
        login.click();

        Thread.sleep(1000);
        WebElement xButton= driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();

        WebElement catalogButton= driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        Thread.sleep(2000);
        WebElement productsButton= driver.findElement(By.xpath("//*[@id=\"collapse-1\"]/li[2]/a"));
        Assert.assertTrue(productsButton.isDisplayed());
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.xpath("//input[@name= 'username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@name= 'password']"));
        password.sendKeys("demo");
        WebElement login= driver.findElement(By.xpath("//button[@class= 'btn btn-primary']"));
        login.click();
        Thread.sleep(1000);
        WebElement xButton= driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton= driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();
        WebElement productsButton= driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productsButton.click();
        Thread.sleep(1000);
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            assertTrue(allBoxes.get(i).isDisplayed());
            assertTrue(allBoxes.get(i).isEnabled());
            allBoxes.get(i).click();
            assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName= driver.findElement(By.xpath("//input[@name= 'username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@name= 'password']"));
        password.sendKeys("demo");
        WebElement login= driver.findElement(By.xpath("//button[@class= 'btn btn-primary']"));
        login.click();
        Thread.sleep(3000);
        WebElement xButton= driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton= driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();
        WebElement productsButton= driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productsButton.click();
        WebElement productName= driver.findElement(By.xpath("//a[@class='asc']"));
        productName.click();
        Thread.sleep(1000);
        List <WebElement> allBrands = driver.findElements(By.xpath("//td[@class='text-start']")); //11
        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();
        for(int i = 1; i < allBrands.size(); i++){
            Thread.sleep(1000);
            actualBrands.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedBrands.add(allBrands.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(1000);
        Collections.sort(expectedBrands); // sort all brands
        Collections.reverse(expectedBrands);
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
        assertEquals(actualBrands,expectedBrands);
        driver.quit();
    }
}