package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //input[@id='global-enhancements-search-query']")
    WebElement searchBar;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchItem(String itemName) {
        searchBar.sendKeys(itemName, Keys.ENTER);
    }

    //first option
    public boolean validationOfSearchFunctionality(String word1, String word2, String word3) {
        for (WebElement header : allHeaders) {
            String text = BrowserUtils.getText(header).toLowerCase();
            if (!(text.contains(word1) || text.contains(word2) || text.contains(word3))) {
                return false;
            }
        }
        return true;
    }
//second option
    public void validationOfSearchFunctionality2(String word1, String word2, String word3) {
        for (WebElement header : allHeaders) {
            String text = BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(text.contains(word1) || text.contains(word2) || text.contains(word3));

        }
    }
}