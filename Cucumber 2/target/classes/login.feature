Feature: Login


@Login
Scenario: Successfully Logged into Swag Lab App

  Given User Setup Web Browser Session
  When User Navigates to "Beazly Dashboard" URL
  Then User Validates "Heading" of "App Header" On "Swag Lab Inventory" Page
  And User Selects "user Name" on "User name TextBox" Field On "Swag Lab Login" Page