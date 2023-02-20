package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "cartur")
    WebElement cartButton;
    @FindBy(xpath = "//tr//td")
    List<WebElement> allInformation;
    @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
    WebElement placeOrderButton;
    public void validateCartItem(String title, String price) throws InterruptedException {
        cartButton.click();
        List<String> expectedInfo = Arrays.asList("",title, price,""); // we can use "" to make it equal to loop
        for (int i = 1; i < allInformation.size()-1 ; i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInfo.get(i));
        }
        placeOrderButton.click();
    }
}

