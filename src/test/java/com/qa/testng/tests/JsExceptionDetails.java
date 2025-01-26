package com.qa.testng.tests;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.log.model.LogEntry;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Listeners(CustomInvocationListener.class)
public class JsExceptionDetails {

    private WebDriver driver;

    @BeforeTest
    public void setUp(ITestContext context){

        driver = new ChromeDriver();
        List<LogEntry> logs= new ArrayList<>();
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        //create a Devtool CDP session
        devTools.createSession();
        devTools.send(Log.enable());
        // Add listener for JavaScript errors
        devTools.addListener(Log.entryAdded(), logEntry -> {
            logs.add(logEntry);
        });
        context.setAttribute("logs", logs);

    }


    @AfterTest
    public void tearDown(ITestContext context){
        Optional.ofNullable(driver).get().quit() ;
    }

    @SneakyThrows
    @Test
    public void testLaunchApp(){

        driver.get("https://carbon.now.sh/");
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("carbon"), "Validate the current url");
    }
}
