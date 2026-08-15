package com.chandan.automation.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.chandan.automation.base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();

        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            String screenshotPath = ScreenshotUtil.capture(
                    baseTest.getDriver(),
                    result.getMethod().getMethodName());

            if (!screenshotPath.isEmpty()) {
                System.out.println("Failure screenshot: " + screenshotPath);
            }
        }
    }
}
