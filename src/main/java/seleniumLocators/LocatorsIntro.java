package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro {
    public static void main(String[] args) {
//ID locator
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/User/Desktop/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        String actualHeader=header.getText().trim();
        String expectedHeader="Techtorial Academy";
        if (actualHeader.equals(expectedHeader)){
            System.out.println("your header passed");
        }else{
            System.out.println("header failed");
        }

        WebElement text=driver.findElement(By.id("details2"));
        System.out.println(text.getText());


        //LOCATOR : NAME
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Potatoe");

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("McMashed");

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("3087635989");

        WebElement userEmail= driver.findElement(By.name("userName"));
        userEmail.sendKeys("potatoe87@gmail.com");

        WebElement address1= driver.findElement(By.name("address1"));
        address1.sendKeys("125 shushum drive");

        WebElement city= driver.findElement(By.name("city"));
        city.sendKeys("Shumville");

        WebElement state= driver.findElement(By.name("state"));
        state.sendKeys("Shumhahaha");

        WebElement postalCode= driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("55555");


        //LOCATOR : CLASS

        WebElement checkboxes=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxes.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()){
            javaBox.click();
        }

        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        System.out.println(seleniumBox.isDisplayed());
        System.out.println(seleniumBox.isSelected());
        seleniumBox.click();
        System.out.println(seleniumBox.isSelected());

        //Locator:TagName
        WebElement javaVersion=driver.findElement(By.tagName("u"));
        String actualVersion=javaVersion.getText().trim();
        String expectedVersion="Use Java Version";
        if (actualVersion.equals(expectedVersion)){
            System.out.println("the version is correct");
        }else{
            System.out.println("the version is incorrect");
        }



    }
}
