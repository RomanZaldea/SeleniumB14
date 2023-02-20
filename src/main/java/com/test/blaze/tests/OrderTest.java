package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTest extends TestBaseBlaze {
    @Parameters({"laptopBrand", "expectedCardMessage", "price", "name", "country", "city", "creditCard", "month", "year", "expectedOrderMessage"})

    @Test
    public void validateOrderPage(String laptopBrand, String expectedCardMessage, String price, String name, String country
            , String city, String creditCard, String month, String year, String expectedOrderMessage) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(laptopBrand);
        Thread.sleep(1000);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        //macBookProPage.clickAddToCardandValidate(driver,expectedCardMessage);//Product Added
        CartPage cartPage = new CartPage(driver);
        cartPage.validateCartItem(laptopBrand, price);//MacPro Book, 1100
        OrderPage orderPage = new OrderPage(driver);
        orderPage.validateOrderMessage(name, country, city, creditCard, month, year, expectedOrderMessage);
    }
}