@smoke
Feature: F04_Search | User could search of products
  Scenario Outline: user could search using product name
    When user enter product name "<search>" to search
    And user clicks on search button
    Then user find the product and relative products "<search>"
    Examples:
      | search |
      | book |
      | laptop |
      | nike |

  Scenario Outline: user could search for product using sku
    When user enter product sku "<search>" to search
    And user clicks on search button
    And user clicks on the product in search result
    Then user find the product that he looking for "<search>"
    Examples:
      | search |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |