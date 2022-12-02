package cRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest1 {
	@Test
public void addProject() {
		//JSON Body
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","KL Rahul");
	jObj.put("projectName", "OneEight 1952");
	jObj.put("status", "In-Progress");
	jObj.put("teamSize", 16);
	
	//JSON Content Type
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
