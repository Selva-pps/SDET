package Test.Gorest;
import io.restassured.response.Response;
//import api.utils.ApiUtils;
import io.restassured.response.Response;
//import api.utils.ApiUtils;
import io.restassured.response.Response;

public class UserApiPage {
	
	 private ApiUtils apiUtils;

	    public UserApiPage() {
	        apiUtils = new ApiUtils();
	    }

	    // Method to create a user
	    public Response createNewUser(String name, String gender, String email, String status) {
	        return apiUtils.createUser(name, gender, email, status);
	    }

	    // Method to validate response for user creation
	    public void validateUserCreation(Response response, int statusCode) {
	        apiUtils.validateResponse(response, statusCode);
	    }

}
