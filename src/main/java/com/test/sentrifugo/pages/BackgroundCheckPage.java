package com.test.sentrifugo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BackgroundCheckPage {

    public BackgroundCheckPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='sprite addrecord']")
    WebElement addButton;

    @FindBy(id = "s2id_employee")
    WebElement selectEmployee;

    @FindBy(xpath = "//span[contains(text(),'Harris')]")
    WebElement harris;

    @FindBy(xpath = "//div[@id='personalDetailsDiv']//span")
    List<WebElement> allInformation;

    @FindBy(id = "checktype-2")
    WebElement creditBox;

    @FindBy(xpath = "//div[.='No agency']")
    WebElement noAgency;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'You cannot send')]")
    WebElement topMessage;

    public void validationOfBackgroundCheck(WebDriver driver,String name, String emailId, String contactNumber, String address, String status,
                                            String expectedAgent,String expectedMessage){
        addButton.click();
        selectEmployee.click();
        harris.click();
        List<String>expectedValues= Arrays.asList(name,emailId,contactNumber,address,status);
        for (int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedValues.get(i));
        }
        creditBox.click();
        Assert.assertEquals(BrowserUtils.getText(noAgency).trim(), expectedAgent);
        BrowserUtils.scrollIntoView(driver,saveButton);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(topMessage), expectedMessage);
    }

}
