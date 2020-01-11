package com.masteringselenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class MyListenerClass implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("i aminside the method");
        System.out.println(result.getMethod()+"\n");
        System.out.println(result.getTestClass());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("result.getTestName()"+ result.getTestName()+"\n");
    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
