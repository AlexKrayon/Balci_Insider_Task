package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
   // GoogleStepDefinitions googleStepDefinitions=new GoogleStepDefinitions();

    @When("user types {word} and clicks enter")
    public void user_types_and_clicks_enter2(String searchKeyWord) {
        googleSearchPage.searchBox.sendKeys(searchKeyWord+Keys.ENTER);
    }


    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyWord) {
        googleSearchPage.searchBox.sendKeys(searchKeyWord+Keys.ENTER);
            }

    @Then("user sees {string} in the google page")
    public void user_sees_in_the_google_page(String string) {
        String expectedTitle = string +" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not expected",expectedTitle,actualTitle);
           }


    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
        //System.out.println("user types apple and clicks enter");
           }

    @Then("user sees apple in the google page")
    public void user_sees_apple_in_the_google_page() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        //System.out.println("user sees apple in the google page");

        Assert.assertEquals(expectedTitle,actualTitle);
        //Assert.assertTrue(actualTitle.equals(expectedTitle));



           }

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }
}
