package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
P03_homePage homePage =new P03_homePage() ;
    @When("Select Euro currency")
    public void Euro_currency(){
        WebElement currency_list = homePage.euro();
        Select currency_dropList = new Select(currency_list);
        currency_dropList.selectByVisibleText("Euro");


    }
    @Then("verify Euro Symbol is shown")
    public void Euro_symbol(){
        for ( Integer i =0; i<3; i++)
        {
            String actual = homePage.currency().get(i).getText();
            String expected = "€";
            Assert.assertTrue(actual.contains(expected));//pass
        }
    }
}
