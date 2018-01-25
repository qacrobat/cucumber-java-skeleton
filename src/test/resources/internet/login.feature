Feature: Login

    Background:
        Given User is on Login Page

    Scenario Outline: Successful Login with Valid Credentials
	    When User enters "<username>" and "<password>"
	    Then Message displayed Login Successfully
    Examples:
        | username | password |
        | tomsmith | SuperSecretPassword! |
        | tomsmith | SuperSecretPassword! |

    Scenario Outline: Unsuccesful Login with Invalid Credentials
	    When User enters "<username>" and "<password>"
	    Then Message displayed that Login was not successful
    Examples:
        | username | password |
        | tomsmith | SuperSecretPassword |
        | tomsmith | SuperSecretPassword |