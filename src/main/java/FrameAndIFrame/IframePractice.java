package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframePractice {
    @Test
    public void iframePractice(){
        /*
1-Navigate to the https://the-internet.herokuapp.com/frames
2-Click iframe
3-print out the header "An iFrame containing the TinyMCE WYSIWYG Editor"
4-clear the message part and send "I love Selenium"
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");

        WebElement iframe= driver.findElement(By.linkText("iFrame"));
        iframe.click();

        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

        driver.switchTo().frame("mce_0_ifr");
        WebElement box= driver.findElement(By.xpath("//body[@id='tinymce']"));
        box.clear();
        box.sendKeys("shmekkkk");

        driver.switchTo().parentFrame();
        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();







    }
}
