package authentication.GetPet;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetPetAouth2Test {
	@Test
	public void getPet() {
		  Response response = given()
		 .formParam("client_id", "GetPetDog")
		 .formParam("client_secret", "8efaefbe10df208309f736fa872c4efd")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri", "http://getpet.com")
		 .formParam("code", "authorization_code")
		 
		 .when().post("http://coop.apps.symfonycasts.com/token");
		  
		  String token = response.jsonPath().get("access_token");
		  System.out.println(token);
		  
		  given()
		  .auth().oauth2(token)
		  .pathParam("User_Id", 3963)
		  .when()
		  .post("http://coop.apps.symfonycasts.com/api/{User_Id}/barn-unlock")
		  .then().log().all();
	}
}
