package mainInterface;

public class Person {
	public String firstName;
	public String lastName;
	public String dateOfBirth;
	public String univID;
	
	public Person(String f, String l, String dob, String id) {
		firstName = f;
		lastName = l;
		dateOfBirth = dob;
		univID = id;
	}
	public void setFName(String fn) {
		firstName = fn;
	}
	public String getFName() {
		return firstName;
	}
	public void setLName(String ln) {
		lastName = ln;
	}
	public String getLName() {
		return lastName;
	}
	public void setDOB(String dob) {
		dateOfBirth = dob;
	}
	public String getDOB() {
		return dateOfBirth;
	}
	public void setUnivID(String id) {
		univID = id;
	}
	public String getUnivID() {
		return univID;
	}
}
