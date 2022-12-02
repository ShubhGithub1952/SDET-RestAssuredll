package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.AddProjectWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UsingDataDrivenTestingAddProjectTest {
	Random random = new Random();
	int randomNumb = random.nextInt(100);
	@Test (dataProvider = "dataDriven" )
 public void create(String createdBy,String projectName,String status,String teamSize) {
		
	 AddProjectWithBDD addProj = new AddProjectWithBDD(createdBy,projectName,status,teamSize);
	given()
	.body(addProj)
	.contentType(ContentType.JSON)
	.when()
	.post("http://localhost:8084/addProject")
	.then().contentType(ContentType.JSON)
	.assertThat().statusCode(201).log().all();
 }
	@DataProvider
	public Object[][] dataDriven() {
		Object[][] objArray = new Object[1][4];
		objArray[0][0]="Mahindra";
		objArray[0][1]="ScorPio"+randomNumb;
		objArray[0][2]="In-Progress";
		objArray[0][3]=16;
		return objArray;
	}
}
