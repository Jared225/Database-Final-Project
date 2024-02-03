package Staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

//import Professor.Professor;
// remove all  and create one object of that class. (which was ) 
import mainInterface.Interface;

public class StaffManager {

	ArrayList<Staff> Staffs = new ArrayList<Staff>();

	public ArrayList<Staff> getStaffs() {
		return Staffs;
	}

	/*
	 * Interface itf = new Interface();
	 * 
	 * ArrayList<Professor> professors = new ArrayList<Professor>();
	 * 
	 * public ArrayList<Professor> getProfessors() { return professors; }
	 */

	public void staffManMenu() {
        Scanner key = new Scanner(System.in);
        //display menu for staff class
        while (true) {
     	   	  System.out.println("Staff Menu:");
               System.out.println("1 - Add\n" + "2 - Delete\n" + "3 - Edit\n" + "4 - Display\n" + "5 - Return to Main Menu");
               String menuOption = key.nextLine();
               if (menuOption.equals("1"))
                     addStaff();
               else if (menuOption.equals("2"))
                     deleteStaff();
               else if (menuOption.equals("3"))
                     editStaff();
               else if (menuOption.equals("4"))
                     displayStaff();
               else if (menuOption.equals("5"))
                     break;
               else
             	  System.out.println("Not a valid menu option.");
        }


	}

	public void addStaff() {
        Scanner key = new Scanner(System.in);
        String fn, ln, dob, id, dept;
        boolean valid;
        //get first name
        while(true) {
     	   System.out.print("Staff's first name (ex: John): ");
     	   fn = key.nextLine().strip();
     	   valid = validString(fn);
     	   if(valid)
     		   break;
        }
        //get last name
        while(true) {
     	   System.out.print("Staff's last name (ex: Doe): ");
     	   ln = key.nextLine().strip();
     	   valid = validString(ln);
     	   if(valid)
     		   break;
        }
        //get date of birth
        while(true) {
     	   System.out.print("Staff's date of birth (ex: 01/01/75): ");
     	   SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
     	   dob = key.nextLine().strip();
     	   format.setLenient(false);
			try {
				format.parse(dob);
				break;
			}
			catch(ParseException e) {
				System.out.println(dob + " is not a valid pattern according to " + format.toPattern());}
        }
        //get university id
        while(true) {
     	   System.out.print("Staff's University ID (ex: 0000001): ");
     	   id = key.nextLine().strip();
     	   valid = validID(id);
     	   if(valid)
     		   break;
        }
        //get department
        while(true) {
     	   System.out.print("Staff's Department (ex: Housing): ");
     	   dept = key.nextLine().strip();
     	   valid = validString(dept);
     	   if(valid)
     		   break;
        }
        //check if staff is an administrator, if yes, then modify department
        while(true) {
     	   System.out.println("Is " + fn + " " + ln + " an admin? \n1 - Yes\n2 - No");
     	   String admin = key.nextLine();
     	   if(admin.equals("1")) {
     		   dept += " - ADMIN";
     	   		break;}
     	   else if(admin.equals("2")) {
     		   dept += "";
     	   		break;}
     	   else
     		   System.out.print("Not a valid menu option. Try again.");
        }
        //add new staff member to the list
        Staffs.add(new Staff(fn, ln, dob, id, dept));
        System.out.println("You added " + fn + " " + ln + " to the Staffs list.");
 }

	public void deleteStaff() {
        Scanner key = new Scanner(System.in);
       //get id of the staff member you want to delete
        System.out.print("Enter the University ID of the Staff you would like to delete: ");
        String id = key.nextLine();
        int index = searchStaff(id);
        if (index > -1) {
     	   //delete the staff member
               Staffs.remove(index);
               System.out.println("You successfully deleted the Staff with the id " + id);
        } else {
               System.out.println("The Staff you are looking for does not exist.");
        }
	}

