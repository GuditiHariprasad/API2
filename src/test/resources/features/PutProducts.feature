@SystemTest @Tag
Feature: Update products using put api

  @SmokeTest`@Tag1
  Scenario Outline: validate put product api work correctly
    Given I hit url of put product api endpoint
    When I pass the url in the request with <ProductNumber>
    And I pass the request body of put api
    Then I receive the response code as 200
    Examples:
      |ProductNumber |
      |7        |