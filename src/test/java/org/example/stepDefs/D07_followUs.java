package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_followUs {

    P03_homePage home = new P03_homePage();
    @When("user click on facebook link")
    public void facebookLink()
    {
        home.FaceBook().click();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    @Then("user verify that facebook page display")
    public void userVerifyThatFacebookPageDisplay() throws InterruptedException
    {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        System.out.println("Tab 1 "+home.CurrentURL());
        System.out.println(driver.getTitle());

        Assert.assertEquals(home.CurrentURL() ,"https://www.facebook.com/nopCommerce" );

        driver.close();

        driver.switchTo().window(tabs.get(0));

        System.out.println("Tab 0 "+home.CurrentURL());
        System.out.println(driver.getTitle());

    }

    @When("user click on twitter link")
    public void userClickOnTwitterLink()
    {
        home.Twitter().click();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    @Then("user verify that twitter page display")
    public void userVerifyThatTwitterPageDisplay() throws InterruptedException
    {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("Tab 1 "+home.CurrentURL());
        System.out.println(driver.getTitle());

        Assert.assertEquals(home.CurrentURL(), "https://twitter.com/nopCommerce");

        driver.close();
        driver.switchTo().window(tabs.get(0));

        System.out.println("tab 0 "+ home.CurrentURL());
        System.out.println(driver.getTitle());

    }

    @When("user click on RSS link")
    public void userClickOnRSSLink()
    {
        home.RSS().click();


    }

    @Then("user verify that RSS page display")
    public void userVerifyThatRSSPageDisplay() throws InterruptedException
    {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        System.out.println("Tab 1 "+home.CurrentURL());
        System.out.println(driver.getTitle());

        Assert.assertEquals(home.CurrentURL(),"https://demo.nopcommerce.com/new-online-store-is-open");

        driver.close();
        driver.switchTo().window(tabs.get(0));

        System.out.println("tab 0 "+ home.CurrentURL());
        System.out.println(driver.getTitle());
    }

    @When("user click on youtube link")
    public void userClickOnYoutubeLink()
    {
        home.YouTube().click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

    }

    @Then("user verify that youtube page display")
    public void userVerifyThatYoutubePageDisplay() throws InterruptedException
    {
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("Tab 1 "+home.CurrentURL());
        System.out.println(driver.getTitle());

        Assert.assertEquals(home.CurrentURL(),"https://www.youtube.com/user/nopCommerce");

        driver.close();
        driver.switchTo().window(tabs.get(0));

        System.out.println("Tab 0 "+home.CurrentURL());
        System.out.println(driver.getTitle());
    }
}
