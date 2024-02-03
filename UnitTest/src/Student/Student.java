package Student;

import java.util.ArrayList;

import mainInterface.Person;

//*************ArrayList<Integer> may work *************//
//*************GeekforGeeks has an example ************//

public class Student extends Person {
	// String[] courses;
	ArrayList<String> courses = new ArrayList<String>();
	// String[] semester;
	ArrayList<String> semester = new ArrayList<String>();
	// int[] nGrades;
	ArrayList<Integer> nGrades = new ArrayList<Integer>();
	// String[] lGrades;
	ArrayList<String> lGrades = new ArrayList<String>(); // may be string rather than Integer

    public Student(String f, String l, String dob, String id, ArrayList<String> c, ArrayList<String> s, ArrayList<Integer> nG, ArrayList<String> lG) {
        super(f, l, dob, id);
        courses = c;
        semester = s;
        nGrades = nG;
        lGrades = lG;
 }

	public void setCourses(ArrayList<String> c) {
 	courses = c;
 }

 public ArrayList<String> getCourses() {
        return courses;
 }

 public void setSemester(ArrayList<String> s) {
 	semester = s;
 }
 
 public ArrayList<String> getSemester() {
        return semester;
 }

	public void setNGrades(ArrayList<Integer> ng) {
		nGrades = ng;
 }

 public ArrayList<Integer> getNGrades() {
 	return nGrades;
 }

 
 public void setLGrades(ArrayList<String> lg) {
 	lGrades = lg;
 }
 
 public ArrayList<String> getLGrades() {
 	return lGrades;
 }
 
 public int compareTo(Student o) {
        return this.univID.compareTo(o.univID);
 }

}
////////////////////////////////////////////////////////////
