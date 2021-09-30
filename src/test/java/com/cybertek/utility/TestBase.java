package com.cybertek.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 * if you extend this abstract class you will inherit these methods
 * Before each test it will call the getDriver(); method from Driver.java
 * After each test it will call the closeBrowser(); method
 * if you extend this abstract class you don't need to set up a webDriver
 * all you need to do is say driver.get
 * notice there is a difference between Driver.getDriver.get and driver.get
 * you can only use driver.get if you extend TestBase
 * you can use Driver.getDriver.get anywhere no extending needed
 *
 * Implicit wait will wait until any element is not found up to 10 seconds then fail
 **/

public abstract class TestBase {

    public WebDriver driver;

    @BeforeEach
    public void setUpWebDriver(){

        driver = Driver.getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeBrowser(){
        Driver.closeBrowser();
    }

}
