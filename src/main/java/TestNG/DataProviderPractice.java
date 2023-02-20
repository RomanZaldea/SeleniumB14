package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderPractice {
    /*@DataProvider(name = "loginFunctionality")
    public Object[][] getData() {
        return new Object[][]{
                {"Ahmet", "Mehmet"},
                {"Mahmet", "Ayse"},
                {"Nurdin", "Osman"},
                {"Hasan", "Zeynep"},
                {"Ferhat", "Sirin"}
        };
    }*/

    @Test(dataProvider = "loginFunctionality", dataProviderClass = DataProviderAllData.class)
    public void positiveLogin(String userName, String password) {

        System.out.println("login" + userName + password);
    }

   /* @Test
    public void positiveLogin1(){
        String userName="Mahmut";
        String password="Nurdin";

        System.out.println("login1"+ userName+password);
    }

    @Test
    public void positiveLogin2(){
        String userName="Ahmet";
        String password="Mehmet";

        System.out.println("login2"+ userName+password);
    }

    @Test
    public void positiveLogin3(){
        String userName="Zeynep";
        String password="Ayse";

        System.out.println("login3"+ userName+password);
    }

    @Test
    public void positiveLogin4(){
        String userName="Osman";
        String password="Fatma";

        System.out.println("login4"+ userName+password);
    }

    @Test
    public void positiveLogin5(){
        String userName="Abdurrahman";
        String password="Baran";

        System.out.println("login5"+ userName+password);
    }*/
}
