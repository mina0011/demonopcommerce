package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser()
    {
        //1- bridge
        WebDriverManager.chromedriver().setup();
        //OR
        //System.setProperty

        //2- new object from chrome
        driver = new ChromeDriver();
        //3-Configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //4-Navigate
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        //quit driver
        driver.quit();
    }

}
