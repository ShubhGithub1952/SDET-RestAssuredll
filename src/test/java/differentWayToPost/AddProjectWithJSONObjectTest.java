package differentWayToPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.CRM.SDET37.GenericUtility.EndPointsLibrary;
import com.CRM.SDET37.GenericUtility.IConstants;

import io.restassured.http.ContentType;
import pojoForBDDObject.BDDProjectObjectClass;

public class AddProjectWithJSONObjectTest {
	@Test
	public void Create() {
		BDDProjectObjectClass pobj = new BDDProjectObjectClass();
		given()
		.body(pobj.createProject())
		.contentType(ContentType.JSON)
		.post(IConstants.rmgURL+EndPointsLibrary.createProject)
		.then().assertThat().statusCode(201)
		.contentType(ContentType.JSON).log().all();
	}
}
