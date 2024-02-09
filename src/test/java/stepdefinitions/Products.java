package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Products {
    public RequestSpecification httpRequest;
    public int responseCode;
    public Response response;
    public ResponseBody body;
    public JSONObject requestParams;

    @Given("I hit url of get products api endpoint")
    public void i_hit_url_of_get_products_api_endpoint() {

        RestAssured.baseURI="https://fakestoreapi.com/";
    }
    @When("I pass the url in the request")
    public void i_pass_the_url_in_the_request() {
        httpRequest= given();
        response=httpRequest.get("products");
    }
    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        System.out.println(int1);
        responseCode=response.getStatusCode();
        assertEquals(responseCode,200);
    }
    @Then("I verify the rate of the first product is {}")
    public void i_verify_the_rate_of_the_first_product_is(String rate) {
       body= response.getBody();
       String responseBody=body.asString();
        JsonPath jsnpath=response.jsonPath();
        String s=jsnpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate,s);
    }
    @Given("I hit url of post product api endpoint")
    public void i_hit_url_of_post_product_api_endpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        httpRequest= given();
        requestParams= new JSONObject();
    }
    @When("I pass the request body of product title {}")
    public void i_pass_the_request_body_of_product_title(String x) {
        System.out.println(x);
        requestParams.put("title","shoes");
        requestParams.put("price","22.3");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg");
        requestParams.put("category","electronic");

        httpRequest.body(requestParams.toJSONString());
        response=httpRequest.post("products");
        body=response.getBody();

        JsonPath jsnpath=response.jsonPath();
        String s=jsnpath.getJsonObject("id").toString();
        assertEquals("21",s);

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
    @Then("I receive the response body with id as {}")
    public void i_receive_the_response_body_with_id_as(String int1) {
        System.out.println(int1);
    }

    @Given("I hit url of put product api endpoint")
    public void iHitUrlOfPutProductApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParams= new JSONObject();
    }

    @When("I pass the url in the request with {}")
    public void iPassTheUrlInTheRequestWithProductnumber(String productNumber) {
        httpRequest= RestAssured.given();
        requestParams.put("title","test produt1");
        requestParams.put("price","22.3");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg");
        requestParams.put("category","electronic");

        httpRequest.body(requestParams.toJSONString());
        response=httpRequest.put("products/"+productNumber);
        body=response.getBody();

        JsonPath jsnpath=response.jsonPath();
        String s=jsnpath.getJsonObject("id").toString();
        assertEquals(productNumber,s);

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @And("I pass the request body of put api")
    public void iPassTheRequestBodyOfPutApi() {
    }

    @Given("I hit url of delete product api endpoint")
    public void iHitUrlOfDeleteProductApiEndpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParams= new JSONObject();
    }

    @When("I pass the url of delete products in the request with {}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWithProductNumber(String productNumber) {

        httpRequest= RestAssured.given();
        httpRequest.body(requestParams.toJSONString());
        response=httpRequest.delete("products/"+productNumber);
        body=response.getBody();

        JsonPath jsnpath=response.jsonPath();
        String s=jsnpath.getJsonObject("id").toString();
        assertEquals(productNumber,s);

        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }
}
