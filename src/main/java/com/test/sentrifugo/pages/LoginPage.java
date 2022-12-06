package com.test.sentrifugo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //We will store our webelements and methods here from LoginPage
    //Whenever we create any page we must initialize our elements with constructor

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy(id = "usernameerror")
    WebElement usernameErrorMessage;
    @FindBy(id = "pwderror")
    WebElement passwordErrorMessage;
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String title(WebDriver driver){
        return driver.getTitle().trim();
    }

    public String userNameErrorMessage(){
        return BrowserUtils.getText(usernameErrorMessage);
    }

    public String passwordErrorMessage(){
        return BrowserUtils.getText(passwordErrorMessage);
    }

    public String colorOfUserNameErrorMessage(){
        return usernameErrorMessage.getCssValue("color").trim();
    }

    public String colorOfPasswordErrorMessage(){
        return passwordErrorMessage.getCssValue("color").trim();
    }

}
