package cRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetDatafromProjectTest {
@Test
public void getProjectDetails() {
	RequestSpecification requestSpec = RestAssured.given();
	Response response = requestSpec.get("http://localhost:8084/projects");
	ValidatableResponse validateRespose = response.then();
	validateRespose.assertThat().contentType(ContentType.JSON);
	validateRespose.assertThat().statusCode(200);
	validateRespose.log().all();
}
}
