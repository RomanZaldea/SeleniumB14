package com.test.openchart.tests;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class OpenChartTestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("opencharturl"));
    }

}
