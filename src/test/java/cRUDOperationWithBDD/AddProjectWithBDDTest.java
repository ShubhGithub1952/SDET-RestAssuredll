package cRUDOperationWithBDD;

import org.hamcrest.Matchers;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


import java.util.Random;

public class AddProjectWithBDDTest {
	@Test
 public void create() {
		// JSON Object
		Random random = new Random();
		int randNumber = random.nextInt(500);
	 JSONObject jObj = new JSONObject();
	 jObj.put("createdBy","Akshay-Kumar"+randNumber);
	 jObj.put("projectName","TichKuleConstruction"+randNumber);
	 jObj.put("status","In-Progress");
	 jObj.put("teamSize",12);
	 
	 given()
	   .contentType(ContentType.JSON)
	   .body(jObj)
	 .when()
	   .post("http://localhost:8084/addProject")
	   .then().contentType(ContentType.JSON)
	   .assertThat().statusCode(201)
	   .time(Matchers.lessThanOrEqualTo(2000L))
	   .log().all();
 }
}
