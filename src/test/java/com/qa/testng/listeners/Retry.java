package com.qa.testng.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private   int  maxTry = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {

        if(!iTestResult.isSuccess()){
            this.maxTry --;
            return this.maxTry >= 0;
        }
        return false;
    }
}
