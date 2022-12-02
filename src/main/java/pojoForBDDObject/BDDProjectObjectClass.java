package pojoForBDDObject;

import java.util.Random;

import org.json.simple.JSONObject;

public class BDDProjectObjectClass {
	public  Object createProject() {
		JSONObject JObj = new JSONObject();
		Random random = new Random();
		int randomNumb = random.nextInt(500);
		JObj.put("createdBy","RATAN TATA");
		JObj.put("projectName","TATAConsultancy"+randomNumb);
		JObj.put("status","In-Progress");
		JObj.put("teamSize",12);
		return JObj;
	}
}
