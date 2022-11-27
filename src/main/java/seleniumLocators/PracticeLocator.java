package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeLocator {
      /*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Fill all the boxes
3-Click privacy button
4-Print out the text and close the tab
5-CLick privacy button if it is not selected
4-Click continue button
5-Validate Account is created header

NOTE:To be able get see account is created for you last run make sure you have a different email
just add ahmet1,ahmet2 like that everytime for validation.
}
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Fasula");

        WebElement lastName= driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Mare");

        WebElement email= driver.findElement(By.id("input-email"));
        email.sendKeys("12345@shmek.com");

        WebElement phone= driver.findElement(By.id("input-telephone"));
        phone.sendKeys("3453453435");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("dadada");

        WebElement passwordConfirm=driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("dadada");

        WebElement link= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/a"));
        link.click();

        WebElement text= driver.findElement(By.tagName("h4"));
        System.out.println(text.getText());

        WebElement close= driver.findElement(By.className("close"));
        close.click();

        WebElement checkBox= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        if (checkBox.isDisplayed()&&!checkBox.isSelected()){
            checkBox.click();
        }

        WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueButton.click();

        WebElement confirmation= driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (confirmation.equals("Your Account Has Been Created")){
            System.out.println("Validation successful");
        }else {
            System.out.println("Validation Unsuccessful");
        }





    }
}
