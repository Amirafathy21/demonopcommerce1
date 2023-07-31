package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {

    public WebElement euro(){
        return Hooks.driver.findElement(By.xpath("//select[@id=\"customerCurrency\" ]"));
    }
    public List<WebElement> currency(){
      return   Hooks.driver.findElements(By.xpath("//span[@class =\"price actual-price\"]"));
    }
    public WebElement search(){
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchButton(){
        return Hooks.driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"] "));
    }
    public WebElement photo1(){
        return Hooks.driver.findElement(By.xpath("//img[@alt=\"Picture of Science & Faith\"]"));
}
    public WebElement photo2(){
        return Hooks.driver.findElement(By.xpath("//img[@alt=\"Picture of Apple iCam\"]"));
    }
    public WebElement photo3(){
        return Hooks.driver.findElement(By.xpath("//img[@alt=\"Picture of Sound Forge Pro 11 (recurring)\"]"));
    }
 public WebElement sku1(){
        return Hooks.driver.findElement(By.xpath("//span[@id=\"sku-36\"]"));
 }
    public WebElement sku2(){
        return Hooks.driver.findElement(By.xpath("//span[@id=\"sku-17\"]"));
    }
    public WebElement sku3(){
        return Hooks.driver.findElement(By.xpath("//span[@id=\"sku-12\" ]"));
    }
    public List<WebElement> countProdct(){
        return Hooks.driver.findElements(By.xpath("//div[@class=\"product-item\"]"));
    }
    public List<WebElement> prodctTitle(){
        return Hooks.driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
    }

}

