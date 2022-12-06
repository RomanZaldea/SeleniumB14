package com.test.sentrifugo.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.XMLFormatter;

public class DepartmentPage {
    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(name = "deptname")
    WebElement departmentName;

    @FindBy(id = "s2id_unitid")
    WebElement businessUnit;

    @FindBy(id = "deptcode")
    WebElement departmentCode;

    @FindBy(id = "s2id_depthead")
    WebElement deptHead;

    @FindBy(xpath = "//span[contains(text(),'Orange Blossom')]")
    WebElement orangeBlossom;

    @FindBy(xpath = "//span[contains(text(),'Thomas E')]")
    WebElement thomasE;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(className = "ml-alert-1-success")
    WebElement message;

    @FindBy(xpath = "//tbody..tr[1]//td")
    List<WebElement> allInformation;



    public void validateMessageOfCreationEmployee(String departmentName, String departmentCode, String expected){
        addButton.click();
        this.departmentName.sendKeys(departmentName);
        businessUnit.click();
        orangeBlossom.click();
        this.departmentCode.sendKeys(departmentCode);
        deptHead.click();
        thomasE.click();
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), expected);

    }

    public void validateInformationFromTable(String departmentName, String departmentCode, String startOn,
                                             String departmentHead, String timeZone, String businessUnit){
        List<String> expectedInformation= Arrays.asList("",departmentName,departmentCode,startOn,departmentHead,timeZone,businessUnit);

        for (int i=1;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInformation.get(i));
            System.out.println(allInformation.get(i).getText().trim());
            System.out.println(expectedInformation.get(i).trim());
        }

    }





}
