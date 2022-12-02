package pathParameterAndRequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.SDET37.GenericUtility.BaseAPIClass;
import com.CRM.SDET37.GenericUtility.DataBaseUtility;
import com.CRM.SDET37.GenericUtility.EndPointsLibrary;
import com.CRM.SDET37.GenericUtility.IConstants;
import com.CRM.SDET37.GenericUtility.JavaUtility;
import com.CRM.SDET37.GenericUtility.RestAssuredLibrary;

import POM.LoginVerifyThenLogout;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.AddProjectWithBDD;

public class EndtoEndAPITest extends BaseAPIClass{
	@Test
	public void createProject() throws Throwable {
		//baseURI="http://localhost:8084";
		
		JavaUtility jLib = new JavaUtility();
		RestAssuredLibrary restObj = new RestAssuredLibrary();
		
		//Entering the Argument of Create Project Constructor
		AddProjectWithBDD addProj = new AddProjectWithBDD("SangMeshG", "Sangmesh-Bhel - "+jLib.getRandomNum(), "In-Pogress", "16");
		Response response = given()
				.body(addProj)
				.contentType(ContentType.JSON)
				.when().post(IConstants.rmgURL+EndPointsLibrary.createProject);
		response.then().contentType(ContentType.JSON);
		response.then().statusCode(201).log().all();
		String projId =restObj.getJsonData(response, "projectId");
		System.out.println(projId);

		//Create the PAth PathParameter for Get data From Server
		given()
		.pathParam("projectID", projId)
		.when().get(IConstants.rmgURL+EndPointsLibrary.singleProject+"{projectID}")
		.then().statusCode(200).log().all();
		
		//Modify the Project
		AddProjectWithBDD addProj1 = new AddProjectWithBDD("SangMeshG", "Sangmesh-Bhel and PaniPuri - "+jLib.getRandomNum(), "Completed", "16");
		given()
		.pathParam("projectID", projId)
		.body(addProj1)
		.contentType(ContentType.JSON)
		.when().put(IConstants.rmgURL+EndPointsLibrary.singleProject+"{projectID}")
		.then().contentType(ContentType.JSON).statusCode(200).log().all();
		
		//Verify the Project in RMG Yantra GUI 
		
		LoginVerifyThenLogout verifyinPresentationLayer = new LoginVerifyThenLogout();
		verifyinPresentationLayer.loginToPageThenVerifyandLogout(projId);
		
		// Verify in the Database  whether the Project is Present or not
		DataBaseUtility dLib = new DataBaseUtility();
		
		dLib.executeQuery("select * from project", 1, projId);
		
		given()
		.pathParam("projectID", projId)
		.when().delete(IConstants.rmgURL+EndPointsLibrary.singleProject+"{projectID}")
		.then().contentType(ContentType.JSON).statusCode(204).log().all();
		
		//Verify in Presentation Layer when the Project is Deleted 
		verifyinPresentationLayer.loginToPageThenVerifyandLogout(projId);
		
		//Verify in the DataBase
		dLib.executeQuery("select * from project", 1, 	projId);
	}
}
