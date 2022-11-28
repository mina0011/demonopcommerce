package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void register()
    {
        //open registration page
        register.registerLink().click();
    }

    @When("user select gender type")
    public void userSelectGenderType()
    {
        //Select gender (Male)
        register.gender().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String FirstName, String LastName)
    {
        //Enter the first & last name
        register.FirstName().sendKeys(FirstName);
        register.LastName().sendKeys(LastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth()
    {
        //Select Birthday date
        Select dayList = new Select(register.DayList());
        dayList.selectByValue("30");

        Select MonthList = new Select(register.MonthList());
        MonthList.selectByValue("11");

        Select YearList = new Select(register.YearList());
        YearList.selectByValue("2001");
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String Email)
    {
        //enter valid email
        register.Email().sendKeys(Email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String Password, String ConfirmPassword)
    {
        //enter password & confirm password
        register.Password().sendKeys(Password);
        register.ConfirmPassword().sendKeys(ConfirmPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton()
    {
        //click on register button
        register.RegisterButton().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed()
    {
        //Assertion
        SoftAssert soft = new SoftAssert();

        // Check that Success Message is displayed
        boolean SuccessfulMessage = register.SuccessMessage().isDisplayed();
        soft.assertTrue(SuccessfulMessage);

        //Check that Success Message Contains "Your registration completed"
        String SuccessMessage = register.SuccessMessage().getText();
        soft.assertEquals(SuccessMessage.contains("Your registration completed"), true);

        //Check that the color of the Success message is green
        String MessageColor = register.SuccessMessage().getCssValue("color");
        String ActualMessageColor = Color.fromString(MessageColor).asHex();
        soft.assertEquals(ActualMessageColor,"#4cb17c");
        /*
        or use this code to use the color As RGBA
        String ActualMessageColor = Color.fromString(MessageColor).asRgba();
        soft.assertEquals(ActualMessageColor, "rgba(76, 177, 124, 1)");
         */
        soft.assertAll();
    }
}
