Feature: Section

As a player
I want to view a section
so that I can follow the story

As a player
I want to move between sections
so that I can progress

As a player
I want to view illustrations on a section
so that I can follow the story

  Scenario: View a section
    Given the sections are initiated
    When a section is entered
    Then the section should be displayed by the view
