package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    //elements
    By registerIconField =By.className("ico-register");
    By genderMaleField = By.id("gender-male");
    By genderFemaleField = By.id("gender-female");
    By FirstNameField = By.id("FirstName");
    By LastNameField = By.id("LastName");
    By emailField =By.id("Email") ;

    By CompanyField = By.id("Company") ;
    By newsletterField = By.id("Newsletter");
    By passwordField    = By.id("Password");
    By confirmPasswordField   = By.id("ConfirmPassword");
    By RegisterButtonField  = By.id("register-button");

    //actions
    public WebElement registerIcon() {
        return Hooks.driver.findElement(registerIconField);
    }

    public WebElement genderMale() {
        return Hooks.driver.findElement(genderMaleField);
    }

    public WebElement genderFemale() {
        return Hooks.driver.findElement(genderFemaleField);
    }

    public WebElement firstName() {
        return Hooks.driver.findElement(FirstNameField);
    }

    public WebElement lastName() {return Hooks.driver.findElement(LastNameField);}
    public WebElement email() {return Hooks.driver.findElement(emailField );}

    public  WebElement  companyName  () {return Hooks.driver.findElement( CompanyField)     ; }
    public  WebElement newsletter   () {return Hooks.driver.findElement(newsletterField )     ; }
    public  WebElement  password  () {return Hooks.driver.findElement(passwordField )     ; }
    public  WebElement confirmPassword   () {return Hooks.driver.findElement( confirmPasswordField)     ; }
    public  WebElement  registerButton  () {return Hooks.driver.findElement(RegisterButtonField )     ; }



}