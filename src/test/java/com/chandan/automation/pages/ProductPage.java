package com.chandan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By greyJacket =
            By.cssSelector("a[href*='/products/grey-jacket']");

    private final By productTitle =
            By.cssSelector("h1");

    /*
     * Shopify product form.
     * We deliberately avoid:
     * input[type='submit'][value*='ADD TO CART'], button
     * because the second part can match unrelated buttons.
     */
    private final By addToCartButton =
            By.cssSelector("form[action*='/cart/add'] input[type='submit']");

    /*
     * My Cart link.
     */
    private final By cartLink =
            By.xpath("//a[contains(normalize-space(.),'My Cart')]");

    public ProductPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public void openGreyJacket() {

        WebElement product = wait.until(
                ExpectedConditions.presenceOfElementLocated(greyJacket)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                product
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(product)
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(productTitle)
        );
    }

    public boolean isProductDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productTitle)
        ).isDisplayed();
    }

    public void addProductToCart() {

        WebElement addButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(addToCartButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                addButton
        );

        /*
         * The Sauce Demo page can have a loading overlay.
         * JavaScript click avoids Selenium being blocked by that overlay.
         */
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                addButton
        );

        /*
         * Wait until My Cart shows an item.
         */
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        cartLink,
                        "My Cart (1)"
                )
        );
    }

    public void openCart() {

        WebElement cart = wait.until(
                ExpectedConditions.presenceOfElementLocated(cartLink)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                cart
        );

        /*
         * Give the cart drawer AJAX request time to render.
         */
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(normalize-space(.),'Check Out')]")
                )
        );
    }
}