package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

import org.testng.Assert;


public class D06_homeSliders {

    P03_homePage home = new P03_homePage();
    @When("user click on first slider")
    public void FirstSlider() throws InterruptedException {

        //click on nokia slide
        home.NokiaSlider().click();
        Thread.sleep(2000);
    }

    @Then("user redirect to this url nokia-lumia")
    public void verifyUserRedirectToThisUrlNokiaLumia()
    {
        //check that the Current URL match the expected
        Assert.assertEquals(home.CurrentURL() ,"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() throws InterruptedException {

        //click on Iphone slide
        home.IphoneSlider().click();
        Thread.sleep(2000);
    }

    @Then("user redirect to Iphone URL")
    public void verifyUserRedirectToIphoneURL()
    {
        //check that the Current URL match the expected
        Assert.assertEquals(home.CurrentURL()," https://demo.nopcommerce.com/iphone-6");
    }
}
