package com.test.etsy.tests;

import com.test.etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase {
    @Parameters({"searchItem","word1","word2","word3"})
    @Test
    public void validateSearchFunctionality(String search, String word1, String word2, String word3) {
        EtsyMainPage etsyMainPage = new EtsyMainPage(driver);
        etsyMainPage.searchItem(search);
        Assert.assertTrue(etsyMainPage.validationOfSearchFunctionality(word1, word2, word3));
    }
}
