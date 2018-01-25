Feature: Login

    Background:
        Given Go to Loginpage

    Scenario: Login sucessfully
        When I enter my credentials
        Then I am logged in

    Scenario: Invalid Login
        When I enter invalid credentials
        Then I am not logged in
