package deSerialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.Employee;
import pojoClass.EmployeeArray;
import pojoClass.Spouse;

public class EmployeeDeserialization extends Spouse{
public static void main(String[] args) throws Throwable {
	ObjectMapper objMapper = new ObjectMapper();
	EmployeeArray empObj = objMapper.readValue(new File("./empObjectArray.json"), EmployeeArray.class);
	System.out.println(empObj.getEmpName());
	System.out.println(empObj.getEmpId());
	System.out.println(empObj.getEmpMail()[0]);
	System.out.println(empObj.getEmpMail()[1]);
	System.out.println(empObj.getEmpNumber()[0]);
	System.out.println(empObj.getEmpNumber()[1]);
	System.out.println(empObj.getSpouse().getSpouseName());
	System.out.println(empObj.getSpouse().getSpouseId());
	System.out.println(empObj.getSpouse().getSpouseMailId()[0]);
	System.out.println(empObj.getSpouse().getSpouseMailId()[1]);
	System.out.println(empObj.getSpouse().getSpouseNumb()[0]);
	System.out.println(empObj.getSpouse().getSpouseNumb()[1]);
}
}
