Feature: Adding user address information

  Scenario Outline: The user adds new delivery address
    Given User is logged to online shop and user goes to his AccountPage
    When User goes to NewAddressPage
    And User entered <alias>, <address>, <city>, <postcode>, <country>, <phone> on your address page
    Then User create new address page
    And Close browser

     Examples:
      | alias | address     | city      | postcode | country        | phone         |
      | YNWA  | Anfield Rd  | Liverpool | L4 0TH   | United Kingdom | +441512642222 |