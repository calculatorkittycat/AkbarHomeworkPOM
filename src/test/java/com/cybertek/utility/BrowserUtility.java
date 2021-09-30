package com.cybertek.utility;

import org.openqa.selenium.By; //By
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; //WebDriverWait
 //WebDriverWait Class

/**
 * this class has two methods
 * the first is a custom sleep method that handles the interuptedException with try catch blocks
 * Thread.sleep will always throw an exception
 * it also accepts int seconds and multiplies by 1000 to deal with the issue of having to declare milliseconds
 *
 * the second method checks the visibility of an element with the WebDriverWait class and the By class
 * the By class does the locating of the element and WebDriverWait class does the waiting until the element is found
 * checkVisibility of element will wait for just one specified element instead of implicitly waiting for
 * all elements if you extend testBase.
 */

public class BrowserUtility {

    public static void waitFor (int seconds){


        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkVisibilityOfElement(By locator, int timeToWait){

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeToWait);

       try{
           wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
           result = true;
       }catch ( TimeoutException e){
           e.printStackTrace();//optional
           System.out.println("Error...");
       }
       return result;


    }

}
