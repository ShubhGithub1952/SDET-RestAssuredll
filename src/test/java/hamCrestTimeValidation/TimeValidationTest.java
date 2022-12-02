package hamCrestTimeValidation;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TimeValidationTest {
	@Test
	public void createProject() {
		Random random = new Random();
		int randomNumb = random.nextInt(100);
		JSONObject JObj = new JSONObject();
		JObj.put("createdBy","Zubillah");
		JObj.put("projectName", "DurexRelcoTuff - "+randomNumb);
		JObj.put("status", "In-Progress");
		JObj.put("teamSize", 14);
		
		given()
		.body(JObj)
		.contentType(ContentType.JSON)
		.when().post("http://localhost:8084/addProject")
		.then().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
