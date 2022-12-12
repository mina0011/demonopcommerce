package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D06_homeSliders {

    P03_homePage home = new P03_homePage();
    @When("user click on first slider")
    public void FirstSlider() throws InterruptedException {
       home.NokiaSlider().click();
        Thread.sleep(1000);
    }

    @Then("Verify user redirect to this url nokia-lumia")
    public void verifyUserRedirectToThisUrlNokiaLumia()
    {
        Assert.assertEquals(home.CurrentURL() ,"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() throws InterruptedException {
        home.IphoneSlider().click();
        Thread.sleep(1000);
    }

    @Then("Verify user redirect to Iphone URL")
    public void verifyUserRedirectToIphoneURL()
    {
        Assert.assertEquals(home.CurrentURL()," https://demo.nopcommerce.com/iphone-6");
    }
}
