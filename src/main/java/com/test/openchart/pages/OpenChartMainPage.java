package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class OpenChartMainPage {
    public OpenChartMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-close")
    WebElement xButton;

    @FindBy(xpath = "//h2[@class='float-end']")
    List<WebElement> allData;


    public void validationMainPageData(String totalOrder,String totalSales, String totalCustomers, String peopleOnline){
        xButton.click();
        List<String> expectedValues= Arrays.asList(totalOrder,totalSales,totalCustomers,peopleOnline);
        for (int i=0;i<allData.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allData.get(i)), expectedValues.get(i));
        }
    }
}
