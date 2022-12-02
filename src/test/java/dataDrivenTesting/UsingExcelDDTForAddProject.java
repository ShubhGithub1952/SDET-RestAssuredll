package dataDrivenTesting;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtility.GetDataFromExcel;
import io.restassured.http.ContentType;
import pojoClass.AddProjectWithBDD;

import static io.restassured.RestAssured.*;

public class UsingExcelDDTForAddProject extends GetDataFromExcel {
	Random random = new Random();
	int randomNumb = random.nextInt(500);
	@Test(dataProvider = "getDataProvider")
	public void createProject(String createdBy, String projectName, String status, String teamSize  ) {
		AddProjectWithBDD addProj = new AddProjectWithBDD(createdBy, projectName, status, teamSize);
		given()
		.body(addProj)
		.contentType(ContentType.JSON)
		.when().post("http://localhost:8084/addProject")
		.then().contentType(ContentType.JSON)
		.assertThat().statusCode(201).log().all();
	}
	@DataProvider
	public Object[][] getDataProvider() throws Throwable {

		Object[][] objArray = new Object[4][4];
		objArray[0][0]=getDataFromExcelFile("BDDProject", 2, 1);
		objArray[0][1]=getDataFromExcelFile("BDDProject", 2, 2)+randomNumb;
		objArray[0][2]=getDataFromExcelFile("BDDProject", 2, 3);
		objArray[0][3]=getDataFromExcelFile("BDDProject", 2, 4);

		objArray[1][0]=getDataFromExcelFile("BDDProject", 3, 1);
		objArray[1][1]=getDataFromExcelFile("BDDProject", 3, 2)+randomNumb;
		objArray[1][2]=getDataFromExcelFile("BDDProject", 3, 3);
		objArray[1][3]=getDataFromExcelFile("BDDProject", 3, 4);

		objArray[2][0]=getDataFromExcelFile("BDDProject", 4, 1);
		objArray[2][1]=getDataFromExcelFile("BDDProject", 4, 2)+randomNumb;
		objArray[2][2]=getDataFromExcelFile("BDDProject", 4, 3);
		objArray[2][3]=getDataFromExcelFile("BDDProject", 4, 4);

		objArray[3][0]=getDataFromExcelFile("BDDProject", 5, 1);
		objArray[3][1]=getDataFromExcelFile("BDDProject", 5, 2)+randomNumb;
		objArray[3][2]=getDataFromExcelFile("BDDProject", 5, 3);
		objArray[3][3]=getDataFromExcelFile("BDDProject", 5, 4);
		return objArray;
	}
}
