package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.dto.RandomUserResults;
import org.prog.util.DataHolder;
import org.prog.web.pageobjects.GooglePage;
import org.prog.web.pageobjects.hotline.HotlinePage;
import org.springframework.beans.factory.annotation.Autowired;

public class BrowserSteps {

    @Autowired
    private DataHolder dataHolder;

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private HotlinePage hotlinePage;

    @Given("A running Chrome driver")
    public void initDriver() {

    }

    @When("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
    }

    @When("google for {string}")
    public void googlePerson(String alias) {
        googlePage.acceptCookies();
        googlePage.setSearchValue(firstLastName(alias));
        googlePage.performSearch();
    }

    @Then("Person {string} is present in searchResults")
    public void checkSearchResults(String alias) {
        System.out.println(googlePage.getSearchResults().contains(firstLastName(alias)));
    }

    private String firstLastName(String alias) {
        RandomUserResults results = (RandomUserResults) dataHolder.get(alias);
        return String.format("%s %s",
                results.getResults().get(0).getName().getFirst(),
                results.getResults().get(0).getName().getLast());
    }
}
