package com.chandan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    /*
     * My Cart link in the header.
     */
    private final By cartLink =
            By.xpath("//a[contains(normalize-space(.),'My Cart')]");

    /*
     * Checkout is a LINK on this site.
     * Do NOT use input[type='submit'].
     */
    private final By checkoutLink =
            By.xpath("//a[contains(normalize-space(.),'Check Out')]");

    /*
     * Product name.
     */
    private final By greyJacketInCart =
            By.xpath(
                "//*[contains(normalize-space(.),'Grey jacket')]"
            );

    /*
     * Cart count.
     */
    private final By cartWithItem =
            By.xpath(
                "//a[contains(normalize-space(.),'My Cart (1)')]"
            );

    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public void openCart() {

        WebElement cart = wait.until(
                ExpectedConditions.presenceOfElementLocated(cartLink)
        );

        cart.click();

        /*
         * Wait for checkout to appear.
         */
        wait.until(
                ExpectedConditions.presenceOfElementLocated(checkoutLink)
        );
    }

    public boolean hasItems() {

        /*
         * First verify cart count.
         */
        try {

            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            cartWithItem
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isCheckoutAvailable() {

        /*
         * Make sure the cart is open first.
         */
        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            checkoutLink
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isGreyJacketDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            greyJacketInCart
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}