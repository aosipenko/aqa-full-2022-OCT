package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.dto.RandomUserResults;
import org.prog.util.DataHolder;
import org.prog.util.PageHolder;
import org.prog.util.Pages;
import org.prog.web.pageobjects.GooglePage;
import org.prog.web.pageobjects.commons.AbstractPage;

public class BrowserSteps {

  @Given("A running Chrome driver")
  public void initDriver() {

  }

  @When("I load {string} page")
  public void loadGooglePage(String pageName) {
    AbstractPage page = PageHolder.getInstance().get(Pages.valueOf(pageName));
    page.loadPage();
  }

  @When("google for {string}")
  public void googlePerson(String alias) {
    GooglePage googlePage = (GooglePage) PageHolder.getInstance().get(Pages.GOOGLE);
    googlePage.acceptCookies();
    googlePage.setSearchValue(firstLastName(alias));
    googlePage.performSearch(false);
  }

  @Then("Person {string} is present in searchResults")
  public void checkSearchResults(String alias) {
    GooglePage googlePage = (GooglePage) PageHolder.getInstance().get(Pages.GOOGLE);
    System.out.println(googlePage.getSearchResults().contains(firstLastName(alias)));
  }

  private String firstLastName(String alias) {
    RandomUserResults results = (RandomUserResults) DataHolder.getInstance().get(alias);
    return String.format("%s %s",
        results.getResults().get(0).getName().getFirst(),
        results.getResults().get(0).getName().getLast());
  }
}
