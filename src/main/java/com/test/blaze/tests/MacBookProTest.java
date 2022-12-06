package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import org.testng.annotations.Test;

public class MacBookProTest extends TestBaseBlaze{

    @Test
    public void validateMacBookProductInfo() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptop();

        LaptopPage laptopPage=new LaptopPage(driver);
        Thread.sleep(4000);
        laptopPage.chooseLaptop("MacBook Pro");

        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.validateProductInfo("MacBook Pro", "$1100 *includes tax", "Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
    }
}
