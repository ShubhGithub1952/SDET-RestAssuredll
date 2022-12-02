package differentWayToPost;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithJSONFile {
	@Test
	public void createProject() throws FileNotFoundException {
		FileInputStream fin = new FileInputStream("./src/test/resources/JSONData.json");
		given()
		.body(fin)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(201).log().all();
	}
}
