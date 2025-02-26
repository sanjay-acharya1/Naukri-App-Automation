@login
Feature: Naukri Application Login functionality

  Scenario Outline: Valid Login of Naukri Application
    Given I want to land in Naukri Application
    When I enter Username as "<email>" and Password as "<password>"
    And clcik the Login button
    Then user should land in home page

    Examples: 
      | email                | password        |
      | 170906461s@gmail.com | .manipal.MIT@11 |
