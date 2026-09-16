Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
  Scenario: Homepage has a list of available examples
    Given Page under test is 'https://the-internet.herokuapp.com'
    When I check the list of available examples
    Then The available examples should match the expected list exactly

  @TEST_TI_0002
  Scenario: Basic authentication allows validated access
    Given Ready to access basic authentication
    When I access the basic authentication page with valid credentials
    Then Congratulations should be displayed

  @TEST_TI_0003
  Scenario: Example 1 displays the 4 expected results
    Given Access sortable data table through 'https://the-internet.herokuapp.com/tables'
    When I check the data of Example 1 table
    Then Example 1 should display the 4 expected results
