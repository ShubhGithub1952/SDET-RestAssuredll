package differentWayToPost;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class WithTheHelpOfHasMAPTest {
	@Test
	public void create() {
		Random random = new Random();
		int randomNumb = random.nextInt(500);
		HashMap mapObj = new HashMap();
		mapObj.put("createdBy", "Jeff Bejoz");
		mapObj.put("projectName", "Amazon Web Services"+randomNumb);
		mapObj.put("status", "In-Progress");
		mapObj.put("teamSize", 16);
		
		given()
		.body(mapObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(201).log().all();
	}
}
