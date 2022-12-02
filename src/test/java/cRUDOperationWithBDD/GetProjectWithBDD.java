package cRUDOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectWithBDD {
	@Test
	public void getProjects() {
		given()
		.get("http://localhost:8084/projects")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
	}
}
