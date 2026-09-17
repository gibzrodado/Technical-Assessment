package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuth extends Page {
    public BasicAuth(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.example p")
    private WebElement successPrompt;

    public WebElement getSuccessPrompt() {
        return successPrompt;
    }
}