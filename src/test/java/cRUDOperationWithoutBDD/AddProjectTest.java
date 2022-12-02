package cRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	@Test
	//JSON BODY Created
	public void Create() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "AB Divilliers");
		jObj.put("projectName", "OneEight 19");
		jObj.put("status", "In-Progress");
		jObj.put("teamSize", 16);

		// Request Body and Content Type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jObj);
		reqSpec.contentType(ContentType.JSON);
		

		// Validation
		Response response = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validateResp = response.then();
		validateResp.assertThat().contentType(ContentType.JSON);
		validateResp.assertThat().statusCode(201);
		validateResp.log().all();
		//Response response1 = reqSpec.get("http://localhost:8084/projects");
		//ValidatableResponse ValidateResp1 = response1.then();
		//ValidateResp1.assertThat().contentType(ContentType.JSON);
		//ValidateResp1.assertThat().statusCode(200);
		//ValidateResp1.log().all();
	}
}
