package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.pages.Home;

public class Navigation extends Context {

  public Navigation(Manager manager) {
    super(manager);
  }

  @Given("^Page under test is '(.+)'$")
  public void navToPage(String url) {
    manager.getDriver().get(url);
    Home homePage = new Home(manager.getDriver());
    stash("homePage", homePage);
  }
}