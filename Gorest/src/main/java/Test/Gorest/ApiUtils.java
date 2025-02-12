package Test.Gorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ApiUtils {
	private static final String BASE_URL = "https://gorest.co.in/public";
    private static final String AUTH_TOKEN = "7117dd1d66168da9403119a30d17c9f3b1cae289e058508e527c939e3ee3a4bb";

    // Initialize Rest Assured configuration
    static {
        RestAssured.baseURI = BASE_URL;
    }

    // Method to create a user (POST)
    public Response createUser(String name, String gender, String email, String status) {
        String userPayload = getUserPayload(name, gender, email, status);

        return given()
                .header("Authorization", "Bearer "  + AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(userPayload)
                .post("/v2/users");
    }

    // Method to get payload
    private String getUserPayload(String name, String gender, String email, String status) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"gender\": \"" + gender + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }

    // Method to validate response
    public void validateResponse(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }


}
