package differentWayToPost;

import java.util.Random;



import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.AddProjectWithBDD;

import static io.restassured.RestAssured.*;

public class AddProjectsWithHelpOfPOJOclassTest {
	@Test
	
	public void addProject() {
	Random random = new Random();
	int randomNumb = random.nextInt(500);
	 AddProjectWithBDD addEmp = new AddProjectWithBDD("SachinTandulkar"+randomNumb,"MRF-"+randomNumb,"In-Progress","12");
	given()
	.body(addEmp)
	.contentType(ContentType.JSON)
	.post("http://localhost:8084/addProject")
	.then().contentType(ContentType.JSON)
	.assertThat().statusCode(201).log().all();
}
}
