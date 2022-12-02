package petStoreSwagger;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateUserPetStore {
	@Test
	public void createUSer(){
		JSONObject JObj = new JSONObject();
		JObj.put("username", "Swagger-19");
		JObj.put("firstName" , "Shushil");
		JObj.put("lastName", "Boyane");
	}
}
