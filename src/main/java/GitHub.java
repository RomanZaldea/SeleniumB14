import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GitHub {
    @Test
    public void unSait() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        WebElement logInButton= driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        logInButton.click();

        WebElement catalogButton = driver.findElement(By.xpath("(//a[@href='#'])[4]"));
        catalogButton.click();

        WebElement productsButton= driver.findElement(By.xpath("(//a[@href='/Admin/Product/List'])"));
        productsButton.click();

        WebElement productNameBox= driver.findElement(By.id("SearchProductName"));
        productNameBox.sendKeys("samsung");

        WebElement categorySelect= driver.findElement(By.id("SearchCategoryId"));
        BrowserUtils.selectBy(categorySelect, "Computers >> Notebooks", "text");

        WebElement manufacturerSelect= driver.findElement(By.id("SearchManufacturerId"));
        BrowserUtils.selectBy(manufacturerSelect, "All", "text");

        WebElement vendorSelect= driver.findElement(By.id("SearchVendorId"));
        BrowserUtils.selectBy(vendorSelect, "All", "text");

        WebElement warehouseSelect= driver.findElement(By.id("SearchWarehouseId"));
        BrowserUtils.selectBy(warehouseSelect, "All", "text");

        WebElement produtcTypeSelect= driver.findElement(By.id("SearchProductTypeId"));
        BrowserUtils.selectBy(produtcTypeSelect, "Simple", "text");

        WebElement publishedSelect= driver.findElement(By.id("SearchPublishedId"));
        BrowserUtils.selectBy(publishedSelect, "All", "text");

        WebElement searchButton= driver.findElement(By.id("search-products"));
        searchButton.click();

        driver.navigate().back();

        WebElement catalogButton1 = driver.findElement(By.xpath("(//a[@href='#'])[4]"));
        catalogButton1.click();

        WebElement attributesButton= driver.findElement(By.xpath("(//a[@href='#'])[5]"));
        attributesButton.click();

        WebElement productAttributesButton= driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[6]/ul/li[1]/a/p"));

        productAttributesButton.click();

        List<WebElement> aldeChecks=driver.findElements(By.xpath("//input[@name='checkbox_productattributes']"));

        for (WebElement checks:aldeChecks){
            if (!checks.isSelected()){
                Thread.sleep(1000);
                checks.click();
            }
        }

        WebElement edit1= driver.findElement(By.xpath("(//a[@class='btn btn-default'])[1]"));
        edit1.click();

        WebElement textSize= driver.findElement(By.xpath("(//div[@class='tox-tbtn__select-chevron'])[3]"));
        textSize.click();

        WebElement treizecisisase=driver.findElement(By.xpath("(//div[@class='tox-collection__item-label'])[7]"));
        treizecisisase.click();

        //WebElement colorDropDown= driver.findElement(By.xpath("//*[@id=\"product-attribute-info\"]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div[7]/div[2]/span[2]/svg"));
        //colorDropDown.click();

        //WebElement colorPicker= driver.findElement(By.xpath("//div[@title='Light Red']"));
        //colorPicker.click();

        driver.switchTo().frame("Description_ifr");

        WebElement textBox= driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("I AM BARAN");






    }
}
