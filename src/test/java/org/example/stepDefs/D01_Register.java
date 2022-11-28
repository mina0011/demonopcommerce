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
        register.registerLink().click();
    }

    @When("user select gender type")
    public void userSelectGenderType()
    {
        register.gender().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String FirstName, String LastName)
    {
        register.FirstName().sendKeys(FirstName);
        register.LastName().sendKeys(LastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth()
    {
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
        register.Email().sendKeys(Email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String Password, String ConfirmPassword)
    {
        register.Password().sendKeys(Password);
        register.ConfirmPassword().sendKeys(ConfirmPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton()
    {
        register.RegisterButton().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed()
    {
        SoftAssert soft = new SoftAssert();
        boolean SuccessfulMessage = register.SuccessMessage().isDisplayed();
        soft.assertTrue(SuccessfulMessage);
        String MessageColor = register.SuccessMessage().getCssValue("color");
        String ActualMessageColor = Color.fromString(MessageColor).asHex();
        soft.assertEquals(ActualMessageColor,"#4cb17c");
        soft.assertAll();
    }
}
