package com.chandan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chandan.automation.base.BasePage;
import com.chandan.automation.data.TestData;

public class ProductPage extends BasePage {

    private final By greyJacket =
            By.cssSelector("a[href*='/products/grey-jacket']");

    private final By productTitle = By.cssSelector("h1");

    private final By addToCartButton =
            By.cssSelector("form[action*='/cart/add'] input[type='submit']");

    private final By cartLink =
            By.xpath("//a[contains(normalize-space(.),'My Cart')]");

    private final By checkoutLink =
            By.xpath("//a[contains(normalize-space(.),'Check Out')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openGreyJacket() {
        WebElement product = waitForClickable(greyJacket);
        scrollIntoView(product);
        product.click();
        waitForVisibility(productTitle);
    }

    public boolean isProductDisplayed() {
        return isDisplayed(productTitle);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public void addProductToCart() {
        WebElement addButton = waitForPresence(addToCartButton);
        scrollIntoView(addButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);

        wait.until(driver -> {
            String cartText = driver.findElement(cartLink).getText().trim();
            return cartText.contains(TestData.CART_ITEM_COUNT_TEXT);
        });
    }

    public void openCart() {
        click(cartLink);
        waitForVisibility(checkoutLink);
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
    }
}
