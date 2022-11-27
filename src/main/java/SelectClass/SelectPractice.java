package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    /*
    Navigate to techtorial website
    Get all the options and print them out
    Validate the default value of box is "United states"
     */
    @Test
    public void techWeb() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/User/Desktop/Techtorialhtml.html");

        WebElement dropDownCountry=driver.findElement(By.xpath("//select[@name='country']"));
        Select dropDownallCountries=new Select(dropDownCountry);

        List<WebElement> allCountries=dropDownallCountries.getOptions();
        System.out.println(allCountries.size());
        for (WebElement country:allCountries){
            System.out.println(country.getText().trim());
        }

        WebElement firstCountry=dropDownallCountries.getFirstSelectedOption();
        Assert.assertEquals(firstCountry.getText().trim(), "UNITED STATES");
/*
Choose your country by any method you want
 */
        dropDownallCountries.selectByVisibleText("MOLDOVA");
    }

    @Test
    public void validateOrderMessage(){
        /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulca"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
9-Print out all the options from Airline
10-Click first class option.
11-Choose the Unified option from airline list
12-Click Continue
13-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 https://demo.guru99.com/test/newtours/reservation.php

 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement trip=driver.findElement(By.xpath("//input[@value='oneway']"));
        trip.click();
        WebElement passengerDrop=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select pssnger=new Select(passengerDrop);//compile time if you do not provide the location of passanger box
        pssnger.selectByVisibleText("4");

        WebElement fromPort=driver.findElement(By.name("fromPort"));//location of the fromPort box
        Select fromPortBox=new Select(fromPort);
        WebElement country=fromPortBox.getFirstSelectedOption();
        Assert.assertEquals(country.getText().trim(),"Acapulco");
        fromPortBox.selectByValue("Paris");

        WebElement fromMonthBox=driver.findElement(By.name("fromMonth"));
        Select fromMonth=new Select(fromMonthBox);
        fromMonth.selectByIndex(7);//Aug

        WebElement fromDayBox=driver.findElement(By.name("fromDay"));
        Select fromDay=new Select(fromDayBox);
        fromDay.selectByVisibleText("15");//date 15

        WebElement toPort=driver.findElement(By.name("toPort"));
        Select toPortBox=new Select(toPort);
        toPortBox.selectByValue("San Francisco");

        WebElement ToMonth=driver.findElement(By.name("toMonth"));
        Select ToMonthBox=new Select(ToMonth);
        ToMonthBox.selectByVisibleText("December");

        WebElement ToDay=driver.findElement(By.name("toDay"));
        Select toDayBox=new Select(ToDay);
        toDayBox.selectByValue("15");

        WebElement airlineBox=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlineBox);
        List<WebElement> allAirlinesOption=airline.getOptions();
        for(WebElement airlne:allAirlinesOption){
            System.out.println(airlne.getText().trim());
        }

        WebElement firsClass=driver.findElement(By.xpath("//input[@value='First']"));
        firsClass.click();

        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton=driver.findElement(By.name("findFlights"));
        continueButton.click();

        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(message.getText().trim(),"After flight finder - No Seats Available");
    }




    @Test
    public void secondWaySelect() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement trip = driver.findElement(By.xpath("//input[@value='oneway']"));
        trip.click();
        WebElement passengerDrop = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerDrop,"4","text");
        WebElement fromPort = driver.findElement(By.name("fromPort"));//location of the fromPort box
        Select fromPortBox = new Select(fromPort);
        WebElement country = fromPortBox.getFirstSelectedOption();
        Assert.assertEquals(country.getText().trim(), "Acapulco");
        BrowserUtils.selectBy(fromPort,"Paris","value");
        WebElement fromMonthBox = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(fromMonthBox,"7","index");

        WebElement fromDayBox = driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(fromDayBox,"15","text");

        WebElement toPort = driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(toPort,"San Francisco","value");

        WebElement ToMonth = driver.findElement(By.name("toMonth"));
        BrowserUtils.selectBy(ToMonth,"December","text");

        WebElement ToDay = driver.findElement(By.name("toDay"));
        BrowserUtils.selectBy(ToDay,"15","value");

        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);
        List<WebElement> allAirlinesOption = airline.getOptions();
        for (WebElement airlne : allAirlinesOption) {
            System.out.println(BrowserUtils.getText(airlne));
        }

        WebElement firsClass = driver.findElement(By.xpath("//input[@value='First']"));
        firsClass.click();
        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(message.getText().trim(), "After flight finder - No Seats Available");
    }
}
