package com.cybertek.pom;

import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.KeyDownAction;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewQuestionAnswer  {

    @Test
    public void interviewTest0() throws InterruptedException {
        // import static org.junit.jupiter.api.Assertions.*;
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement loginTextBox  = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
        loginTextBox.sendKeys("Text Field Populated");
        Thread.sleep(2000);
        //show two ways to clear the text field

        //first way-- Clear the text field

        loginTextBox.sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);


        Thread.sleep(2000);
        //repopulating text field...
        loginTextBox.sendKeys("Text Field Populated");
        //sleeping//
        Thread.sleep(2000);


        //second way-- Clear the text field

        loginTextBox.clear();


        Thread.sleep(2000);
        //show how to populate text field from config.properties with "Hello World"

        loginTextBox.sendKeys(ConfigReader.read("testAnswer"));

        //write an assertion that proves the text field has been populated with "Hello World"

        String s1 = "Hello World";
        assertEquals(s1,ConfigReader.read("testAnswer"));











            Thread.sleep(1000);


    }
}
