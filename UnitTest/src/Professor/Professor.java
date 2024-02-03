package Professor;
import java.util.*;
import mainInterface.Person;

public class Professor extends Person{
	String dept;
	//String[] coursesTaught;
	ArrayList<String> coursesTaught = new ArrayList<String>();
	//String[] coursesTeaching;
	ArrayList<String> coursesTeaching = new ArrayList<String>();
	//String[] TAs;
	ArrayList<String> TAs = new ArrayList<String>();
	
	public Professor(String f, String l, String dob, String id, String d, ArrayList<String> cTaught, ArrayList<String> cTeaching, ArrayList<String> tas) {
		super(f, l, dob, id);
		dept = d;
		coursesTaught = cTaught;
		coursesTeaching = cTeaching;
		TAs = tas;
	}
	public void setDept(String d) {
		dept = d;
	}
	public String getDept() {
		return dept;
	}
	public void setCTaught(ArrayList<String> cTaught) {
		coursesTaught = cTaught;
	}
	public ArrayList<String> getCTaught() {
		return coursesTaught;
	}
	public void setCTeaching(ArrayList<String> cTeaching) {
		coursesTeaching = cTeaching;
	}
	public ArrayList<String> getCTeaching() {
		return coursesTeaching;
	}
	public void setTAs(ArrayList<String> tas) {
		TAs = tas;
	}
	public ArrayList<String> getTAs() {
		return TAs;
	}
	public int compareTo(Professor o) {
		return this.univID.compareTo(o.univID);
	}
}
