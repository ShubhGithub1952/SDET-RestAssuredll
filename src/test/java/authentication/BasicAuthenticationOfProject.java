package authentication;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.AddProjectWithBDD;

public class BasicAuthenticationOfProject {
	@Test
 public void basicAuth() {
		Random random = new Random();
		int randomNumb = random.nextInt(100);
	 AddProjectWithBDD addProjObj = new AddProjectWithBDD("Satish Rao", "MBA ChaiWala"+randomNumb, "In-Progress", "20");
	   Response response = given()
	   .auth().basic("rmgyantra", "rmgy@9999")
	   .body(addProjObj)
	   .contentType(ContentType.JSON)
	   .when().post("http://localhost:8084/addProject");
	   response.then().contentType(ContentType.JSON);
	   response.then().assertThat().statusCode(201).log().all();
	   response.then().assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS);
	   String projId = response.jsonPath().get("projectId");
	   
	   given()
	   .pathParam("Pid", projId)
	   .when().get("http://localhost:8084/projects/{Pid}")
	   .then().assertThat().statusCode(200).log().all();
 }
}
