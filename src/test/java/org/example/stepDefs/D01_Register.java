package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.P01_register;

public class D01_Register {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void register()
    {
        register.registerLink().click();
    }


}
