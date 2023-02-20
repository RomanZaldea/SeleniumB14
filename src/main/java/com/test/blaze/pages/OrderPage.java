package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement username;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement lastMessage;

    public void validateOrderMessage(String username,String country,String city,
                                     String card,String month,String year,String expectedMessage){
        this.username.sendKeys(username);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(lastMessage),expectedMessage);
    }
}
