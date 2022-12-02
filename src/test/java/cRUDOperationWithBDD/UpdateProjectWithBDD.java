package cRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectWithBDD {
	@Test
	public void updateProject() {
		JSONObject jObj = new JSONObject();
		 jObj.put("createdBy","Ganesh-1952");
		 jObj.put("projectName","Big-Festival");
		 jObj.put("status","Completed");
		 jObj.put("teamSize",12);
		 
		 given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.put("http://localhost:8084/projects/TY_PROJ_3003")
		.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON).log().all();
	}
}
