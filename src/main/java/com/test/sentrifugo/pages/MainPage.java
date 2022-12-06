package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Departments']")
    WebElement departmentButton;

    @FindBy(xpath = "//b[.='Background Check']")
    WebElement backgroundCheckButton;

    public void clickDepartment(){
        departmentButton.click();
    }

    public void clickBackground(){
        backgroundCheckButton.click();
    }


}
