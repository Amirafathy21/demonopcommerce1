package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

public WebElement login_icon(){ return Hooks.driver.findElement(By.xpath("//a[@class=\"ico-login\"]"));
}
    public WebElement email(){ return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement password(){ return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginButton()
    { return Hooks.driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"] "));}
}
