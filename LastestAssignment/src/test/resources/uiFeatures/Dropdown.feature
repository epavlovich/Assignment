@run
Feature: Validation of radiobutton and dropdown functions
Scenario: User should be able to click radiobuttons on the Automation web page.
Given user navigates to automation Web Page
When User click Male radiobutton in gender section
Then User click Cricket and Hockey in Hobbies section
Then User click Skills and chooses HTML

