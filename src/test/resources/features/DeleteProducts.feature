@SystemTest @Tag
Feature: Delete products using delete api

  @SmokeTest  @Tag1
  Scenario Outline: validate delete product api work correctly
    Given I hit url of delete product api endpoint
    When I pass the url of delete products in the request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
      |ProductNumber |
      |7        |