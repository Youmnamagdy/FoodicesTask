package RestAssured;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class restAssuredStepDefs {

    private RestAssuredApi restAssuredApi;
    private Response response;

    @Before
    @Given("I have valid credentials")
    public void iHaveValidCredentials() {
        restAssuredApi = new RestAssuredApi();
        restAssuredApi.initializeRequestForLogin();
    }

    @When("I send a login request")
    public void iSendALoginRequest() {
        restAssuredApi.sendLoginRequest("merchant@foodics.com", "123456", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
    }

    @Then("the login response is displayed successfully")
    public void theLoginResponseIsDisplayedSuccessfully() {
        Response response = restAssuredApi.getResponse();
        System.out.println("Login Response: " + response.asString());

    }


    @Then("the response status code should be {}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Response response = restAssuredApi.getResponse();
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @When("I send an invalid login request")
    public void iSendAnInvalidLoginRequest() {
        restAssuredApi.sendLoginRequest("merchant@foodics.com", "123455", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
    }

    @Given("I login using the second endpoint")
    public void iLoginUsingTheSecondEndpoint() {
        restAssuredApi.initializeRequestForWhoAmIEndpoint("merchant@foodics.com", "123456", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
    }

    @When("I print the data response after I use the token to get data")
    public void iPrintTheDataResponseAfterIUseTheTokenToGetData() {
        Response response = restAssuredApi.sendGetDataRequest();
        System.out.println("Login Response: " + response.asString());


    }

    @And("I login using the second endpoint with invalid token")
    public void iLoginUsingTheSecondEndpointWithInvalidToken() {
        restAssuredApi.initializeinvalidRequestForWhoAmIEndpoint("merchant@foodics.com", "123456", "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO");
    }
}


