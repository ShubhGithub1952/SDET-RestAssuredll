package pathParameterAndRequestChaining;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import com.CRM.SDET37.GenericUtility.DataBaseUtility;
import com.CRM.SDET37.GenericUtility.EndPointsLibrary;
import com.CRM.SDET37.GenericUtility.IConstants;
import com.CRM.SDET37.GenericUtility.JavaUtility;

import POM.LoginVerifyThenLogout;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.AddProjectWithBDD;

public class EndToEndAddProjectandVerifyProjectinGUITest {
	@Test
	public void createProject() throws Throwable {
		// Create the Project 
		JavaUtility jLib = new JavaUtility();
		AddProjectWithBDD addProj = new AddProjectWithBDD("Virat Kohali ", "One-Eight - "+jLib.getRandomNum(), "In-Progress", "28");
		
		//Pre-Condition of Project
	      Response response = given()
		.body(addProj)
		.contentType(ContentType.JSON)
		
		// Method of the Project 
		.when().post(IConstants.rmgURL+EndPointsLibrary.createProject);
		
		// Validation of the Project
	      response.then().contentType(ContentType.JSON);
	      response.then().assertThat().statusCode(201).log().all();
	      
	     String projId = response.jsonPath().get("projectId");
	     System.out.println("======= >>"+projId+"<<========");
	      
	      //Go to the GUI and Verify the Project
		LoginVerifyThenLogout guiVerification = new LoginVerifyThenLogout();
		guiVerification.loginToPageThenVerifyandLogout(projId);
		
		// Update the Project which is Exist
		AddProjectWithBDD addProj2 = new AddProjectWithBDD("Virat Kohali ", "VK-DP World - "+jLib.getRandomNum(), "Completed", "28");
		
		given()
		.pathParam("pathParam1", projId)
		.body(addProj2)
		.contentType(ContentType.JSON)
		.when().put(IConstants.rmgURL+EndPointsLibrary.updateProject+"{pathParam1}")
		.then().contentType(ContentType.JSON).statusCode(200).log().all();
		
		//Verify the Changes done in the GUI 
		guiVerification.loginToPageThenVerifyandLogout(projId);
		
		//Go to theDatabase and do the Verification
		DataBaseUtility dLib = new DataBaseUtility();
		dLib.connectToDB("projects");
		dLib.executeQuery("select * from project", 1, projId);
		dLib.closeDB();
		
	}
}
