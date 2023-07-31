package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void register_Page(){

        register.registerIcon().click();
    }
    @When("user select gender type")
    public void gender() throws InterruptedException{
        register.genderFemale().click();
        Thread.sleep(500);
    }
    @And("user enter first name \"automation\" and last name \"tester\"")
    public void first_last_name() {

        register.firstName().sendKeys("automation");

        register.lastName().sendKeys("tester");
    }
    @And("user enter date of birth")
    public void birth_date(){
        WebElement day_list =Hooks.driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
        Select day_droplist = new Select(day_list);

        day_droplist .selectByValue("21");

        WebElement month_list = Hooks.driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        Select month_droplist = new Select(month_list);

        month_droplist .selectByValue("12");

        WebElement year_list = Hooks.driver.findElement(   By.xpath("//select[@name=\"DateOfBirthYear\"]") );
        Select year_droplist = new Select(year_list);

        year_droplist .selectByValue("1999");


    }
    @And("user enter email {string}")
    public void email(String Email ){
        register.email().sendKeys(Email);
    }
    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void password(){
        register.password().sendKeys("P@ssw0rd");
        register.confirmPassword().sendKeys("P@ssw0rd");
    }
    @And("user clicks on register button")
    public void register_buttom(){
        register.registerButton().click();
    }
    @Then("success message is displayed")
    public void success()throws InterruptedException{

        WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]"))));

        SoftAssert successMSG = new SoftAssert();
        String actualSuccessMsg = Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        String error = "Your registration completed";
        String colorSuccessMsg = Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]")).getCssValue("color");
        String excolor = "rgba(76, 177, 124, 1)";
        successMSG.assertTrue(actualSuccessMsg.contains(error));
        successMSG.assertEquals( colorSuccessMsg,excolor);
        successMSG.assertAll();
    }

}
