package com.chandan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.chandan.automation.base.BasePage;
import com.chandan.automation.data.TestData;

public class CartPage extends BasePage {

    private final By cartLink =
            By.xpath("//a[contains(normalize-space(.),'My Cart')]");

    private final By checkoutLink =
            By.xpath("//a[contains(normalize-space(.),'Check Out')]");

    private final By greyJacketInCart =
            By.xpath("//*[contains(normalize-space(.), '" + TestData.PRODUCT_NAME + "')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        click(cartLink);
        waitForVisibility(checkoutLink);
    }

    public boolean hasItems() {
        return isDisplayed(greyJacketInCart);
    }

    public boolean isCheckoutAvailable() {
        return isDisplayed(checkoutLink);
    }

    public boolean isGreyJacketDisplayed() {
        return isDisplayed(greyJacketInCart);
    }
}
