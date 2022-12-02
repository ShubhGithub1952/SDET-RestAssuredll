package pojoClass;

public class Employee {
	String empName;
	int empId;
	String empMail;
	long empPhone;

	public Employee(String empName, int empId, String empMail, long empPhone) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empMail = empMail;
		this.empPhone = empPhone;
	}

	public Employee() {
		super();
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}



}
