Feature: login and API Token

  Scenario Outline: check user can login successfully
    Given I have valid credentials
    When I send a login request
    Then the response status code should be <statusCode>
    And the login response is displayed successfully
    Examples:
      | statusCode |
      | 200        |

  Scenario Outline: check invalid login
    Given I have valid credentials
    When I send an invalid login request
    Then the response status code should be <statusCode>
    And the login response is displayed successfully
    Examples:
      | statusCode |
      | 500        |

  Scenario Outline: Use Token to Get Data
    Given I have valid credentials
    When I send a login request
    Then the response status code should be <statusCode>
    And I login using the second endpoint
    Then I print the data response after I use the token to get data
    Examples:
      | statusCode |
      | 200        |

  Scenario Outline: Use  invalid Token to Get Data
    Given I have valid credentials
    When I send a login request
    Then the response status code should be <statusCode>
    And I login using the second endpoint with invalid token
    Then I print the data response after I use the token to get data
    Examples:
      | statusCode |
      | 200        |


