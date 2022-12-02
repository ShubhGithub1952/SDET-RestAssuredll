package deSerialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.EmployeeArray;

public class EmployeeArrayDeserialization {
public static void main(String[] args) throws Throwable {
	//EmployeeArrayDeserialization empArray = new EmployeeArrayDeserialization();
	ObjectMapper objMapper = new ObjectMapper();
	EmployeeArray empArray = objMapper.readValue(new File("./empArray.json"), EmployeeArray.class);
	System.out.println(empArray.getEmpName());
	System.out.println(empArray.getEmpId());
	System.out.println(empArray.getEmpMail()[0]);
	System.out.println(empArray.getEmpMail()[1]);
	System.out.println(empArray.getEmpNumber()[0]);
	System.out.println(empArray.getEmpNumber()[1]);
}
}
