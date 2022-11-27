package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Project2 {
    /*
        Test Scenario
        Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx"
        Validate the title is equals to "Web Orders Login" Input username "Tester"
        Input password "test"
        Click login button
        Validate the title is equals to "Web Orders"
        Validate header is equals to "List of All Orders"
             */
    @Test
    public void testCase1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_login_button']"));
        loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");
        WebElement header = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(header.getText(), "List of All Orders");
    }

    /* Test Scenario
     Navigate to "http://secure.smartbearsoftware.com/samples/Tes tComplete11/WebOrders/Login.aspx?"
     Input username "Tester"
     Input password "Test"
     Click login button
     Click "View all products" button
     Validate "View all products" is selected
     Validate header is equals to "List of Products"
     Validate the url has "Products" keyword*/
    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement allproducts = driver.findElement(By.linkText("View all products"));
        allproducts.click();
        Thread.sleep(2000);
        //Assert.assertTrue(allproducts.isSelected());
        WebElement listProducts = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(listProducts.getText(), "List of Products");
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
    }

    /*
    Test Scenario
        Navigate to "http://secure.smartbearsoftware.com/samples/Te stComplete11/WebOrders/Login.aspx?"
        Input username "Tester"
        Input password "Test"
        Click login button
        Find the links for
        View all orders
        View all products
        Orders
        Validate their href values are equals to :
        "Default.aspx"
        "Products.aspx"
        "Process.aspx"
     */
    @Test
    public void testCase3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("Products.aspx"));
        WebElement orders = driver.findElement(By.linkText("Order"));
        orders.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("Process.aspx"));
    }

    /*
            Test Scenario
            Navigate to "http://secure.smartbearsoftware.com/samples/TestComplete11 /WebOrders/Login.aspx?"
            Input username "Tester"
            Input password "Test"
            Click login button
            Click "Order" button
            Select product "Screen Saver"
            Input quantity 5
            Input Customer name "Techtorial Academy"
            Input Street "2200 E devon"
            Input City "Des Plaines"
            Input State "Illinois"
            Input Zip "60018"
            Select MasterCard
            Input card number "444993876233"
            Input expiration date "03/21"
            Click Process button
     */
    @Test
    public void testCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        Thread.sleep(1000);
        WebElement productOption = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select dropdown = new Select(productOption);
        dropdown.selectByVisibleText("ScreenSaver");
        Thread.sleep(1000);
        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        Thread.sleep(1000);
        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        name.sendKeys("Techtorial Academy");
        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        Thread.sleep(1000);
        WebElement zip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        Thread.sleep(1000);
        WebElement masterCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
        if (masterCard.isDisplayed() && !masterCard.isSelected()) {
            masterCard.click();
        }
        Thread.sleep(1000);
        WebElement cardBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardBox.sendKeys("444993876233");
        WebElement dateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        dateBox.sendKeys("03/21");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//strong[contains(text(), 'New order has been successfully added.')]"));
        Assert.assertEquals(text.getText(), "New order has been successfully added.");
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        WebElement newOrder = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]"));
        System.out.println(newOrder.getText().trim());
        String element = newOrder.getText().trim();
        System.out.println(element);
        String[] expectedElements = {"Techtorial Academy", "ScreenSaver", "5", "11/22/2022", "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/21"};
        String[] actualElements = new String[expectedElements.length];
        for (int i = 0; i < expectedElements.length; i++) {
            if (element.contains(expectedElements[i])) {
                actualElements[i] = expectedElements[i];
            }
        }
        Assert.assertEquals(expectedElements, actualElements);
        Thread.sleep(2000);
        driver.quit();
    }

}