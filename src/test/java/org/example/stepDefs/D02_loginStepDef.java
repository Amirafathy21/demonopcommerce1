package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

import java.time.Duration;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given("user go to login page")
    public void loginPage(){login.login_icon().click();
    }
    @When("user login with valid {string} and {string}")
    public void validUser(String EMAIL , String PASS){
        login.email().sendKeys(EMAIL);
        login.password().sendKeys(PASS);}

    @When("user login with invalid {string} and {string}")
    public void invalidUser(String EMAIL , String PASS){
        login.email().sendKeys(EMAIL);
        login.password().sendKeys(PASS);}

    @And("user press on login button")
    public void loginButton(){login.loginButton().click();
    }
    @Then("user login to the system successfully")
    public void successLogin(){

        WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath("//a[@class=\"ico-account\"]"))));

        SoftAssert suc_LOG = new SoftAssert();
        //Assertion by URL
        String expectedURL = "https://demo.nopcommerce.com/";
        suc_LOG.assertEquals(Hooks.driver.getCurrentUrl() ,expectedURL);
        //Assertion by My account" tab isDisplayed
        String myAccTab = Hooks.driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).getText();
        suc_LOG.assertEquals( myAccTab,"My account");

        suc_LOG.assertAll();
    }

    @Then("user could not login to the system")
    public void failLogin(){
        WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"))));
        //assertion by error msg
        String actualError= Hooks.driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).
                getText();
        String  expectedError= "Login was unsuccessful";
        SoftAssert fail_LOG = new SoftAssert();
        fail_LOG.assertTrue(actualError.contains(expectedError));

        //assertion by color
        String colorFailMSG = Hooks.driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).
                getCssValue("color");
        String colorHex = Color.fromString(colorFailMSG ).asHex();
        String excolor = "#e4434b" ;
        fail_LOG.assertEquals( colorHex,excolor);

        fail_LOG.assertAll();
    }


}