	public void editStaff() {
        Scanner key = new Scanner(System.in);
        //get the id of the staff member you want to edit
        System.out.print("Enter the University ID of the Staff you would like to edit: ");
        String id = key.nextLine();
        int index = searchStaff(id);
        String fn, ln, dob, newID, dept;
        boolean valid;
        if (index > -1) {
               Staffs.set(index, null);
               //get new first name
               while(true) {
             	  System.out.print("Enter new first name (ex: John): ");
             	  fn = key.nextLine().strip();
             	  valid = validString(fn);
             	  if(valid)
             		  break;
               }
               //get new last name
               while(true) {
             	  System.out.print("Enter new last name (ex: Doe): ");
             	  ln = key.nextLine();
             	  valid = validString(ln);
             	  if(valid)
             		  break;
               }
               //get new date of birth
               while(true) {
             	  System.out.println("Enter new date of birth (ex: 01/01/75): ");
             	  SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
             	  dob = key.nextLine().strip();
             	  format.setLenient(false);
             	  try {
             		  format.parse(dob);
             		  break;
             	  }
             	  catch(ParseException e) {
             		  System.out.println(dob + " is not a valid pattern according to " + format.toPattern());}
               }
               //get new university id
               while(true) {
             	  System.out.println("Enter new ID number (ex: 0000001): ");
             	  newID = key.nextLine().strip();
             	  valid = validID(newID);
             	  if(valid) 
             		  break;
               }
               //get new department
               while(true) {
             	  System.out.println("Enter new department (ex: Housing): ");
             	  dept = key.nextLine();
             	  valid = validString(dept);
             	  if(valid)
             		  break;
               }
               //check if admin, if yes, modify department
               while(true) {
             	  System.out.println("Is " + fn + " " + ln + " an admin? \n 1 - Yes\n2 - No");
             	  String admin = key.nextLine();
             	  if(admin.equals("1")) {
             		  dept += " - ADMIN";
            	   		break;}
             	  else if(admin.equals("2")) {
             		  dept += "";
             		  break;}
             	  else
             		  System.out.print("Not a valid menu option. Try again.");
               }
               //set new staff member to the index of the old staff member
               Staffs.set(index, new Staff(fn, ln, dob, newID, dept));
 }
	}

	public void displayStaff() {
        Scanner key = new Scanner(System.in);
        System.out.println("Display Menu:\n" + "1 - Display all Staffs\n" + "2 - Display a given Staff");
        String n = key.nextLine();
        //display all staff members
        if (n.equals("1")) {
               for (Staff p : Staffs) {
                     System.out.println("First Name: " + p.getFName());
                     System.out.println("Last Name: " + p.getLName());
                     System.out.println("Date of Birth: " + p.getDOB());
                     System.out.println("University ID: " + p.getUnivID());
                     System.out.println("Department: " + p.getDept());
                     System.out.println("\n");
               }
        }
        //display one staff member based on their id
        else if (n.equals("2")) {
               System.out.print("Enter the University ID of the Staff you want to display: ");
               String id = key.nextLine();
               int index = searchStaff(id);
               if (index > -1) {
                     Staff p = Staffs.get(index);
                     System.out.println("First Name: " + p.getFName());
                     System.out.println("Last Name: " + p.getLName());
                     System.out.println("Date of Birth: " + p.getDOB());
                     System.out.println("University ID: " + p.getUnivID());
                     System.out.println("Department: " + p.getDept());
                     System.out.println("\n");
               }
        }
        else
     	   System.out.println("Not a valid menu option. Please try again.");
 }

	public int searchStaff(String id) {
		for (int i = 0; i < Staffs.size(); i++) {
			if (Staffs.get(i).getUnivID().equals(id))
				return i;
		}
		return -1;
	}
	  public boolean validString(String n) {
			if(n.isEmpty()) 
				return false;
			else
				return true;
		}
	    //check if id is seven numbers
	    public boolean validID(String id) {
	    	boolean v = false;
	    	boolean valid = validString(id);
			if(valid) {
				int length = id.length();
				if(length == 7) {
					boolean check = true;
					for(int i=0; i<7; i++) {
						boolean digit = Character.isDigit(id.charAt(i));
						if(digit == false)
							check = false;
					}
					if(check)
						v = true;
					else
						System.out.print("The id you entered is not in proper format. Try again. ");
				}
			}
	    	return v;
	    }
}
