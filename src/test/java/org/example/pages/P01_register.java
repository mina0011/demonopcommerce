package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;
public class P01_register {

    public WebElement registerLink()
    {
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement gender()
    {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement FirstName()
    {
        return driver.findElement(By.id("FirstName"));
    }
    public WebElement LastName()
    {
        return driver.findElement(By.id("LastName"));
    }
    public WebElement DayList()
    {
        return driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement MonthList()
    {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement YearList()
    {
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement Email()
    {
        return driver.findElement(By.id("Email"));
    }
    public WebElement Password()
    {
        return driver.findElement(By.id("Password"));
    }
    public WebElement ConfirmPassword()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement RegisterButton()
    {
        return driver.findElement(By.id("register-button"));
    }
    public WebElement SuccessMessage()
    {
        return driver.findElement(By.className("result"));
    }

}
