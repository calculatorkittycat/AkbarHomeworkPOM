package com.cybertek.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Webdriver is an interface. Creating a Web driver object from Webdriver interface named obj
 * the method WebDriver has a string that uses the ConfigReader method to call the browser name form config.properties
 * In the if statement it is saying "If there is no WebDriver object, create one based on the name of the browser
 * from the config.properties
 * every class has a default constructor but usually it has the default access modifier
 * by recreating it and making it private it will make the user unable to create objects from this class
 * however you will still be able to call the static method WebDriver
 * there is also a method at the bottom called closeBrowser it is saying
 * "if there is a WebDriver object then WebDriver.quit or quit the webdriver, make the webdriver null"
 */

public class Driver {

    private static WebDriver obj;

    private Driver(){
    }

    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser");

        if(obj == null){

            switch (browserName){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;

                default:
                    obj=null;
                    System.out.println("Unknown Browser, check config.properties");
            }
            return obj;


        } else {
            System.out.println("You already have a webDriver");
            return obj;
        }

    }

    public static void closeBrowser() {
        if (obj != null){
            obj.quit();
            obj = null;
        }
    }


}
