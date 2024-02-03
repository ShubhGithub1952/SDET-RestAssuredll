package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void getPeoject() {
		JSONObject JObj = new JSONObject();
		JObj.put("name", "RestAssured-BearerToken");
	}
}
