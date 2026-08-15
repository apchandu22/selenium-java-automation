package com.chandan.automation.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cartItems = By.cssSelector("form[action*='/cart'] .cart-item, .cart-item, [class*='cart-item']");
    private final By checkout = By.cssSelector("button[name='checkout'], input[name='checkout'], a[href*='checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean hasItems() {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(cartItems, 0));
    }

    public boolean isCheckoutAvailable() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkout)).isDisplayed();
    }
}
