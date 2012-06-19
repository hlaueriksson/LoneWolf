Feature: Terminology

The terminology used in the code base should match terms used in the books:
- A numbered section is represented by the Section class

  Scenario: Section
    Given the section number "1"
    Then an instance of Section can be used to represent the section
