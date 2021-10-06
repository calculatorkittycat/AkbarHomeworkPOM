package com.cybertek.step_definitions;

import com.cybertek.pom.CommonAreaPOM;
import com.cybertek.pom.LoginPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderStepDef {
    LoginPagePOM loginPagePOM = new LoginPagePOM();
    CommonAreaPOM commonAreaPOM = new CommonAreaPOM();

    @Given("we are at web order login page")
    public void we_are_at_web_order_login_page() {
        loginPagePOM.goTo();
        assertTrue(loginPagePOM.login());
    }
    @When("we provide valid credentials {string} {string}")
        public void we_provide_valid_credentials(String username, String password) {
            loginPagePOM.loginAddCredentials(username, password);
            loginPagePOM.clickLogin();
    }
    @Then("we see all order page")
    public void we_see_all_order_page() {
        assertTrue(loginPagePOM.isAtHomePage());
    }


    @When("we provide in-valid credentials {string} {string}")
    public void weProvideInValidCredentials(String WrongUse, String WrongPass) {
        loginPagePOM.loginAddCredentials(WrongUse, WrongPass);
        loginPagePOM.clickLogin();
    }

    @Then("we should see an error message")
    public void weShouldSeeAnErrorMessage() {
        assertTrue(loginPagePOM.errorMessageDisplayed());
    }


    @Then("we should see welcome message containing username")
    public void weShouldSeeWelcomeMessageContainingUsername() {
        assertTrue(commonAreaPOM.verifyUserName());
    }

    @When("we click {string} tab") //view all products
    public void weClickTab(String tabName) {
        commonAreaPOM.selectSideBarTab(tabName);
    }

    @Then("we should see View All Products page")
    public void weShouldSeeViewAllProductsPage() {
assertTrue(commonAreaPOM.isAtViewAllProductsPage());
    }

    @Then("we should see the Orders page")
    public void weShouldSeeTheOrdersPage() {
        assertTrue(commonAreaPOM.isAtOrderPage());
    }

    @Then("we should see View All orders page")
    public void weShouldSeeViewAllOrdersPage() {
        assertTrue(commonAreaPOM.isAtViewAllOrdersPage());
    }
}
