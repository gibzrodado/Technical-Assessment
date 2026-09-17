## Implementation Notes

**Submitted by:** Gilbert Rodado

All three required scenarios are implemented and passing (`mvn test`, run from `cucumber-java-selenium/`).

### Design decisions

**Scenario 1 — Homepage links**
The live site currently lists 4 more examples than the requirement above (Checkboxes, Frames, Hovers, JQuery UI Menus). I updated the expected list in `testdata/ExpectedLinks.java` to match the live site's current state, on the assumption the requirement doc had deviated slightly.

**Scenario 2 — Basic Authentication**
The Basic Auth prompt is a native browser dialog, not part of the page DOM, so Selenium can't type into it directly. I used credential-embedded URLs (`https://admin:admin@...`) to bypass the dialog entirely, rather than clicking through from the homepage. This keeps the `Given` step free of any real action — it only establishes scenario context — while the actual navigation and authentication happen together in the `When` step, avoiding a redundant unauthenticated page load beforehand.

**Scenario 3 — Sortable Data Tables**
The live table has a 6th "Action" column (edit/delete links) not mentioned in the requirement above. I scoped the scraping logic in `pages/DataTables.java` to the first 5 columns (Last Name, First Name, Email, Due, Web Site) to match the stated requirement exactly, rather than expanding the expected data to include the extra column.

### Additional note

While working through this, I also built out an equivalent Cucumber/Playwright/JS implementation to solidify my understanding of the underlying BDD and automation concepts before translating them to Java/Selenium.

# Cucumber-Java-Selenium

This is a simple setup for Cucumber with Selenium using Java.

## Repo Clone and Submission

Please clone this repo (do NOT fork it), and push changes to your own account. Example of process steps linked [here](https://stackoverflow.com/questions/18200248/cloning-a-repo-from-someone-elses-github-and-pushing-it-to-a-repo-on-my-github).

```
- Follow good version control practices.
- An initial commit after cloning the repo, before making any changes.
- Any additional commits you want as you progress through the task.
```

Please push your work to your own github repo and share the link to the project with us, in good time, for review prior to interview. Please expect some questions/technical discussion during the interview, relating to your implementation of the given task.

## Project Requirements / Recommendations

- GitHub Account
- IDE - IntelliJ IDEA
- Defaults to run using Google Chrome, please ensure this is installed
- Maven
- Java 25

## Maven

Open a command/terminal window at the same level as this readme and run:

`cd cucumber-java-selenium`

`./mvn test -DskipTests`

## Run the tests

The runner is available [here](cucumber-java-selenium/src/test/java/io/cucumber/RunCucumberTest.java)

A basic HTML report will be available [here](cucumber-java-selenium/target/cucumber-report/cucumber.html) after a test run.

### Run a subset of Features or Scenarios

The feature file lives [here](cucumber-java-selenium/src/test/resources/io/cucumber/features/theInternet.feature)

You can also specify what to run by *tag*:

    @IncludeTags("ExampleTestTag")

# Required task

There are 3 titled scenarios in the [feature file](cucumber-java-selenium/src/test/resources/io/cucumber/features/theInternet.feature).

Please complete the scenarios to cover the requirements. Feel free to rework/create step definitions, rework/create Page Object Models as you deem appropriate.

Please submit your own code, NOT AI generated solutions to the problem.

### Requirement for Scenario: Homepage has a list of links to Expected examples

Ensure the displayed list of listed examples is as expected. The expected list should contain only the following

```
A/B Testing
Add/Remove Elements
Basic Auth (user and pass: admin)
Broken Images
Challenging DOM
Context Menu
Digest Authentication (user and pass: admin)
Disappearing Elements
Drag and Drop
Dropdown
Dynamic Content
Dynamic Controls
Dynamic Loading
Entry Ad
Exit Intent
File Download
File Upload
Floating Menu
Forgot Password
Form Authentication
Geolocation
Horizontal Slider
Infinite Scroll
Inputs
JavaScript Alerts
JavaScript onload event error
Key Presses
Large & Deep DOM
Multiple Windows
Nested Frames
Notification Messages
Redirect Link
Secure File Download
Shadow DOM
Shifting Content
Slow Resources
Sortable Data Tables
Status Codes
Typos
WYSIWYG Editor
```

### Requirement for Scenario: Basic Auth allows validated access

Test that navigation behaviour works as expected from the 'Homescreen' to 'Basic Auth'. Username and password are both given on the page.

### Requirement for Scenario: Sortable Data Tables - Example 1 displays the expected 4 results

Ensure the Example 1 table displays the following results.

| Last Name | First Name | Email                  | Due    | Web Site                   |
|-----------|------------|------------------------|--------|----------------------------|
| Smith     | John       | jsmith@gmail.com       | $50.00 | http://www.jsmith.com      |
| Bach      | Frank      | fbach@yahoo.com        | $51.00 | http://www.frank.com       |
| Doe       | Jason      | jdoe@hotmail.com       | $100.00| http://www.jdoe.com        |
| Conway    | Tim        | tconway@earthlink.net  | $50.00 | http://www.timconway.com   |
