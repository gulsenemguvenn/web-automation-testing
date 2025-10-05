Feature: Example Scenario
  Scenario Outline: Go to website and login test
    Given go to login page
    And user types username as "<username>"
    And user types password as "<password>"
    When click button
    Then assert to success message

    Examples:
      | username | password    |
      | student  | Password123 |
      | ali      | 123456      |
      | gulsenem | random      |
