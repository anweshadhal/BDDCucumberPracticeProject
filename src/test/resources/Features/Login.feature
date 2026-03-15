Feature: Facebook Login Feature

  @smoke
  Scenario Outline: Validate the facebook login feature
    Given User is able to login to launch the facebook login page
    When User enters the "<username>" and "<password>" and hit enter
    Then User should be able to navigate to the facebook home page
    And User validates the home page
    Examples:
      | username     | password        |
      | anwesha_dhal | xyzxyzxyzxyzxyz |