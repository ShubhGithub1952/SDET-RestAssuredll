package pathParameterAndRequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	@Test
 public void createProject() {
		baseURI="https://reqres.in";
	 JSONObject JObj = new JSONObject();
	 JObj.put("name", "AsokLayLand");
	 JObj.put("job", "Market Executor");
	 
	Response response = given()
	.body(JObj)
	.when().post("/api/users");
	response.then().contentType(ContentType.JSON);
	response.then().assertThat().statusCode(201).log().all();
	
 }
}
