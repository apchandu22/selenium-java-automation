package com.chandan.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chandan.automation.base.BaseTest;
import com.chandan.automation.data.TestData;
import com.chandan.automation.pages.CartPage;
import com.chandan.automation.pages.ProductPage;

public class EcommerceFlowTest extends BaseTest {

    @Test(priority = 1, description = "Verify the e-commerce storefront loads successfully")
    public void verifyStorefrontLoads() {
        Assert.assertTrue(
                driver.getTitle().toLowerCase().contains("sauce"),
                "Storefront did not load with the expected title"
        );
    }

    @Test(priority = 2, description = "Verify the configured product can be opened")
    public void verifyProductCanBeOpened() {
        ProductPage productPage = new ProductPage(driver);
        productPage.openGreyJacket();

        Assert.assertTrue(
                productPage.isProductDisplayed(),
                TestData.PRODUCT_NAME + " product page was not displayed"
        );

        Assert.assertEquals(
                productPage.getProductTitle(),
                TestData.PRODUCT_NAME,
                "Product title does not match the expected product"
        );
    }

    @Test(priority = 3, description = "Verify product price is displayed")
    public void verifyProductPriceIsDisplayed() {
        ProductPage productPage = new ProductPage(driver);
        productPage.openGreyJacket();

        String price = productPage.getProductPrice();

        Assert.assertFalse(price.isBlank(), "Product price should not be blank");
        Assert.assertTrue(price.matches(".*\\d.*"), "Product price should contain a numeric value");
    }

    @Test(priority = 4, description = "Verify a product can be added to the cart")
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

        Assert.assertTrue(
                cartPage.isGreyJacketDisplayed(),
                TestData.PRODUCT_NAME + " should be displayed in the cart"
        );
    }

    @Test(priority = 5, description = "Verify cart count reflects the selected product")
    public void verifyCartCount() {
        ProductPage productPage = new ProductPage(driver);

        productPage.openGreyJacket();
        productPage.addProductToCart();

        Assert.assertTrue(
                productPage.getCartText().contains(TestData.CART_ITEM_COUNT_TEXT),
                "Cart count should reflect one selected product"
        );
    }

    @Test(priority = 6, description = "Verify checkout is available from the cart")
    public void verifyCheckoutIsAvailableFromCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openGreyJacket();
        productPage.addProductToCart();
        cartPage.openCart();

        Assert.assertTrue(
                cartPage.isCheckoutAvailable(),
                "Checkout button should be available in cart"
        );
    }
}
