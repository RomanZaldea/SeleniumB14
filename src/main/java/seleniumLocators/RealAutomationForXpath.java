package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RealAutomationForXpath {
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully John Doe, ThisIsNotAPassword
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
 */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement makeAppointment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();
        WebElement username=driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton=driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement applyBox=driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if(applyBox.isDisplayed()&&!applyBox.isSelected()){
            applyBox.click();
        }
        System.out.println(applyBox.isSelected());//true
        WebElement medicaid=driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaid.click();
        WebElement date=driver.findElement(By.xpath("//input[@class='form-control']"));
        date.sendKeys("02/11/2022");
        WebElement comment=driver.findElement(By.xpath("//textarea[@name='comment']"));
        comment.sendKeys("Hello This is my first appointment");
        WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        WebElement confirmation=driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        System.out.println(confirmation.getText().trim());
        WebElement facilityValidation=driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println(facilityValidation.getText().trim());
    }


}
