package com.test.sentrifugo.test;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

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
    public void validatePositiveLogin(){
        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");*/

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");

        Assert.assertEquals(loginPage.title(driver),"Sentrifugo - Open Source HRMS");
        Assert.assertEquals(driver.getTitle().trim(), "Sentrifugo - Open Source HRMS");
    }

    @Test
    public void velidateNegativeLogin(){
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");*/

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("", "");

        Assert.assertEquals(loginPage.userNameErrorMessage(), "Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Please enter password.");

        Assert.assertEquals(loginPage.colorOfUserNameErrorMessage(), "rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.colorOfPasswordErrorMessage(), "rgba(255, 0, 0, 1)");



    }
}
