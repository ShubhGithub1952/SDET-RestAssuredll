package cRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ModifytheDataofProject {
	@Test
public void updateTheProject() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "AB Divilliers");
		jObj.put("projectName", "OneEight 1952");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 16);

		// Request Body and Content Type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jObj);
		reqSpec.contentType(ContentType.JSON);
		

		// Validation
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_2602");
		ValidatableResponse validateResp = response.then();
		validateResp.assertThat().contentType(ContentType.JSON);
		validateResp.assertThat().statusCode(200);
		validateResp.log().all();
}
}
