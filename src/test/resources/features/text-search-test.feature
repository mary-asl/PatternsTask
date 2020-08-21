Feature: basic text search

  Scenario Outline: user can find product using text search
    Given I search for product "<request>"
    When I click search button
    Then found item's name contains key words
    Then page title changed to "<request>"

    Examples:
      | request             |
      | funko pop star wars |
      | POLO SHIRT          |

  Scenario Outline: user can find product by SKU using text search
    When I search for numbers "<numbers>"
    Then the item number match the "<numbers>"

    Examples:
      | numbers    |
      | 13484017   |
      | 12240651   |