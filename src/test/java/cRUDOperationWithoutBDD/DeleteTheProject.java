package cRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteTheProject {
	@Test
public void deleteProject() {
	RequestSpecification resquestSpec = RestAssured.given();
	Response response = resquestSpec.delete("http://localhost:8084/projects/TY_PROJ_2602");
	//response.getBody().asString();
	ValidatableResponse validateResp = response.then();
	validateResp.assertThat().contentType(ContentType.JSON);
	validateResp.assertThat().statusCode(204);
	validateResp.log().all();
}
}
