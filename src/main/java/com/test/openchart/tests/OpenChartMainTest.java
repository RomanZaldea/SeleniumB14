package com.test.openchart.tests;

import Utils.ConfigReader;
import com.test.openchart.pages.OpenChartLoginPage;
import com.test.openchart.pages.OpenChartMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenChartMainTest extends OpenChartTestBase{
    @Parameters({"totalOrders","totalSales","totalCustomers","peopleOnline"})

    @Test
    public void validateMainPageData(String totalOrders,String totalSales,String totalCustomers,String peopleOnline){
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login(ConfigReader.readProperty("openchartusername"), ConfigReader.readProperty("openchardpassword"));

        OpenChartMainPage openChartMainPage=new OpenChartMainPage(driver);
        openChartMainPage.validationMainPageData(totalOrders,totalSales,totalCustomers,peopleOnline);
    }
}
