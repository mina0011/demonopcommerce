package org.example.pages;

import org.openqa.selenium.By;
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

    //homeSliders
    public WebElement NokiaSlider ()
    {
        return driver.findElement(By.xpath("(//a[@href=\"https://demo.nopcommerce.com/\"])[1]"));
    }
    public WebElement IphoneSlider()
    {
        return driver.findElement(By.xpath("(//a[@href=\"https://demo.nopcommerce.com/\"])[2]"));
    }

    //followUs
    public WebElement FaceBook()
    {
        return driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }
    public WebElement Twitter()
    {
        return driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }
    public WebElement RSS()
    {
        return driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }
    public WebElement YouTube()
    {
        return driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    //Wishlist
    public WebElement HTCWishList()
    {
        return driver.findElement(By.xpath("(//button[@title='Add to wishlist'])[3]"));
    }
    public WebElement SuccessNotification()
    {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement WishListLink()
    {
        return driver.findElement(By.xpath("(//a[@href=\"/wishlist\"])[1]"));
    }
    public WebElement Quantity()
    {
        return driver.findElement(By.cssSelector("input[aria-label=\"Qty.\"]"));
    }

}
