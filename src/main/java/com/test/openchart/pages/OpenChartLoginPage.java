package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {
    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

        @FindBy(css = "#input-username")
        WebElement username;

        @FindBy(css = "#input-password")
        WebElement password;

        @FindBy(tagName = "button")
        WebElement loginButton;

        public void login(String username,String password){
            this.username.sendKeys(username);
            this.password.sendKeys(password);
            loginButton.click();
        }
}
