package TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderAllData {
    @DataProvider(name = "loginFunctionality")
    public Object[][] getData() {
        return new Object[][]{
                {"Ahmet", "Mehmet"},
                {"Mahmet", "Ayse"},
                {"Nurdin", "Osman"},
                {"Hasan", "Zeynep"},
                {"Ferhat", "Sirin"}
        };
    }
}
