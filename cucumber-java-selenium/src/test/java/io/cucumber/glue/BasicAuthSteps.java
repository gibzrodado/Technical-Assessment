package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.pages.BasicAuth;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthSteps extends Context {

    public BasicAuthSteps (Manager manager) {
        super(manager);
    }

    @Given("^Ready to access basic authentication$")
    public void readyForBasicAuth() {
        // Intentionally empty - this step exists to set the scnenario's context;
        // The actual navigation happends in the following When step.
    }

    @When("^I access the basic authentication page with valid credentials$")
    public void accessBasicAuthWithCredentials() {
        manager.getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        BasicAuth basicAuthPage = new BasicAuth(manager.getDriver());
        stash("basicAuthPage", basicAuthPage);
    }

    @Then("^Congratulations should be displayed$")
    public void checkPrompt() {
        BasicAuth basicAuth = (BasicAuth) getTestStash().get("basicAuthPage");
        String actualTitle = basicAuth.getSuccessPrompt().getText();
        String expectedTitle = "Congratulations! You must have the proper credentials.";

        assertEquals(expectedTitle, actualTitle);

    }
}