package com.chandan.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.chandan.automation.base.BaseTest;
import com.chandan.automation.pages.CartPage;
import com.chandan.automation.pages.HomePage;
import com.chandan.automation.pages.ProductPage;

public class EcommerceFlowTest extends BaseTest {

    @Test
    public void verifyStorefrontLoads() {
        HomePage home = new HomePage(driver);
        Assert.assertFalse(home.getTitle().isBlank(), "Storefront title should not be blank");
    }

    @Test
    public void verifyProductCanBeOpened() {
        HomePage home = new HomePage(driver);
        ProductPage product = home.openFirstProduct();
        Assert.assertFalse(product.getProductTitle().isBlank(), "Product title should be displayed");
    }

    @Test
    public void verifyProductCanBeAddedToCart() {
        HomePage home = new HomePage(driver);
        ProductPage product = home.openFirstProduct();
        CartPage cart = product.addProductToCart();
        Assert.assertTrue(cart.hasItems(), "Cart should contain the selected product");
    }

    @Test
    public void verifyCheckoutIsAvailableFromCart() {
        HomePage home = new HomePage(driver);
        ProductPage product = home.openFirstProduct();
        CartPage cart = product.addProductToCart();
        Assert.assertTrue(cart.isCheckoutAvailable(), "Checkout control should be available");
    }
}
