package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;


public class RestAssuredApi {
    private RequestSpecification request;
    private Response response;
    private String authToken;


    public void initializeRequestForLogin() {
        request = RestAssured.given()
                .baseUri("https://pay2.foodics.dev/cp_internal")
                .basePath("/login");
    }

    public void sendLoginRequest(String email, String password, String token) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("token", token);

        response = request
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post();
        authToken = response.jsonPath().getString("token");
        System.out.println(authToken);
    }

    public Response getResponse() {
        return response;
    }

    public void initializeRequestForWhoAmIEndpoint(String email, String password, String token) {

        String[] tokenParts = authToken.split("\\|");
        String extractedToken = tokenParts[1].trim();
        request = RestAssured.given()
                .baseUri("https://pay2.foodics.dev/cp_internal")
                .basePath("/whoami")
                .param("email", email)
                .param("password", password)
                .param("token", token)
                .header("Authorization", "Bearer " + extractedToken);
    }

    public Response sendGetDataRequest() {
        response = request.get();
        return response;
    }

    public void initializeinvalidRequestForWhoAmIEndpoint(String email, String password, String token) {

        String[] tokenParts = authToken.split("|");
        String extractedToken = tokenParts[1].trim();
        request = RestAssured.given()
                .baseUri("https://pay2.foodics.dev/cp_internal")
                .basePath("/whoami")
                .param("email", email)
                .param("password", password)
                .param("token", token)
                .header("Authorization", "Bearer " + extractedToken);
    }

}





