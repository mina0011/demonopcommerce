package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currencies {

    P03_homePage home = new P03_homePage();

    @When("User select Euro currency")
    public void UserSelectEuroCurrency()
    {
        //Select Euro Currency from Currency List
        Select currency = new Select(home.CurrencyList());
        currency.selectByVisibleText("Euro");
    }

    @Then("Prices changed successfully")
    public void pricesChangedSuccessfully()
    {
        //verify Euro Symbol (€) is shown on the 4 products displayed in Home page using hard assertion
        int x = home.prices().size();
        for (int i = 0; i < x ; i++)
        {
            String price = home.prices().get(i).getText();
            System.out.println(i);
            System.out.println(price);
            //verify that the variable contains "€"
            Assert.assertTrue(price.contains("€"));
        }
    }
}
