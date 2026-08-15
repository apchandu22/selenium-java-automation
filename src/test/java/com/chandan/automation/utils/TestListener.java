package com.chandan.automation.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.chandan.automation.base.BaseTest;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentTest extentTest = ExtentReportManager.getReport().createTest(
                testName,
                description == null ? "" : description);
        TEST.set(extentTest);
        extentTest.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = TEST.get();
        if (extentTest != null) {
            extentTest.pass("Test passed successfully");
        }
        TEST.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = TEST.get();
        if (extentTest != null) {
            extentTest.fail(result.getThrowable());
        }

        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            String screenshotPath = ScreenshotUtil.capture(
                    baseTest.getDriver(), result.getMethod().getMethodName());

            if (extentTest != null && !screenshotPath.isEmpty()) {
                try {
                    extentTest.addScreenCaptureFromPath(screenshotPath);
                } catch (Exception e) {
                    extentTest.warning("Screenshot was created but could not be attached: "
                            + e.getMessage());
                }
            }
        }
        TEST.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest extentTest = TEST.get();
        if (extentTest != null) {
            extentTest.skip("Test skipped").skip(result.getThrowable());
        }
        TEST.remove();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }
}
