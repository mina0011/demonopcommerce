@smoke
Feature: F03_currencies | User could switch between different currencies
  Scenario: user could select different option than dollar
    When User select Euro currency
    Then Prices changed successfully
