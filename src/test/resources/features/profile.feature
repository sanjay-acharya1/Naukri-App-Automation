@naukri
Feature: Naukri Home Page Functionalities

  Background: 
    Given I navigate to Naukri Application
    And Enter the credentials

  @prefloc
  Scenario: Edit Career Profile
    When I navigate to my profile
    And Click on career profile
    And I click on "preferred location", select/deselect a "location"
    And Click on save button
    Then I should see profile updated as "Today"

  @upre
  Scenario: Update Resume
    When I navigate to my profile
    And Click on update in resume
    And I click on resume that has to be uploaded
    Then Resume should be uploaded successfully
    And I should see profile updated as "Today"
