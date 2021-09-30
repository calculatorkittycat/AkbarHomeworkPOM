package com.cybertek.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * this is the way we did Driver.getDriver before we had the properties file,
 * and before we wanted to limit the creation of multiple driver objects
 * multiple driver objects are pointless and only serve to consume memory
 * Because getDriver is a static method to use it you just say
 * WebDriverFactory.getDriver(browserName);
 * this swtich statement will take whatever you pass in browserName and if there
 * is a match it will create that WebDriver, like chromedriver, firefoxdriver or edgedriver
 * if there is not a match it will go to the default statement print unknown browser name
 * and then pass the name you entered
 */

public class WebDriverFactory {

    public static WebDriver getDriver(String browserName){


        WebDriver driver;

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                driver=null;
                System.out.println("Unknown browser name: " + browserName);
        }

        driver.manage().window().setPosition(new Point(1750,0));
        return driver;
    }
}
