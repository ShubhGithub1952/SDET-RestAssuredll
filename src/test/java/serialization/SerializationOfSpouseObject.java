package serialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.Spouse;

public class SerializationOfSpouseObject {
public static void main(String[] args) throws Throwable {
	String [] spouseNumb= {"8411918293","9049809031"};
	String [] spouseMail= {"sunnyLeon19@gmail.com","sunnyLeon52@gmail.com"};
	Spouse spouseObject = new Spouse("SunnyLeon","Sunny2152",spouseNumb,spouseMail);
	ObjectMapper objMapper = new ObjectMapper();
	objMapper.writeValue(new File("./spouseObject.json"), spouseObject);
}
}
