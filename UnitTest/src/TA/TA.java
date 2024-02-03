package TA;

import java.util.ArrayList;

import mainInterface.Person;

public class TA extends Person{
	String dept;
    //String[] coursesAssisted;
	ArrayList<String> coursesAssisted = new ArrayList<String>();
    //String[] coursesAssisting;
	ArrayList<String> coursesAssisting = new ArrayList<String>();

    public TA(String f, String l, String dob, String id, String d, ArrayList<String> cAssisted, ArrayList<String> cAssisting) {
           super(f, l, dob, id);
           dept = d;
           coursesAssisted = cAssisted;
           coursesAssisting = cAssisting;
    }

    public void setDept(String d) {
           dept = d;
    }

    public String getDept() {
           return dept;
    }

    public void setCTaught(ArrayList<String> cAssisted) {
           coursesAssisted = cAssisted;
    }
    
    public ArrayList<String> getCTaught() {
           return coursesAssisted;
    }

    public void setCTeaching(ArrayList<String> cAssisting) {
           coursesAssisting = cAssisting;
    }

    public ArrayList<String> getCTeaching() {
           return coursesAssisting;
    }
    public int compareTo(TA o) {
           return this.univID.compareTo(o.univID);
    }
}