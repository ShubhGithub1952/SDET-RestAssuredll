package pojoClass;

public class EmployeeArray extends Spouse{
	String empName;
	String empId;
	String [] empMail;
	String [] empNumber;
	Spouse spouse;
	public EmployeeArray(String empName, String empId, String[] empMail, String[] empNumber,Spouse spouse) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empMail = empMail;
		this.empNumber = empNumber;
		this.spouse= spouse;
	}
	public EmployeeArray() {
		super();
	}
	
	public Spouse getSpouse() {
		return spouse;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String[] getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String[] empMail) {
		this.empMail = empMail;
	}
	public String[] getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String[] empNumber) {
		this.empNumber = empNumber;
	}

}
