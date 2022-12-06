package com.test.sentrifugo.test;

import com.test.sentrifugo.pages.BackgroundCheckPage;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BackgroundTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");
    }

    @Test
    public void validateBackgroundCheck(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");

        MainPage mainPage=new MainPage(driver);
        mainPage.clickBackground();

        BackgroundCheckPage backgroundCheckPage=new BackgroundCheckPage(driver);
        backgroundCheckPage.validationOfBackgroundCheck(driver, "Harris", "harris@example.com",
                "4785236981", "Trl,\n" +
                        "Orlando,\n" +
                        "Florida,\n" +
                        "United States\n" +
                        "- 48748","Active",
                "No agency", "You cannot send an employee for background check as the screening configurations are not set yet.");



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
