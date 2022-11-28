package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.stepDefs.Hooks.driver;
public class P02_login {

    public WebElement LoginLink()
    {
        return driver.findElement(By.className("ico-login"));
    }
    public WebElement email()
    {
        return driver.findElement(By.id("Email"));
    }
    public WebElement password()
    {
        return driver.findElement(By.id("Password"));
    }
    public WebElement LoginButton()
    {
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
    public String CurrentURL()
    {
        return driver.getCurrentUrl();
    }
    public WebElement MyAccount()
    {
        return driver.findElement(By.className("ico-account"));
    }
    public WebElement unSuccessfulMessage()
    {
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}
