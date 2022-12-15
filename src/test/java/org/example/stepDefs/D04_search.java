package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_search {

    P03_homePage home = new P03_homePage();

    //search using product name
    @When("user enter product name {string} to search")
    public void userEnterProductNameToSearch(String search)
    {
        //enter product that I search for
        home.searchBox().sendKeys(search);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton()
    {
        home.searchButton().click();
    }

    @Then("user find the product and relative products {string}")
    public void userFindTheProductAndRelativeProducts(String search)
    {
        //Assertion
        SoftAssert soft =new SoftAssert();

        //check that the url contains https://demo.nopcommerce.com/search?q=
        soft.assertEquals(home.CurrentURL().contains("https://demo.nopcommerce.com/search?q="),true);

        //Count number of search results
        int numberOfProducts = home.productTitles().size();
        System.out.println(numberOfProducts);

        //verify each result contains the search word
        int size = home.productTitles().size();
        for (int i=0;i<size;i++)
        {
            String productTitle = home.productTitles().get(i).getText().toLowerCase();
            System.out.println(productTitle);
            //verify each result contains the search word
            soft.assertEquals(productTitle.contains(search),true);
        }
        soft.assertAll();
    }

    //search for product using sku
    @When("user enter product sku {string} to search")
    public void userEnterProductSkuToSearch(String search)
    {
        //enter product that I search for
        home.searchBox().sendKeys(search);
    }

    @And("user clicks on the product in search result")
    public void userClicksOnTheProductInSearchResult()
    {
        //click on the product in search result
        home.productPicture().click();
    }

    @Then("user find the product that he looking for {string}")
    public void userFindTheProductThatHeLookingFor(String search)
    {

        //check the product contains the sku that you are using in search
        String productSku = home.productSku().getText();
        //print product sku
        System.out.println(productSku);
        //verify that the sku shown in this page then make sure it contains the sku that you are using in search
        Assert.assertTrue(productSku.contains(search));


    }
}
