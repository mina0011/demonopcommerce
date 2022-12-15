@smoke
  Feature: D06_homeSliders | users could find two sliders when open home page
    Scenario: user click on first slider to direct user to this url nokia-lumia-1020
      When  user click on first slider
      Then  user redirect to this url nokia-lumia

    Scenario: user click on second slider to direct user to this url iphone-6
      When  user click on second slider
      Then  user redirect to Iphone URL