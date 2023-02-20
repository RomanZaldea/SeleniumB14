package com.test.sentrifugo.test;

import TestNG.DataProviderAllData;
import Utils.ConfigReader;
import Utils.DriverHelper;
import com.test.sentrifugo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test(priority = 2)
    public void validatePositiveLogin(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("sentrifugousername"), ConfigReader.readProperty("sentrifugopassword"));

        Assert.assertEquals(loginPage.title(driver),"Sentrifugo - Open Source HRMS");
        Assert.assertEquals(driver.getTitle().trim(), "Sentrifugo - Open Source HRMS");
    }

    @Test(priority = 1)
    public void velidateNegativeLogin(){
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://demo.sentrifugo.com/index.php/");*/


        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("", "");

        Assert.assertEquals(loginPage.userNameErrorMessage(), "Please enter username or emaill.");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Please enter password.");

        Assert.assertEquals(loginPage.colorOfUserNameErrorMessage(), "rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.colorOfPasswordErrorMessage(), "rgba(255, 0, 0, 1)");
    }

    @Test(dataProvider = "loginFunctionality",dataProviderClass = DataProviderAllData.class)
    public void validateAllSuccessfullLogin(String username,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.title(driver), "Sentrifugo - Open Source HRMS");
    }
}
