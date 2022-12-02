package cRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetDataFromProjectTest1 {
	@Test
public void getProjects() {
		// Content Type
	//RequestSpecification requestSpec = RestAssured.given();
	//requestSpec.contentType(ContentType.JSON);
	//Validation
	Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_2803");
	ValidatableResponse validation = response.then().assertThat().statusCode(200);
	validation.log().all();
}
}
