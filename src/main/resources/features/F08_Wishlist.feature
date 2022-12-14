@smoke
Feature: F08_Wishlist | users could add products in their wishlist
  Scenario: user could add products in their wishlist
    When user click on wishlist button HTC product
    Then user see success message

  Scenario: user could add HTC in their wishlist
    When user click on wishlist button HTC product
    And user click on Wishlist Tab
    Then Verify user product add in WishListPage