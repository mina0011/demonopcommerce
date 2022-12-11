package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;
public class P03_homePage {

    //Currency
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

    //Search
    public WebElement searchBox()
    {
        return driver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchButton()
    {
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public String CurrentURL()
    {
        return driver.getCurrentUrl();
    }
    public List<WebElement> productTitles()
    {
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }
    public WebElement productPicture()
    {
        return driver.findElement(By.className("picture"));
    }
    public WebElement productSku()
    {
        return driver.findElement(By.cssSelector("div[class=\"sku\"]"));
    }

    //Hover Categories
    public List<WebElement> mainLinks()
    {
        return driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public WebElement PageTitle()
    {
        return driver.findElement(By.className("page-title"));
    }

}
