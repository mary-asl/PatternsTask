Feature: brand page test
  Background:
    Given I open home page, scroll down and click to brand logo

  Scenario: sort products using filters
    When categories are displayed on brand page
    And I click "Psychology" category on brand page
    And filter displayed items by discount
    Then items filtered by discount  correctly
    When filter displayed items by rate
    Then items filtered by rate  correctly
    When filter displayed items by price
    Then items filtered by price  correctly

  Scenario Outline: items category displayed correctly

    When I select category "<category>" and click to item with genre "<genre>"
    And click button read all information
    Then item matches selected category

    Examples:
      | category   | genre      |
      | Psychology | Психология |
      | Cooking    | Кулинария  |