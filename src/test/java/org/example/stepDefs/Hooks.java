package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver ;
    //static help to save the data when call method in another clase
    //non static save the date in memory just during the class , when go to another class the memory become NULL
@Before
public static void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.nopcommerce.com/");
}
@After
public static void teardown(){
    driver.quit();
}

}


