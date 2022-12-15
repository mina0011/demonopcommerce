@smoke
Feature: F05_hoverCategories | users could hover Categories and select one of sub options successfully
  Scenario: User hover on one of main categories then click on sub-category
    Given user hover on the main category
    When  user can view sub category if exist
    Then  user can select sub category or open main category
