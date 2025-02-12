package Test.Gorest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserApiTest extends TestBase{
	private UserApiPage userApiPage;

    public UserApiTest() {
        userApiPage = new UserApiPage();
    }

    // Test for creating a valid user
    @Test
    public void tc01() {
    	test = extent.createTest("tc01");
        String name = "panner";
        String gender = "male";
        String email = "panner@example.com"; 
        String status = "active";

        Response response = userApiPage.createNewUser(name, gender, email, status);
        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        userApiPage.validateUserCreation(response, 201);  // 201: Created

        test.pass("Test user creation with valid data");
    }

    // Test for creating a user with invalid data (missing email)
    @Test
    public void tc02() {
    	test = extent.createTest("tc02");
        String name = "Jane Doe";
        String gender = "male";
        String email = ""; // Invalid email
        String status = "active";

        Response response = userApiPage.createNewUser(name, gender, email, status);
        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        userApiPage.validateUserCreation(response, 422);  // 422: Unprocessable Entity
        test.pass("Test user creation with missing required fields");
    }

    // Test for edge case: invalid gender value
    @Test
    public void tc03() {
    	test = extent.createTest("tc03");
        String name = "Sam Doe";
        String gender = "male"; // Invalid gender
        String email = "abcdeexample.com";
        String status = "active";

        Response response = userApiPage.createNewUser(name, gender, email, status);
        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        userApiPage.validateUserCreation(response, 422);   // 422: Unprocessable Entity
        test.pass("Test user creation with an invalid email format");
    }
    
    @Test
    public void tc04() {
    	test = extent.createTest("tc04");
        String name = "selva";
        String gender = "male";
        String email = "selva@example.com"; 
        String status = "active";

        Response response = userApiPage.createNewUser(name, gender, email, status);
        test.info("Response Body: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());
        userApiPage.validateUserCreation(response, 422); 
        test.pass("Test user creation with same email format");

       
    }


}
