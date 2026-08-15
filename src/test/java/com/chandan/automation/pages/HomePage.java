package com.chandan.automation.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By productLinks = By.cssSelector("a[href*='/products/']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public ProductPage openFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productLinks)).click();
        return new ProductPage(driver);
    }
}
