Feature: the task can be retrieved
  Scenario: client makes call to GET /all
    When the client calls "/task/{id}" with id as 1
    Then the client receives status code of 200
    And the client contains user name not null