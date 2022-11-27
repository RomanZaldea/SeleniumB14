package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //we are setting up our automation
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //for windows, put .exe at end
        WebDriver driver=new ChromeDriver();
        //example of polymorphism, we are creating chromedriver from WebDriver
        driver.manage().window().maximize();//this maximizes your screen
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
        String actualTitle=driver.getTitle();
        String expectedTitle="Home Page - Techtorial";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        String actualURL=driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        if (actualURL.equals(expectedUrl)){
            System.out.println("url test passed");
        }else{
            System.out.println("url test not passed");
        }

        System.out.println("*************");

        //first website
        System.out.println("Test for Google");
        driver.get("https://www.google.com/");
        String actualTitle1=driver.getTitle();
        String expectedTitle1="Google";
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        String actualURL1=driver.getCurrentUrl();
        String expectedUrl1="https://www.google.com/";
        if (actualURL1.equals(expectedUrl1)){
            System.out.println("url test passed");
        }else{
            System.out.println("url test not passed");
        }
        System.out.println("*************************");
    //second website
        System.out.println("Test for Odnoklassniki");
        driver.get("https://www.ok.ru");
        String actualTitle2=driver.getTitle();
        String expectedTitle2="OK social network. Communication with friends on OK. Your meeting place with classmates";
        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        String actualURL2=driver.getCurrentUrl();
        String expectedUrl2="https://ok.ru/";
        if (actualURL2.equals(expectedUrl2)){
            System.out.println("url test passed");
        }else{
            System.out.println("url test not passed");
        }

        System.out.println("****************");
        //third website
        System.out.println("Test for Muligambia");
        driver.get("https://muligambia.tumblr.com/");
        String actualTitle3=driver.getTitle();
        String expectedTitle3="Muligambia.MD";
        if (actualTitle3.equals(expectedTitle3)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        String actualURL3=driver.getCurrentUrl();
        String expectedUrl3="https://muligambia.tumblr.com/";
        if (actualURL3.equals(expectedUrl3)){
            System.out.println("url test passed");
        }else{
            System.out.println("url test not passed");
        }
        driver.close();

    }
}
