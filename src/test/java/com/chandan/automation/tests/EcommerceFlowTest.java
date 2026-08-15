package com.chandan.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chandan.automation.base.BaseTest;
import com.chandan.automation.data.TestData;
import com.chandan.automation.pages.CartPage;
import com.chandan.automation.pages.ProductPage;

public class EcommerceFlowTest extends BaseTest {

    @Test(description = "Verify the e-commerce storefront loads successfully")
    public void verifyStorefrontLoads() {
        Assert.assertTrue(
                driver.getTitle().contains("Sauce"),
                "Storefront did not load"
        );
    }

    @Test(description = "Verify the configured product can be opened")
    public void verifyProductCanBeOpened() {
        ProductPage productPage = new ProductPage(driver);
        productPage.openGreyJacket();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                TestData.PRODUCT_NAME + " product page was not displayed"
        );
    }

    @Test(description = "Verify a product can be added to the cart")
    public void verifyProductCanBeAddedToCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openGreyJacket();
        productPage.addProductToCart();
        cartPage.openCart();

        Assert.assertTrue(
                cartPage.hasItems(),
                "Cart should contain the selected product"
        );
    }

    @Test(description = "Verify checkout is available from the cart")
    public void verifyCheckoutIsAvailableFromCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openGreyJacket();
        productPage.addProductToCart();
        cartPage.openCart();

        Assert.assertTrue(
                cartPage.isCheckoutAvailable(),
                "Checkout button should be available in cart drawer"
        );
    }
}
