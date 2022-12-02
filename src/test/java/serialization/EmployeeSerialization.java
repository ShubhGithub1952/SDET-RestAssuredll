package serialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.Employee;

public class EmployeeSerialization {
public static void main(String[] args) throws Throwable {
	Employee empObj = new Employee("ShubhamBP",1952,"ShubhamBP@Gmail.com",846652122);
	ObjectMapper objMapper = new ObjectMapper();
	objMapper.writeValue(new File("./emp.json"), empObj);
}
}
