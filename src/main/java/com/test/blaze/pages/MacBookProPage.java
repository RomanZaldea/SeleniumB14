package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(xpath = "//h3")
    WebElement price;

    @FindBy(id = "myTabContent")
    WebElement productDescription;


    public void validateProductInfo(String expectedHeader, String expectedPrice, String expectedProductDescription){
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(productDescription), expectedProductDescription);
    }
}
