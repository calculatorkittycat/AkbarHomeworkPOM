package com.cybertek.pom;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterviewQuestion  {

    @Test
    public void interviewTest0() throws InterruptedException {
        // import the below line
        // import static org.junit.jupiter.api.Assertions.*;
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement loginTextBox  = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
        loginTextBox.sendKeys("Text Field Populated");
        Thread.sleep(2000);



        /**
         * show two ways to clear the text field
         * first way--
         */




        Thread.sleep(2000);
        //repopulating text field...
        loginTextBox.sendKeys("Text Field Populated");
        //sleeping...
        Thread.sleep(2000);


        /**
         * second way--
         */




        Thread.sleep(2000);
        /**
         * show how to populate text field from config.properties with "World Hello"
         */




         /**
         * write an assertion that proves the text field has been populated with "World Hello"
         */




        Thread.sleep(1000);


    }
}

