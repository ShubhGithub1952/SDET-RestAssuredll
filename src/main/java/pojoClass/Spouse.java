package pojoClass;

public class Spouse {
	String spouseName;
	String spouseId;
	String [] spouseNumb;
	String [] spouseMailId;

	public Spouse(String spouseName, String spouseId, String[] spouseNumb, String[] spouseMailId) {
		super();
		this.spouseName = spouseName;
		this.spouseId = spouseId;
		this.spouseNumb = spouseNumb;
		this.spouseMailId = spouseMailId;
	}

	public Spouse() {
		super();
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseId() {
		return spouseId;
	}

	public void setSpouseId(String spouseId) {
		this.spouseId = spouseId;
	}

	public String[] getSpouseNumb() {
		return spouseNumb;
	}

	public void setSpouseNumb(String[] spouseNumb) {
		this.spouseNumb = spouseNumb;
	}

	public String[] getSpouseMailId() {
		return spouseMailId;
	}

	public void setSpouseMailId(String[] spouseMailId) {
		this.spouseMailId = spouseMailId;
	}


}
