package reqressAssignment;

import java.util.Random;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ModifytheProjectTest {

	public void updateProject() {
		baseURI="https://reqres.in";
		Random random = new Random();
		int randomNumb = random.nextInt(100);
		JSONObject jObj = new JSONObject();
		jObj.put("name", "JEFF Mohammad"+randomNumb);
		jObj.put("job", "CEO of AMAZON");
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when().put("/api/users/2")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(200).log().all();
	}
}
