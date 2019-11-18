Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  an incorrect username "as" and password "salainen1" and matching password confirmation are entered
        Then user is not created and error short username "username should have at least 3 characters" is reported

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  a valid username "liisa1" and nonvalid password "asd" and matching password confirmation are entered
        Then user is not created and error short password "password should have at least 8 characters" is reported

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  a valid username "liisa2" and password "salainen1" and non matching password "salasana1" confirmation are entered
        Then user is not created and error non matching passwords "password and password confirmation do not match" is reported

    Scenario: user can login with successfully generated account
        Given user with username "lea" with password "salainen1" is successfully created
        And   login is selected
        When  a valid username "lea" and password "salainen1" are entered
        Then user is logged in

    Scenario: user can not login with account that is not successfully created
        Given user with username "aa" and password "asd" is tried to be created
        And   login is selected
        When  nonexistent username "aa" and password "asd"
        Then  user is not logged in and error message is given
