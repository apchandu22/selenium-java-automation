package com.chandan.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By greyJacket =
            By.cssSelector("a[href*='/products/grey-jacket']");

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openGreyJacket() {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(greyJacket)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(greyJacket)
        );

        driver.findElement(greyJacket).click();
    }
}