package Professor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

import mainInterface.Interface;

//IOException, so add the io.file to all error files and then that should fix it all

public class ProfessorManager {

	ArrayList<Professor> professors = new ArrayList<Professor>();

	public ArrayList<Professor> getProfessors() {
		return professors;
	}

	public void profManMenu() {
		Scanner key = new Scanner(System.in);
		while(true) {
			System.out.println("Professor Menu:");
			System.out.println("1 - Add\n"
					+ "2 - Delete\n"
					+ "3 - Edit\n"
					+ "4 - Display\n"
					+ "5 - Return to Main Menu");
			String menuOption = key.nextLine();
			if(menuOption.equals("1"))
				addProfessor();
			else if(menuOption.equals("2"))
				deleteProfessor();
			else if(menuOption.equals("3"))
				editProfessor();
			else if(menuOption.equals("4"))
				displayProfessor();
			else if(menuOption.equals("5"))
				//go to University main menu
				break;
			else {
				System.out.println("Not a valid option. Please enter the number that corresponds to the menu you are trying to access.");
			}
		}
		//Interface in = new Interface();
		//in.mainMenu();
	}

	public void addProfessor() {
		Scanner key = new Scanner(System.in);
		String fn, ln, dob, dept, id, course;
		boolean valid;
		//get first name
		while(true) {
			System.out.print("Professor's first name (ex: John): ");
			fn = key.nextLine().strip();
			valid = validString(fn);
			if(valid)
				break;
		}
		//get last name
		while(true) {
			System.out.print("Professor's last name (ex: Doe): ");
			ln = key.nextLine().strip();
			valid = validString(ln);
			if(valid)
				break;
		}
		//get date of birth
		while(true) {
			System.out.print("Professor's date of birth (ex: 01/01/75): ");
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
			System.out.print("Professor's University ID (ex: 0000001): ");
			id = key.nextLine().strip();
			valid = validID(id);
			if(valid)
				break;
		}
		//get department
		while(true) {
			System.out.print("Professor's department (ex: English): ");
			dept = key.nextLine().strip();
			valid = validString(dept);
			if(valid)
				break;
		}
		//check if administrator, if yes, modify department
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

		ArrayList<String> cTaught = new ArrayList<String>();
		String cN;
		int cNum;
		int count = 0;
		//add courses to the courses taught list
		while(true) {
			System.out.println("Courses Taught Menu:\n"
					+ "1 - add courses taught\n"
					+ "2 - finish adding courses");
			String menuOpt = key.nextLine();
			if(menuOpt.equals("1")) {
				while(true) {
					try {
						System.out.print("How many courses do you want to add? ");
						cN =key.nextLine();
						cNum = Integer.parseInt(cN);
						break;
					}
					catch(NumberFormatException e) {
						System.out.println("Please enter an integer.");
					}
				}
				for(int i=0; i<cNum; i++) {
					while(true) {
						System.out.print("Enter a course (ex: CSCI360): ");
						course = key.nextLine().trim();
						valid = validCourse(course);
						if(valid)
							break;
					}
					cTaught.add(course);
					//count++;
				}
			}
			else if(menuOpt.equals("2")) {
				break;
			}
			else {
				System.out.println("Not a valid menu option. Please enter a valid number.");
			}
		}
		ArrayList<String> cTeaching = new ArrayList<String>();
		count = 0;
		//add courses to the courses teaching list
		while(true) {
			System.out.println("Courses Teaching Menu:\n"
					+ "1 - add course teaching\n"
					+ "2 - finish adding courses");
			String menuOpt = key.nextLine();
			if(menuOpt.equals("1")) {
				while(true) {
					try {
						System.out.print("How many courses do you want to add? ");
						cN =key.nextLine();
						cNum = Integer.parseInt(cN);
						break;
					}
					catch(NumberFormatException e) {
						System.out.println("Please enter an integer.");
					}
				}
				for(int i=0; i<cNum; i++) {
					while(true) {
						System.out.print("Enter a course (ex: CSCI360): ");
						course = key.nextLine().trim();
						valid = validCourse(course);
						if(valid)
							break;
					}
					cTeaching.add(course);
					//count++;
				}
			}
			else if(menuOpt.equals("2")) {
				break;
			}
			else {
				System.out.println("Not a valid option. Please try again.");
			}
		}
		ArrayList<String> tas = new ArrayList<String>();
		String ta;
		count = 0;
		//add tas to the ta array list
		while(true) {
			System.out.println("TAs Menu:\n"
					+ "1 - add a TA\n"
					+ "2 - finish adding TAs");
			String menuOpt = key.nextLine();
			if(menuOpt.equals("1")) {
				while(true) {
					try {
						System.out.print("How many TAs do you want to add? ");
						cN =key.nextLine();
						cNum = Integer.parseInt(cN);
						break;
					}
					catch(NumberFormatException e) {
						System.out.println("Please enter an integer.");
					}
				}
				for(int i=0; i<cNum; i++) {
					while(true) {
						System.out.print("Enter a TA (ex: John Doe): ");
						ta = key.nextLine().trim();
						valid = validString(ta);
						if(valid)
							break;
					}
					tas.add(ta);
					//count++;
				}
			}
			else if(menuOpt.equals("2")) {
				break;
			}
			else {
				System.out.println("Not a valid menu option. Please try again.");
			}
		}
		professors.add(new Professor(fn, ln, dob, id, dept, cTaught, cTeaching, tas));
		System.out.println("You added " + fn + " " + ln + " to the Professors list.");
	}

