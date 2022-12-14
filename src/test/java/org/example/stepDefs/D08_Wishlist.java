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
    
    @When("user click on wishlist button HTC product")
    public void WishListButton()
    {
        home.HTCWishList().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(home.SuccessNotification()));
    }

    @Then("user see success message")
    public void userSeeSuccessMessage()
    {
        SoftAssert soft = new SoftAssert();

        boolean successMessage = home.SuccessNotification().isDisplayed();
        soft.assertTrue(successMessage);

        String Massage = home.SuccessNotification().getText();
        soft.assertTrue(Massage.contains("The product has been added to your"));
        System.out.println(Massage);

        String backgroundColor = home.SuccessNotification().getCssValue("background-color");
        String ActualBackgroundColor = Color.fromString(backgroundColor).asHex();

        soft.assertTrue(ActualBackgroundColor.contains("#4bb07a"));

        soft.assertAll();
    }

    @And("user click on Wishlist Tab")
    public void userClickOnWishlistTab()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(home.SuccessNotification()));

        home.WishListLink().click();
    }

    @Then("Verify user product add in WishListPage")
    public void verifyUserProductAddInWishListPage()
    {
        SoftAssert soft =new SoftAssert();

        String quantity = home.Quantity().getAttribute("value");
        int quantityValue = Integer.parseInt(quantity);
        System.out.println(quantityValue);

        soft.assertTrue(quantityValue>0);

        soft.assertAll();
    }
}
