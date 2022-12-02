package pojoClass;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Test;

public class AddProjectWithJSONObjectBDD {
	public  JSONObject create() {
		JSONObject JObj = new JSONObject();
		Random random = new Random();
		int randomNumb = random.nextInt(500);
		JObj.put("createdBy","Akshay-Kumar"+randomNumb);
		JObj.put("projectName","TichKuleConstruction"+randomNumb);
		JObj.put("status","In-Progress");
		JObj.put("teamSize",12);
		return JObj;
	}
}
