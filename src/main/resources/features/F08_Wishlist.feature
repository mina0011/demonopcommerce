@smoke
Feature: F08_Wishlist | users could add products in their wishlist
  Scenario: user could add products in their wishlist
    When user select to add HTC phone to wish list
    Then user see success message

  Scenario: user could add HTC in their wishlist
    When user select to add HTC phone to wish list
    And user click on Wishlist Tab
    Then user should find the product add in WishListPage