package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_login {

    P02_login login = new P02_login();

    @Given("user go to login page")
    public void login()
    {
        //open login page
        login.LoginLink().click();
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String arg0, String email, String password)
    {
        //Enter your email and password
        System.out.println(arg0);
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton()
    {
        //Click on login button
        login.LoginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully()
    {
        //Assertion
        SoftAssert soft = new SoftAssert();

        //url should equal  https://demo.nopcommerce.com/
        soft.assertEquals(login.CurrentURL().contains("https://demo.nopcommerce.com/"),true);

        //MyAccount is displayed
        boolean myAccount = login.MyAccount().isDisplayed();
        soft.assertTrue(myAccount);

        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem()
    {
        //Assertion
        SoftAssert soft = new SoftAssert();

        //error message contains "Login was unsuccessful."
        String errorMessage = login.unSuccessfulMessage().getText();
        soft.assertEquals(errorMessage.contains("Login was unsuccessful"),true);

        //the color of this message is red "#e4434b"
        String messageColor = login.unSuccessfulMessage().getCssValue("color");
        String ActualColor = Color.fromString(messageColor).asHex();
        soft.assertEquals(ActualColor, "#e4434b");
    }
}
