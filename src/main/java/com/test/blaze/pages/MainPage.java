package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Laptops")
    WebElement laptopButton;

    public void clickLaptop(){
        laptopButton.click();
    }


}
