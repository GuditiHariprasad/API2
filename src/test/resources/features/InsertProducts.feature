@SystemTest @Tag
Feature: Insert products using post api

  @SmokeTest  @Tag1
  Scenario Outline: validate post product api work correctly
    Given I hit url of post product api endpoint
    When I pass the url in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response code as 200
    Examples:
      |ProductTitle |
      |Shoes        |

  @RegressionTest @Tag2
  Scenario Outline: validate post1 product api work correctly
    Given I hit url of post product api endpoint
    When I pass the url in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response body with id as <id>
    Examples:
      |ProductTitle |id|
      |Shoes        |21|