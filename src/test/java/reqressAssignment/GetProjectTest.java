package reqressAssignment;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectTest {
	@Test
	public void getProject() {
		baseURI="https://reqres.in";
		//JSONObject jObj=new JSONObject();
		//given()
		//ss.body(jObj)
		//.contentType(ContentType.JSON)
		when()
		.get("/api/users/2")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(200).log().all();
	}
}
