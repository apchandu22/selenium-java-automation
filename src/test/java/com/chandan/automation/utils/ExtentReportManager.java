package com.chandan.automation.utils;

import java.nio.file.Files;
import java.nio.file.Path;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {
    }

    public static synchronized ExtentReports getReport() {
        if (extent == null) {
            try {
                Path reportDirectory = Path.of("target", "extent-report");
                Files.createDirectories(reportDirectory);

                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
                        reportDirectory.resolve("ExtentReport.html").toString());
                sparkReporter.config().setDocumentTitle("Selenium Automation Test Report");
                sparkReporter.config().setReportName("E-commerce UI Automation Report");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("Framework", "Selenium + TestNG + POM");
                extent.setSystemInfo("Java", System.getProperty("java.version"));
                extent.setSystemInfo("Browser", "Chrome");
            } catch (Exception e) {
                throw new RuntimeException("Unable to initialize ExtentReports", e);
            }
        }
        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
