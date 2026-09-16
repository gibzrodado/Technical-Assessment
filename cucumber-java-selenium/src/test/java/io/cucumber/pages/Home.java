package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.ArrayList;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css = "#content ul li a")
  private List<WebElement> exampleLinks;


  public WebElement getTitle() {
    return title;
  }

  public List<WebElement> getExampleLinks() {
    return exampleLinks;
  }

  public List<String> getLinkTexts() {
    List<String> linkTexts = new ArrayList<>();
    for (WebElement link: exampleLinks) {
      String text = link.getText();
      linkTexts.add(text);
    }
    return linkTexts;
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}
