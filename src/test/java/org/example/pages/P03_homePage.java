package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;
public class P03_homePage {

    public WebElement CurrencyList()
    {
        return driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> prices()
    {
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        /*
        OR
        List<WebElement> prices = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return prices;
         */
    }

}
