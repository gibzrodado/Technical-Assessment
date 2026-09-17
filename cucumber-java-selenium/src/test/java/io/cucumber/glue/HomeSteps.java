package io.cucumber.glue;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.pages.Home;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import io.cucumber.testdata.ExpectedLinks;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeSteps extends Context {

  public HomeSteps (Manager manager) {
    super(manager);
  }

  @When("I check the list of available examples")
  public void getActualLinks () {
    Home homePage = (Home) getTestStash().get("homePage");
    List<String> actualLinks = homePage.getLinkTexts();
    stash("actualLinks", actualLinks);
    System.out.println("Actual links found:" + actualLinks);
  }

  @Then("The available examples should match the expected list exactly")
  public void compareActualExpected () {
    List<String> expectedSorted = new ArrayList<>(ExpectedLinks.LINK);
    List<String> actualLinks = (List<String>) getTestStash().get("actualLinks");
    List<String> actualSorted = new ArrayList<>(actualLinks);

    Collections.sort(expectedSorted);
    Collections.sort(actualSorted);

    assertEquals(expectedSorted, actualSorted);
  }
}