	public void deleteProfessor() {
		Scanner key = new Scanner(System.in);
		//get the id number of the professor to be deleted
		System.out.print("Enter the University ID of the professor you would like to delete: ");
		String id = key.nextLine().strip();
		int index = searchProfessor(id);
		if(index > -1) {
			//remove professor from the list
			professors.remove(index);
			System.out.println("You successfully deleted the professor with the id " + id);
		}
		else {
			System.out.println("The professor you are looking for does not exist.");
		}
	}

	public void editProfessor() {
		//get the id of the professor you want to edit
		Scanner key = new Scanner(System.in);
        System.out.print("Enter the University ID of the professor you would like to edit: ");
        String id = key.nextLine().strip();
        int index = searchProfessor(id);
        if(index>-1) {
        	//get new information
        	professors.set(index, null);
        	String fn, ln, dob, dept, newID, course;
    		boolean valid;
    		//get first name
    		while(true) {
    			System.out.print("Enter new first name (ex: John): ");
    			fn = key.nextLine().strip();
    			valid = validString(fn);
    			if(valid)
    				break;
    		}
    		//get last name
    		while(true) {
    			System.out.print("Enter new last name (ex: Doe): ");
    			ln = key.nextLine().strip();
    			valid = validString(ln);
    			if(valid)
    				break;
    		}
    		//get date of birth
    		while(true) {
    			System.out.print("Enter new date of birth (ex: 01/01/75): ");
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
    		//get id
    		while(true) {
    			System.out.print("Enter new University ID (ex: 0000001): ");
    			newID = key.nextLine().strip();
    			valid = validID(newID);
    			if(valid)
    				break;
    		}
    		//get department
    		while(true) {
    			System.out.print("Enter new department (ex: English): ");
    			dept = key.nextLine().strip();
    			valid = validString(dept);
    			if(valid)
    				break;
    		}
    		//check if they are an administrator, if yes, modify the department
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
			ArrayList<String> cTaught = new ArrayList<String>();
	   		String cN;
				int cNum;
	    		int count = 0;
	    		//add courses to the courses taught list
	    		while(true) {
	    			System.out.println("Courses Taught Menu:\n"
	    					+ "1 - add courses taught\n"
	    					+ "2 - finish adding courses");
	    			String menuOpt = key.nextLine();
	    			if(menuOpt.equals("1")) {
	    				while(true) {
	    					try {
	    						System.out.print("How many courses do you want to add? ");
	    						cN =key.nextLine();
	    						cNum = Integer.parseInt(cN);
	    						break;
	    					}
	    					catch(NumberFormatException e) {
	    						System.out.println("Please enter an integer.");
	    					}
	    				}
	    				for(int i=0; i<cNum; i++) {
	    					while(true) {
	    						System.out.print("Enter a course (ex: CSCI360): ");
	    						course = key.nextLine().trim();
	    						valid = validCourse(course);
	    						if(valid)
	    							break;
	    					}
	    					cTaught.add(course);
	    					//count++;
	    				}
	    			}
	    			else if(menuOpt.equals("2")) {
	    				break;
	    			}
	    			else {
	    				System.out.println("Not a valid menu option. Please enter a valid number.");
	    			}
	    		}
			ArrayList<String> cTeaching = new ArrayList<String>();
	 		count = 0;
    		while(true) {
    			System.out.println("Courses Teaching Menu:\n"
    					+ "1 - add course teaching\n"
    					+ "2 - finish adding courses");
    			String menuOpt = key.nextLine();
    			if(menuOpt.equals("1")) {
    				while(true) {
    					try {
    						System.out.print("How many courses do you want to add? ");
    						cN =key.nextLine();
    						cNum = Integer.parseInt(cN);
    						break;
    					}
    					catch(NumberFormatException e) {
    						System.out.println("Please enter an integer.");
    					}
    				}
    				for(int i=0; i<cNum; i++) {
    					while(true) {
    						System.out.print("Enter a course (ex: CSCI360): ");
    						course = key.nextLine().trim();
    						valid = validCourse(course);
    						if(valid)
    							break;
    					}
    					cTeaching.add(course);
    					//count++;
    				}
    			}
    			else if(menuOpt.equals("2")) {
    				break;
    			}
    			else {
    				System.out.println("Not a valid option. Please try again.");
    			}
    		}
			ArrayList<String> tas = new ArrayList<String>();
    		String ta;
    		count = 0;
    		while(true) {
    			System.out.println("TAs Menu:\n"
    					+ "1 - add a TA\n"
    					+ "2 - finish adding TAs");
    			String menuOpt = key.nextLine();
    			if(menuOpt.equals("1")) {
    				while(true) {
    					try {
    						System.out.print("How many TAs do you want to add? ");
    						cN =key.nextLine();
    						cNum = Integer.parseInt(cN);
    						break;
    					}
    					catch(NumberFormatException e) {
    						System.out.println("Please enter an integer.");
    					}
    				}
    				for(int i=0; i<cNum; i++) {
    					while(true) {
    						System.out.print("Enter a TA (ex: John Doe): ");
    						ta = key.nextLine().trim();
    						valid = validString(ta);
    						if(valid)
    							break;
    					}
    					tas.add(ta);
    					//count++;
    				}
    			}
    			else if(menuOpt.equals("2")) {
    				break;
    			}
    			else {
    				System.out.println("Not a valid menu option. Please try again.");
    			}
    		}
			professors.set(index, new Professor(fn, ln, dob, newID, dept, cTaught, cTeaching, tas));
		}
	}

	public void displayProfessor() {
		Scanner key = new Scanner(System.in);
		System.out.println("Display Menu:\n"
				+ "1 - Display all Professors\n"
				+ "2 - Display a given Professor");
		String n = key.nextLine();
		//display all professors
		if(n.equals("1")) {
			for(Professor p: professors) {
				System.out.println("First Name: " + p.getFName());
				System.out.println("Last Name: " + p.getLName());
				System.out.println("Date of Birth: " + p.getDOB());
				System.out.println("University ID: " + p.getUnivID());
				System.out.println("Department: " + p.getDept());
				System.out.print("Courses Taught: ");
	ArrayList<String> cTaught = p.getCTaught();
					for (int i = 0; i < cTaught.size(); i++) {
						if (cTaught.get(i) != null)
							System.out.print(cTaught.get(i) + " ");
						else
							break;
					}
				System.out.println();
				System.out.print("Courses Teaching: ");
	ArrayList<String> cTeaching = p.getCTeaching();
					for (int i = 0; i < cTeaching.size(); i++) {
						if (cTeaching.get(i) != null)
							System.out.print(cTeaching.get(i) + " ");
						else
							break;
					}
				System.out.println();
				System.out.print("TAs: ");
	ArrayList<String> tas = p.getTAs();
					for (int i = 0; i < tas.size(); i++) {
						if (tas.get(i) != null)
							System.out.print(tas.get(i) + " ");
						else
							break;
					}
				System.out.println("\n");
			}
		}
		//get the id of a professor, and display them
		else if(n.equals("2")) {
			System.out.print("Enter the University ID of the professor you want to display: ");
			String id = key.nextLine().strip();
			int index = searchProfessor(id);
			if(index > -1) {
				Professor p = professors.get(index);
				System.out.println("First Name: " + p.getFName());
				System.out.println("Last Name: " + p.getLName());
				System.out.println("Date of Birth: " + p.getDOB());
				System.out.println("University ID: " + p.getUnivID());
				System.out.println("Department: " + p.getDept());
				System.out.print("Courses Taught: ");
				ArrayList<String> cTaught = p.getCTaught();
					for (int i = 0; i < cTaught.size(); i++) {
						if (cTaught.get(i) != null)
							System.out.print(cTaught.get(i) + " ");
						else
							break;
					}
				System.out.println();
				System.out.print("Courses Teaching: ");
				ArrayList<String> cTeaching = p.getCTeaching();
					for (int i = 0; i < cTeaching.size(); i++) {
						if (cTeaching.get(i) != null)
							System.out.print(cTeaching.get(i) + " ");
						else
							break;
					}
				System.out.println();
				System.out.print("TAs: ");
					ArrayList<String> tas = p.getTAs();
					for (int i = 0; i < tas.size(); i++) {
						if (tas.get(i) != null)
							System.out.print(tas.get(i) + " ");
						else
							break;
					}
				System.out.println("\n");
			}
			else
				System.out.println("The professor you are trying to display does not exist.");
		}
		else {
			System.out.println("Not a valid menu option. Please try again.");
		}
	}

	public int searchProfessor(String id) {
		for (int i = 0; i < professors.size(); i++) {
			if (professors.get(i).getUnivID().equals(id))
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
	//check if ID is seven numbers
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
	//check if course is in the proper format
	public boolean validCourse(String course) {
		boolean v = false;
		boolean valid = validString(course);
		if(valid) {
			int length = course.length();
			if(length == 7) {
				boolean check1 = true;
				boolean check2 = true;
				int j=0;
				for(j=0; j<4; j++) {
					boolean digit = Character.isDigit(course.charAt(j));
					if(digit == true) 
						check1 = false;
				}
				for(j=4; j<length; j++) {
					boolean digit = Character.isDigit(course.charAt(j));
					if(digit == false)
						check2 = false;
				}
				if(check1 == true && check2 == true)
					v = true;
				else 
					System.out.print("You did not enter the proper format. ");	
			}
			else 
				System.out.print("You did not enter the proper format. ");	
		}
		else 
			System.out.print("You did not enter the proper format. ");	
		
		return v;
	}
}