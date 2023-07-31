package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();

    @Given("write the {string} in search bar")

    public void write_search_n(String name) {
        homePage.search().sendKeys(name);
    }

    @And("click on search icon")
    public void search_icon() {
        homePage.searchButton().click();
    }

    @Then("shows relevant results for the {string}")
    public void result(String name) {
        SoftAssert SA = new SoftAssert();
        System.out.println(homePage.countProdct().size());
        SA.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q= ");
        for (int i = 0; i < homePage.countProdct().size(); i++) {
            String actualTitle = homePage.prodctTitle().get(i).getText().toLowerCase();
          SA.assertTrue(actualTitle.contains(name));
        }

    }

    @Given("write the {string} in Search bar")
    public void write_search_s(String sku) {
        homePage.search().sendKeys(sku);

    }

    @And("click on the product {string}")
    public void product(String sku) {


        if (sku.contains("SCI_FAITH") ) {
            homePage.photo1().click();
        }
     else if(sku.contains("APPLE_CAM"))

    {
        homePage.photo2().click();
    } else if(sku.contains("SF_PRO_11"))

    {
        homePage.photo3().click();
    }

}

    @Then("shows relevant results for {string}")
    public void resultSkU(String sku){

        if (sku.contains("SCI_FAITH"))      { Assert.assertTrue(homePage.sku1().getText().contains(sku));}
        else if (sku.contains("APPLE_CAM")) { Assert.assertTrue(homePage.sku2().getText().contains(sku));}
        else if (sku.contains("SF_PRO_11")) { Assert.assertTrue(homePage.sku3().getText().contains(sku));}

    }

}
