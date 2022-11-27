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

public class SelectBasics {

    //Select class it is all about drop downs
    //Drop Down must have Select Tag name


    @Test
    public void practiceSelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));
        dropDown.click();

        WebElement dropDownBox= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDWN=new Select(dropDownBox);

        List<WebElement> allTheOptions=dropDWN.getOptions();
        for (WebElement option:allTheOptions){
            System.out.println(option.getText().trim());
        }

        WebElement firstSelected=dropDWN.getFirstSelectedOption();
        Assert.assertEquals(firstSelected.getText().trim(), "Please select an option");

        dropDWN.selectByVisibleText("Option 2");

        dropDWN.selectByValue("1");

        dropDWN.selectByIndex(2);
    }

    @Test
    public void selectMultiMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/User/Desktop/Techtorialhtml.html");

        WebElement countries= driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(countries,"3", "value");
        BrowserUtils.selectBy(countries,"3", "index");

        Select country=new Select(countries);
        country.selectByValue("3");

        country.deselectAll();

    }
}
