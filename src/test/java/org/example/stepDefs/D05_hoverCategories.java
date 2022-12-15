package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


import static org.example.stepDefs.Hooks.driver;
public class D05_hoverCategories {

    P03_homePage home = new P03_homePage();
    int selectedCategory;
    List<WebElement> subcategoryLinks;
    String selectedCategoryText;

    @Given("user hover on the main category")
    public void hoverCategory() throws InterruptedException {
        Actions actions = new Actions(driver);

        int count = home.mainLinks().size();
        System.out.println("The count is "+ count);
        int min = 0;
        int max = count -1;
        //select random category
        selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(home.mainLinks().get(selectedCategory)).perform();
        selectedCategoryText = home.mainLinks().get(selectedCategory).getText();
        System.out.println(selectedCategoryText);
        Thread.sleep(2000);
    }

    @When("user can view sub category if exist")
    public void userCanViewSubCategoryIfExist()
    {
        selectedCategory = selectedCategory+1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li";
        subcategoryLinks = driver.findElements(By.xpath(locator));

        // minimize implicit wait to not waste time if it's empty
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Then("user can select sub category or open main category")
    public void userCanSelectSubCategoryOrOpenMainCategory()
    {

        if (!subcategoryLinks.isEmpty())
        {
            int subCategoryCount = subcategoryLinks.size();
            int min = 0;
            int max = subCategoryCount - 1;
            System.out.println("profile links "+ subCategoryCount);
            System.out.println(subcategoryLinks.get(0).getText());
            System.out.println(subcategoryLinks.get(1).getText());
            System.out.println(subcategoryLinks.get(2).getText());
            //select random sub-category
            int selectedSubCategory = (int) Math.floor(Math.random()*(max-min+1)+min);
            String selectedSubCategoryText = subcategoryLinks.get(selectedSubCategory).getText();
            System.out.println(selectedSubCategoryText);
            subcategoryLinks.get(selectedSubCategory).click();

            //Check that the sub-category title is equal the one you get it while selecting random sub-category
            Assert.assertEquals(selectedSubCategoryText.toLowerCase().trim(),home.PageTitle().getText().toLowerCase().trim());
        }
        else
        {
            home.mainLinks().get(selectedCategory-1).click();
            System.out.println(selectedCategoryText);
            //Check that the category title is equal the one you get it while selecting random category
            Assert.assertEquals(selectedCategoryText.toLowerCase().trim(), home.PageTitle().getText().toLowerCase().trim());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
