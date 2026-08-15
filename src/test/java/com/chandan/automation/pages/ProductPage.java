package com.chandan.automation.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By productTitle = By.cssSelector("h1, .product__title, [class*='product-title']");
    private final By addToCart = By.cssSelector("button[name='add'], button[type='submit']");
    private final By cartLink = By.cssSelector("a[href*='/cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public CartPage addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        return new CartPage(driver);
    }
}
