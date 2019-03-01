@regression
Feature: Add singles notes

  @add-note
  Scenario Outline: Add basic ToDo Note
    Given the access to the application
    When a user add the note with title "<name>" and reminder switch to "<flagReminder>"
    Then the user "can" see that "<name>" with reminder set to "<flagReminder>" in the home page list

    Examples: Data of notes to add
      | name                    | flagReminder |
      | Basic note              | false        |
      | Note with date and time | true         |

  @add-remove-note
  Scenario Outline: Remove a ToDo Note added
    Given the access to the application
    When a user add the note with title "<name>" and reminder switch to "<flagReminder>"
    And the user "can" see that "<name>" with reminder set to "<flagReminder>" in the home page list
    And the user search and delete the note with name "<name>" and reminder switch to "<flagReminder>"
    Then the user "cannot" see that "<name>" with reminder set to "<flagReminder>" in the home page list
    Then testing

    Examples: data to add and remove
      | name                     | flagReminder |
      | Reminder - go to the Gym | true         |