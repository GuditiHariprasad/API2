@SystemTest @Tag
Feature: Get all products from the api

  @SmokeTest  @Tag1
  Scenario: Verify the get api for all the products
    Given I hit url of get products api endpoint
    When I pass the url in the request
    Then I receive the response code as 200

  @RegressionTest`@Tag2
  Scenario Outline: Verify the rate of the first product is correct
    Given I hit url of get products api endpoint
    When I pass the url in the request
    Then I verify the rate of the first product is <FirstProductRate>
    Examples:
      |FirstProductRate |
      |3.9              |
