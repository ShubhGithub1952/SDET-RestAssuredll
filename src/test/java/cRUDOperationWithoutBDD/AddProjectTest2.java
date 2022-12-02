package cRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest2 {
	@Test
	public void addProject() {
		//JSON Body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Dinesh Karthik");
		jObj.put("projectName","ONE Eight 2152");
		jObj.put("status", "In-Progress");
		jObj.put("teamSize", 12);
		
		//Json Content Type
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.body(jObj);
		requestSpec.contentType(ContentType.JSON);
		
		//Validation
		Response response = requestSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validation = response.then().assertThat().contentType(ContentType.JSON);
		validation.statusCode(201);
		validation.log().all();
	}
}
