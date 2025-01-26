package com.qa.testng.tests;

import org.openqa.selenium.devtools.v85.log.model.LogEntry;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.lang.annotation.Annotation;
import java.util.List;

public class CustomInvocationListener implements IInvokedMethodListener {
     @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {}

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        Annotation[] ann= method.getTestMethod().getConstructorOrMethod().getMethod().getDeclaredAnnotations();
        // execute this method for only for annotation @Test
        if(ann[0].annotationType().getSimpleName().equals("Test")) {
            // get the logs instance from ITestContext
            List<LogEntry> logs = (List<LogEntry>) testResult
                    .getTestContext().getAttribute("logs");

            logs.forEach(logEntry -> {
                if(logEntry.getSource().toString().equals("javascript"))
                        Reporter.log(logEntry.getText());
            });

            //filter the JS errors alone
            long jsCount=  logs.stream().filter(e->e.getSource().toString().equals("javascript")).count();

            // Example: Fail the test if a specific condition is met
            if (jsCount > 0) {
                testResult.setStatus(ITestResult.FAILURE);
                testResult.setThrowable(new RuntimeException("JS exception thrown count:  "+jsCount));
            }
        }

    }
}