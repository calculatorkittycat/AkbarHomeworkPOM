package com.cybertek.testPom;

import com.cybertek.pom.CommonAreaPOM;
import com.cybertek.pom.LoginPagePOM;
import com.cybertek.pom.ViewAllOrderPagePOM;
import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.Driver;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPage extends TestBase {

    LoginPagePOM loginPagePOM = new LoginPagePOM();
    //now you have access to all the elements in LoginPagePom
    //because you called its constructor which contains a reference to all those elements

    CommonAreaPOM commonAreaPOM = new CommonAreaPOM();

    ViewAllOrderPagePOM viewAllOrderPagePOM = new ViewAllOrderPagePOM();

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

}
