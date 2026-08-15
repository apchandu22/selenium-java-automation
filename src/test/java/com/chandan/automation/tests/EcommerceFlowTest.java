package com.chandan.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chandan.automation.base.BaseTest;
import com.chandan.automation.pages.CartPage;
import com.chandan.automation.pages.ProductPage;

public class EcommerceFlowTest extends BaseTest {

    @Test
    public void verifyStorefrontLoads() {

        Assert.assertTrue(
                driver.getTitle().contains("Sauce"),
                "Storefront did not load"
        );
    }

    @Test
    public void verifyProductCanBeOpened() {

        ProductPage productPage =
                new ProductPage(driver);

        productPage.openGreyJacket();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                "Grey jacket product page was not displayed"
        );
    }

    @Test
    public void verifyProductCanBeAddedToCart() {

        ProductPage productPage =
                new ProductPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        /*
         * Step 1: Open product
         */
        productPage.openGreyJacket();

        /*
         * Step 2: Add product
         */
        productPage.addProductToCart();

        /*
         * Step 3: Open cart drawer
         */
        cartPage.openCart();

        /*
         * Step 4: Verify cart contains item
         */
        Assert.assertTrue(
                cartPage.hasItems(),
                "Cart should contain the selected product"
        );
    }

    @Test
    public void verifyCheckoutIsAvailableFromCart() {

        ProductPage productPage =
                new ProductPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        /*
         * Step 1: Open product
         */
        productPage.openGreyJacket();

        /*
         * Step 2: Add product
         */
        productPage.addProductToCart();

        /*
         * Step 3: Open My Cart drawer
         */
        cartPage.openCart();

        /*
         * Step 4: Verify Checkout
         */
        Assert.assertTrue(
                cartPage.isCheckoutAvailable(),
                "Checkout button should be available in cart drawer"
        );
    }
}