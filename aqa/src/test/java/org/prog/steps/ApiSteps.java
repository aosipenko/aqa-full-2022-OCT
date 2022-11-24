package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.prog.dto.RandomUserResults;
import org.prog.util.DataHolder;

public class ApiSteps {

    private final static String USER_REQUEST_URL =
            "https://randomuser.me/api/?inc=gender,name,nat&noinfo&results&gender=%s";

    @Given("a random {string} person {string}")
    public void generateRandomPerson(String gender, String alias) {
        DataHolder.getInstance().put(alias, generateUser(gender));
    }

    private RandomUserResults generateUser(String gender) {
        Response resp = RestAssured.given()
                .get(String.format(USER_REQUEST_URL, gender));

        return resp.as(RandomUserResults.class);
    }

    @When("I print a user {string}")
    public void printUser(String alias) {
        System.out.println(((RandomUserResults) DataHolder.getInstance().get(alias))
                .getResults().get(0).getName().getFirst());
    }
}
