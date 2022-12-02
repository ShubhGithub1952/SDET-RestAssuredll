package staticValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponeValidationTest {
	@Test
	public void staticMethodVerification() {
		String expectedProjectID="TY_PROJ_2803";
		Response response = when().get("http://localhost:8084/projects");
		   List<String> pIds = response.jsonPath().get("projectId");
		   boolean flag=false;
		   for (String actualProjectID : pIds) {
			if (actualProjectID.equalsIgnoreCase(expectedProjectID)) {
				System.out.println("Project Has Matched With Expected ProjectId");
				flag=true;
			}
		}
		   Assert.assertTrue(flag);
		   response.then().log().all(); 
	}
}
