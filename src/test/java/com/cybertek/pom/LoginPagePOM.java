package com.cybertek.pom;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.ConfigReader;
import com.cybertek.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class will hold the elements and the methods needed to interact with the login page
 * using the @FindBY annotation we can locate an element by its type (id, xpath, cssSelector, partialLinkText etc)
 * and assign that element to a WebElement and give it a name
 * it is like saying WebElement name = Driver.getDriver.findElement(By.id="id_name");
 *
 * there is a constructor under the elements
 * saying 'this' tells the method to to deal with the elements in this class
 *
 *         //page factory is a selenium class that supports Page Object Model
 *         //it has a method in it called initElements
 *         //once it is called it will locate all the elements specified by their given name
 *
 *
 */

public class LoginPagePOM {

    @FindBy(id = "ctl00_MainContent_username") // annotation to give special meaning to this field
    public WebElement userNameField;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordField;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;;

    @FindBy(xpath = "//p[2]")
    public WebElement beforeLoginMsg;

    @FindBy(xpath = "//h1")
    public WebElement afterLoginHeader;

    //When you call this constructor you will have access to all the elements
    //PageFactory is a class that is meant to deal with POM
    //When you call the initElements method you will be able to access all
    //the elements by passing the 'this' keyword meaning the elements in 'this' class
    public LoginPagePOM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Methods

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("weborder_url"));
    }

    public boolean login(){
        this.userNameField.sendKeys(ConfigReader.read("weborder_username"));
        this.passwordField.sendKeys(ConfigReader.read("weborder_password"));
        this.loginButton.click();
        BrowserUtility.waitFor(2);
        if(this.afterLoginHeader.isDisplayed()){
            return true;
        } else {
            return false;
        }

    }

    public boolean loginInvalid(){
        this.userNameField.sendKeys("WrongUsername");
        this.passwordField.sendKeys("WrongPassword");
        this.loginButton.click();
        BrowserUtility.waitFor(2);

        if (this.errorMsg.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void loginInvalidPlain(){
        this.userNameField.sendKeys("WrongUsername");
        this.passwordField.sendKeys("WrongPassword");
    }

    public void loginPlain(){
        this.userNameField.sendKeys(ConfigReader.read("weborder_username"));
        this.passwordField.sendKeys(ConfigReader.read("weborder_password"));
        //this.loginButton.click();
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public boolean isAtHomePage(){
        if(this.afterLoginHeader.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtLoginPage(){
        if(this.userNameField.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }


    public boolean verifyAtLoginPage(){
        if(this.beforeLoginMsg.isDisplayed()){
            return true;
        } else {
            return false;
        }

    }

    public boolean errorMessageDisplayed(){
        if (this.errorMsg.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void loginAddCredentials(String username, String password){
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
    }

    public void name(){

    }








}


