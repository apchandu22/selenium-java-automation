package com.chandan.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.chandan.automation.utils.ConfigReader;
import com.chandan.automation.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", ConfigReader.get("browser"));

        if (!"chrome".equalsIgnoreCase(browser)) {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser + ". Currently supported: chrome");
        }

        ChromeOptions options = new ChromeOptions();

        // CI can override local configuration: mvn test -Dheadless=true
        boolean headless = Boolean.parseBoolean(
                System.getProperty("headless", ConfigReader.get("headless")));

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        // Keep implicit wait disabled. Synchronization is handled with explicit waits.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.get(ConfigReader.get("base.url"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
