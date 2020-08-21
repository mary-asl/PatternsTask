Feature: brand page test
  Background:
    Given I open home page, scroll down and click to brand logo

    Scenario Outline: sort products using filters
      When I click "<category>" category on brand page

      Examples:
      | category    | genre       |
      | Psychology  | Психология  |
      | Cooking     | Кулинария   |
