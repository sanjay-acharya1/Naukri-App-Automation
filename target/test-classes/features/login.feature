@login
Feature: Naukri Application Login functionality


  Scenario: Valid Login of Naukri Application
    Given I want to land in Naukri Application
    When I enter Username as "170906461s@gmail.com" and Password as ".manipal.MIT@11"
    And clcik the Login button
    Then user should land in home page
