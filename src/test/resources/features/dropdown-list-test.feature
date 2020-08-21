Feature: dropdown list with countries

  Scenario Outline: change location using dropdown list
    Given I hover to change country button
    When I click "<country>" with "<locale>" and "<code>"
    Then current "<locale>" change

    Examples:
      | country    | locale     | code |
      | Belarus    | Минск      | by   |
      | Russia     | Москва     | ru   |
      | Kazakhstan | Нур-Султан | kz   |
      | Armenia    | Ереван     | am   |
      | Kyrgyzstan | Бишкек     | kg   |