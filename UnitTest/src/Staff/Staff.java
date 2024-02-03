package Staff;

import mainInterface.Person;

public class Staff extends Person{

       String dept;

    public Staff(String f, String l, String dob, String id, String d) {

           super(f, l, dob, id);

           dept = d;

    }

    public void setDept(String d) {

           dept = d;

    }

    public String getDept() {

           return dept;

    }

    public int compareTo(Staff o) {

           return this.univID.compareTo(o.univID);

    }

}