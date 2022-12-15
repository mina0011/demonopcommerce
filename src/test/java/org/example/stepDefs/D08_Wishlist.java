package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;
import java.time.Duration;

public class D08_Wishlist {

    P03_homePage home = new P03_homePage();
    
    @When("user select to add HTC phone to wish list")
    public void WishListButton()
    {
        //User add HTC to Wish List
        home.HTCWishList().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(home.SuccessNotification()));
    }

    @Then("user see success message")
    public void userSeeSuccessMessage()
    {
        //Assertions
        SoftAssert soft = new SoftAssert();

        //check that success message being visible
        boolean successMessage = home.SuccessNotification().isDisplayed();
        soft.assertTrue(successMessage);

        //check that success message contains "The product has been added to your"
        String Massage = home.SuccessNotification().getText();
        soft.assertTrue(Massage.contains("The product has been added to your"));
        System.out.println(Massage);

        //check that background color of the success message is green
        String backgroundColor = home.SuccessNotification().getCssValue("background-color");
        //convert the color from RGBA to Hex
        String ActualBackgroundColor = Color.fromString(backgroundColor).asHex();
        soft.assertTrue(ActualBackgroundColor.contains("#4bb07a"));

        soft.assertAll();
    }

    @And("user click on Wishlist Tab")
    public void userClickOnWishlistTab()
    {
        //waiting until success message be invisible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(home.SuccessNotification()));

        //user go th Wish list page
        home.WishListLink().click();
    }

    @Then("user should find the product add in WishListPage")
    public void verifyUserProductAddInWishListPage()
    {
        //Assertions
        SoftAssert soft =new SoftAssert();

        //check that the quantity value of the product is bigger than 0
        String quantity = home.Quantity().getAttribute("value");
        int quantityValue = Integer.parseInt(quantity);
        System.out.println(quantityValue);

        soft.assertTrue(quantityValue>0);

        soft.assertAll();
    }
}
