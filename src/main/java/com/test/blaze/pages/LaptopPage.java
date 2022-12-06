package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement>allLaptops;

    @Test
    public void chooseLaptop( String brand){
        for (WebElement laptop:allLaptops){
            if (BrowserUtils.getText(laptop).equals(brand)){
                laptop.click();
                break;
            }
        }
    }
}
