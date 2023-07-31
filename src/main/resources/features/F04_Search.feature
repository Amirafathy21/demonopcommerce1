@smoke
Feature:
Scenario Outline:ser could search using product name
Given write the "<name>" in search bar
And click on search icon
Then shows relevant results for the "<name>"
  Examples:
  |name|
  | book   |
  | laptop |
  | nike   |


  Scenario Outline:ser could search using product sku
    Given write the "<sku>" in Search bar
    And click on search icon
    And  click on the product "<sku>"
    Then shows relevant results for "<sku>"
    Examples:
      |sku|
      | SCI_FAITH|
      | APPLE_CAM|
      | SF_PRO_11|