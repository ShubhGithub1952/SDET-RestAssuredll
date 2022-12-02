package reqressAssignment;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

//import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddProjectWithJSONBody {
	@Test
	public void createProject() {
		baseURI="https://reqres.in";
		Random random = new Random();
		int randomNumb = random.nextInt(100);
		JSONObject jObj = new JSONObject();
		jObj.put("name", "JEFF BEZOJ"+randomNumb);
		jObj.put("job", "CEO of AMAZON");
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.post("/api/users")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(201).log().all();
	}
}
