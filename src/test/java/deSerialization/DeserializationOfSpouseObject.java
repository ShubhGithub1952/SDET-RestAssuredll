package deSerialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.Spouse;

public class DeserializationOfSpouseObject {
public static void main(String[] args) throws Throwable {
	ObjectMapper objMapper = new ObjectMapper();
	Spouse spouseObj = objMapper.readValue(new File("./spouseObject.json"),Spouse.class);
	System.out.println(spouseObj.getSpouseName());
	System.out.println(spouseObj.getSpouseId());
	for (String spouseMail : spouseObj.getSpouseMailId()) {
		System.out.println(spouseMail);
	}
}
}
