package com.cybertek.step_definitions;

import com.cybertek.pom.LoginPagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test2 {
    LoginPagePOM loginPagePOM = new LoginPagePOM();

    @Given("User is at the login page")
    public void user_is_at_the_login_page() {
        loginPagePOM.goTo();
        assertTrue(loginPagePOM.isAtLoginPage());
    }

    @When("User enters in-valid credentials")
    public void user_enters_in_valid_credentials() {
        loginPagePOM.loginInvalidPlain();
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPagePOM.clickLogin();
    }

    @Then("Error message should be dispalyed")
    public void error_message_should_be_dispalyed() {
    assertTrue(loginPagePOM.errorMessageDisplayed());
    }

    @Then("User should still be at the login page")
    public void user_should_still_be_at_the_login_page() {
        loginPagePOM.goTo();
        assertTrue(loginPagePOM.isAtLoginPage());
    }

}
