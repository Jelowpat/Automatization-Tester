Feature: Presta Shop tests

  Background:
    Given Page loaded
    And Not logged in

  Scenario: Sort items low to high
    Given Art tab is opened
    When pressed sort from low to high
    Then items are presented with prices from low to high

  Scenario: Adding an item to favourites list
    Given login page is open
    And user registration is completed
    And Art tab is opened
    When adding "Brown Bear" to favourites
    And navigating to Wishlist
    Then "bear" is listed as "Brown bear - Vector graphics"

  Scenario: Searching for Mug
    When searching for "Mug"
    Then Items are being found

  Scenario: Validating first name box when creating an account
    Given create your account page is opened
    When providing no first name data
    Then we receive first name validation message

  Scenario: Validating last name box when creating an account
    Given create your account page is opened
    When providing no last name data
    Then we receive last name validation message

  Scenario: Validating email box when creating an account
    Given create your account page is opened
    When providing incorrect email format
    Then we receive email validation message

  Scenario: Validating password box when creating an account
    Given create your account page is opened
    When providing too short password
    Then we receive password validation message

  Scenario: Validating first name box with special signs when creating an account
    Given create your account page is opened
    When providing incorrect name format
    Then we receive invalid format validation message