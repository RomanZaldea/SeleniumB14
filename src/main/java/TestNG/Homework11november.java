package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Homework11november {
    /*
     1. Click productName two times and validate this is ascendending order
     2. Check the functionality of the top box(select all, unselect all)
    */
    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
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
        List<WebElement> allBrands = driver.findElements(By.xpath("//td[@class='text-start']")); //11
        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();
        for(int i = 1; i < allBrands.size(); i++){
            Thread.sleep(1000);
            actualBrands.add(allBrands.get(i).getText().toLowerCase().trim());
            expectedBrands.add(allBrands.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(1000);
        Collections.sort(expectedBrands); // sort all brands
        //Collections.reverse(expectedBrands);
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
        assertEquals(actualBrands,expectedBrands);
        driver.quit();
    }
    @Test
    public void checkFunctionality() throws InterruptedException {
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
        WebElement checkBox= driver.findElement(By.xpath("//input[@class='form-check-input']"));
        checkBox.click();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        if(checkBox.isSelected()){
            for (int i = 1; i < allBoxes.size() ; i++) {
                Thread.sleep(2000);
                Assert.assertTrue(allBoxes.get(i).isSelected());
            }
        }
        checkBox.click();
        if(!checkBox.isSelected()){
            for (int i = 1; i < allBoxes.size() ; i++) {
                Thread.sleep(2000);
                Assert.assertTrue(!allBoxes.get(i).isSelected());
            }
        }
    }
}
