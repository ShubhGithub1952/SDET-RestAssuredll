 package serialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClass.EmployeeArray;
import pojoClass.Spouse;

public class EmployeeArraySerialization {
public static void main(String[] args) throws Throwable{
	String [] phoneArr= {"8411918393","9049809031"};
	String [] mailArray= {"shubhamP19@gmail.com","shubbhamP52@gmail.com"};
	String [] spouseNumb= {"7488394364","9856748985"};
	String [] spouseMail= {"SatishBP19@gmail.com","SatishBP89@gmail.com"};
	Spouse spouseObject = new Spouse("SatishBP","Satish1989",spouseNumb,spouseMail);
	EmployeeArray empArray =new EmployeeArray("ShubhamBP","Shubh1952",mailArray,phoneArr,spouseObject);
	ObjectMapper objMapper = new ObjectMapper();
	objMapper.writeValue(new File("./empObjectArray.json"), empArray);
}
}
