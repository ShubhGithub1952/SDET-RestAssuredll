package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthenticationOuth2 {
	@Test
public void createAuthenticationOuth() {
		Response response = given()
		.formParam("client_id", "SDET-KAPSER37")
		.formParam("client_secret", "636e33f3c7d6ea7d5408663894673a9a")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://Kapser.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		// Capture the Access Token From teh Respons Body
		String token = response.jsonPath().get("access_token");
		System.out.println("       "+token+"       ");
		
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID",3769)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		.then().log().all();
}
}
