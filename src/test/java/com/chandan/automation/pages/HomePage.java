package com.chandan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.chandan.automation.base.BasePage;

public class HomePage extends BasePage {

    private final By greyJacket =
            By.cssSelector("a[href*='/products/grey-jacket']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openGreyJacket() {
        click(greyJacket);
    }
}
