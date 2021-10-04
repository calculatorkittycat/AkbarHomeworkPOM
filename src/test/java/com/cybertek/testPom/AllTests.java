package com.cybertek.testPom;

import com.cybertek.pom.*;
import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AllTests extends TestBase {

    LoginPagePOM loginPagePOM = new LoginPagePOM();
    //now you have access to all the elements in LoginPagePom
    //because you called its constructor which contains a reference to all those elements

    CommonAreaPOM commonAreaPOM = new CommonAreaPOM();

    ViewAllOrderPagePOM viewAllOrderPagePOM = new ViewAllOrderPagePOM();

    ViewAllProductsPOM viewAllProductsPOM = new ViewAllProductsPOM();

    OrderPom orderPom = new OrderPom();

    @Test
    @Order(1)
    public void loginTest(){
        loginPagePOM.goTo();
        assertTrue(loginPagePOM.login());
    }

    @Test
    @Order(2)
    public void loginInvalid(){
        loginPagePOM.goTo();
        assertTrue(loginPagePOM.loginInvalid());

    }

    @Test
    @Order(3)
    public void logOutTest(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.logout();
        assertTrue(loginPagePOM.verifyAtLoginPage());

    }

    @Test
    @Order(4)
    public void isAtOrderPage(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("view all orders");
        BrowserUtility.waitFor(5);
        assertTrue(viewAllOrderPagePOM.isAtViewAllOrderPage());

    }

    @Test
    @Order(5)
    public void checkBoxes(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        //commonAreaPOM.selectSideBarTab("view all orders");
        BrowserUtility.waitFor(1);
        viewAllOrderPagePOM.testCheckBoxButton();
        BrowserUtility.waitFor(5);
    }

    //6. Create a method `verifyUserName`
    @Test
    @Order(6)
    public void verifyUserName(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        assertTrue(commonAreaPOM.verifyUserName());
    }

    //10. Create a method `getAllProducts`
    @Test
    @Order(7)
    public void getAllProducts(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("view all products");

        assertTrue(viewAllProductsPOM.getAllProducts());
    }

    //11. Create a method `calculateTotal`
    @Test
    @Order(8)
    public void getUnitPriceFromForm(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");

        orderPom.getUnitPriceFromForm("FamilyAlbum", 50);

    }

    //12. Create a method `getDiscountFromForm`
    @Test
    @Order(9)
    public void getDiscountFromForm(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        orderPom.getDiscountFromForm("ScreenSaver",50);

    }



    // 13. Create a method `calculateTotal`
    @Test
    @Order(10)
    public void calculateTotal(){
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        orderPom.calculateTotal("ScreenSaver", 50);

    }

    //"13". Create a method `getExpectedDiscount`
    @Test
    @Order(11)
    public void getExpectedDiscount() {
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        orderPom.getExpectedDiscount("ScreenSaver",50);

    }

    //14. Create a void method `enterAddressInfo`
    @Test
    @Order(12)
    public void enterAddressInfo() {
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        orderPom.enterAddressInfo();

    }

    //15. Create a void method `enterPaymentInfo`
    @Test
    @Order(13)
    public void enterPaymentInfo() {
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        orderPom.enterPaymentInfo("American Express");
    }

    //16. Create a void method `submitAndVerify`
    @Test
    @Order(13)
    public void submitAndVerify() {
        loginPagePOM.goTo();
        loginPagePOM.loginPlain();
        commonAreaPOM.selectSideBarTab("order");
        //orderPom.getUnitPriceFromForm("FamilyAlbum", 50);
        orderPom.fillForm("FamilyAlbum", 50);
        orderPom.enterAddressInfo();

        BrowserUtility.waitFor(1);


        orderPom.enterPaymentInfo("American Express");
        BrowserUtility.waitFor(1);
        assertTrue(orderPom.submitAndVerify());
        BrowserUtility.waitFor(1);
    }
}
