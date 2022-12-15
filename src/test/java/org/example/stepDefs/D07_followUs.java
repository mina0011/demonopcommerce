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

    @When("user opens facebook link")
    public void userOpensFacebookLink()
    {
        //user open facebook page
        home.FaceBook().click();

        //wait until thw no. if tabs become 2
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String URL) throws InterruptedException
    {
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        if (!URL.contains("new-online")) {
            //switch to tab 1
            Hooks.driver.switchTo().window(tabs.get(1));
            System.out.println("Tab 1 "+home.CurrentURL());
            System.out.println(driver.getTitle());
        } else {
            Hooks.driver.switchTo().window(tabs.get(0));
            System.out.println("Tab 0 "+home.CurrentURL());
            System.out.println(driver.getTitle());
        }

        //check that the Current URL match the expected
        Assert.assertEquals(home.CurrentURL(), URL);

        driver.close();

        driver.switchTo().window(tabs.get(0));

        System.out.println("Tab 0 "+home.CurrentURL());
        System.out.println(driver.getTitle());

    }

    @When("user opens twitter link")
    public void userOpensTwitterLink()
    {
        //user open Twitter page
        home.Twitter().click();

        //wait until thw no. if tabs become 2
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user opens rss link")
    public void userOpensRssLink()
    {
        //user open rss page
        home.RSS().click();
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink()
    {
        //user open Youtube page
        home.YouTube().click();

        //wait until thw no. if tabs become 2
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(8));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
