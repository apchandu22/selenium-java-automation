package com.chandan.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtil() {
    }

    public static String capture(WebDriver driver, String testName) {
        if (driver == null) {
            return "";
        }

        try {
            Path screenshotDirectory = Path.of("target", "screenshots");
            Files.createDirectories(screenshotDirectory);

            String safeTestName = testName.replaceAll("[^a-zA-Z0-9._-]", "_");
            String fileName = safeTestName + "_"
                    + LocalDateTime.now().format(FORMATTER) + ".png";

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = screenshotDirectory.resolve(fileName);

            Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            return destination.toString();

        } catch (IOException | RuntimeException e) {
            System.err.println("Unable to capture screenshot: " + e.getMessage());
            return "";
        }
    }
}
