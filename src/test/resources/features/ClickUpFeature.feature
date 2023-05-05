Feature: Click Up test feature

  Scenario: Create a new task after creating the list in the created folder
    Given Create a new Folder and verify that the name is correct
    When Create a new List and verify that the name is correct
    And Create a one Task and verify that the name is correct
    Then Remove the Task from the List and verify if the Task can't be found there anymore
