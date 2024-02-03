package TA;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;

import mainInterface.Interface;

public class TAManager {
	
	//Interface itf = new Interface();
	
	ArrayList<TA> TAs = new ArrayList<TA>();
	
	public ArrayList<TA> getTAs() {
		return TAs;
	}
	
	/*Interface itf = new Interface();
	
	ArrayList<Professor> professors = new ArrayList<Professor>();
	
	public ArrayList<Professor> getProfessors() {
		return professors;
	}*/

    public void taManMenu() {
    	 Scanner key = new Scanner(System.in);
         //display menu for the ta class
         while (true) {
      	   	  System.out.println("TA Menu:");
                System.out.println("1 - Add\n" + "2 - Delete\n" + "3 - Edit\n" + "4 - Display\n" + "5 - Return to Main Menu");
                String menuOption = key.nextLine();
                if (menuOption.equals("1"))
                      addTA();
                else if (menuOption.equals("2"))
                      deleteTA();
                else if (menuOption.equals("3"))
                      editTA();
                else if (menuOption.equals("4"))
                      displayTA();
                else if (menuOption.equals("5"))
                      break;
                else
              	  System.out.println("Not a valid menu option. Please try again.");
         }
     
  }
 
 public void addTA() {
     Scanner key = new Scanner(System.in);
     String fn, ln, dob, id, dept, course;
     boolean valid;
     //get first name
     while(true) {
  	   System.out.print("TA's first name (ex: John): ");
  	   fn = key.nextLine().strip();
  	   valid = validString(fn);
  	   if(valid)
  		   break;
     }
     //get last name
     while(true) {
  	   System.out.print("TA's last name (ex: Doe): ");
  	   ln = key.nextLine().strip();
  	   valid = validString(ln);
  	   if(valid)
  		   break;
     }
     //get date of birth
     while(true) {
  	   System.out.print("TA's date of birth (ex: 01/01/98): ");
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
  	   System.out.print("TA's University ID (ex: 0000001): ");
  	   id = key.nextLine().strip();
  	   valid = validID(id);
  	   if(valid) 
  		   break;
     }
     //get department
     while(true) {
  	   System.out.print("TA's department (ex: Math): ");
  	   dept = key.nextLine().strip();
  	   valid = validString(dept);
  	   if(valid)
  		   break;
     }
     //check if ta is admin, if yes, modify the department
     while(true) {
  	   System.out.println("Is " + fn + " " + ln + " an admin? \n1 - Yes\n2 - No");
  	   String admin = key.nextLine();
  	   if(admin.equals("1")) {
  		   dept += " - ADMIN";
  	   		break;}
  	   else if(admin.equals("1")) {
  		   dept += "";
  	   		break;}
  	   else
  		   System.out.print("Not a valid menu option. Try again.");
     }
     String cN;
     int cNum;
      ArrayList<String> cTaught = new ArrayList<String>();
     int count = 0;
     //add courses to the courses assisted list
     while (true) {
            System.out.println("\nCourses Assisted Menu:\n" + "1 - add courses \n" + "2 - finish adding courses");
            String menuOpt = key.nextLine();
            if (menuOpt.equals("1")) {
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
                  for (int i = 0; i < cNum; i++) {
                  	while(true) {
                         System.out.print("Enter a course (ex: CSCI360): ");
                         course = key.nextLine().strip();
                         valid = validCourse(course);
                         if(valid)
                      	   break;
                      }
                         cTaught.add(course);
                        // count++;
                  }
            } 
            else if (menuOpt.equals("2")) {
                  break;
            }
            else
          	  System.out.println("Not a valid menu option. Please try again.");
     }
     //add courses to the courses assisting list
      ArrayList<String> cTeaching = new ArrayList<String>();
     count = 0;
     while (true) {
            System.out.println("\nCourses Assisting Menu:\n" + "1 - add course \n" + "2 - finish adding courses");
            String menuOpt = key.nextLine();
            if (menuOpt.equals("1")) {
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
                  for (int i = 0; i < cNum; i++) {
                  	while(true) {
                         System.out.print("Enter a Course (ex: CSCI360): ");
                         course = key.nextLine().strip();
                         valid = validCourse(course);
                         if(valid)
                      	   break;
                         }
                         cTeaching.add(course);
                         count++;
                  }
            } 
            else if (menuOpt.equals("2")) {
                  break;
            }
            else
          	  System.out.println("Not a valid menu option. Please try again.");
     }
     //add new ta to the ta array list
     TAs.add(new TA(fn, ln, dob, id, dept, cTaught, cTeaching));
     System.out.println("You added " + fn + " " + ln + " to the TAs list.");
}

 public void deleteTA() {
     Scanner key = new Scanner(System.in);
     //get id of the ta you want to delete
     System.out.print("Enter the University ID of the TA you would like to delete: ");
     String id = key.nextLine();
     int index = searchTA(id);
     if (index > -1) {
            //remove ta
  	   	  TAs.remove(index);
            System.out.println("You successfully deleted the TA with the id " + id);
     } 
     else {
            System.out.println("The TA you are looking for does not exist.");
     }
}

 public void editTA() {
     Scanner key = new Scanner(System.in);
     //get id of the ta you want to edit
     System.out.print("Enter the University ID of the TA you would like to edit: ");
     String id = key.nextLine();
     int index = searchTA(id);
     if (index > -1) {
            TAs.set(index, null);
            String fn, ln, dob, newID, dept, course;
            boolean valid;
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
         	   ln = key.nextLine().strip();
         	   valid = validString(ln);
         	   if(valid)
         		   break;
            }
            //get new date of birth
            while(true) {
         	   System.out.print("Enter new date of birth (ex: 01/01/98): ");
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
         	   System.out.print("Enter new University ID (ex: 0000001): ");
         	   newID = key.nextLine().strip();
         	   valid = validID(newID);
         	   if(valid) 
         		   break;
            }
            //get new department
            while(true) {
         	   System.out.print("Enter new department (ex: Math): ");
         	   dept = key.nextLine().strip();
         	   valid = validString(dept);
         	   if(valid)
         		   break;
            }
            //check if admin, if yes, modify the department
            while(true) {
         	   System.out.println("Is " + fn + " " + ln + " an admin? \n1 - Yes\n2 - No");
         	   String admin = key.nextLine();
         	   if(admin.equals("1")) {
         		   dept += " - ADMIN";
         	   		break;}
         	   else if(admin.equals("1")) {
         		   dept += "";
         	   		break;}
         	   else
         		   System.out.print("Not a valid menu option. Try again.");
            }
            ArrayList<String> cTaught = new ArrayList<String>();
            int count = 0;
           String cN;
           int cNum;
           //add new courses to the course assisted list
            while (true) {
                   System.out.println("\nCourses Assisted Menu:\n" + "1 - add courses \n" + "2 - finish adding courses");
                   String menuOpt = key.nextLine();
                   if (menuOpt.equals("1")) {
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
                         for (int i = 0; i < cNum; i++) {
                         	while(true) {
                                System.out.print("Enter a course (ex: CSCI360): ");
                                course = key.nextLine().strip();
                                valid = validCourse(course);
                                if(valid)
                             	   break;
                             }
                                cTaught.add(course);
                                count++;
                         }
                   } 
                   else if (menuOpt.equals("2")) {
                         break;
                   }
                   else
                 	  System.out.println("Not a valid menu option. Please try again.");
            }
            ArrayList<String> cTeaching = new ArrayList<String>();
            count = 0;
            //add new courses to the courses assisting list
            while (true) {
                   System.out.println("\nCourses Assisting Menu:\n" + "1 - add course \n" + "2 - finish adding courses");
                   String menuOpt = key.nextLine();
                   if (menuOpt.equals("1")) {
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
                         for (int i = 0; i < cNum; i++) {
                         	while(true) {
                                System.out.print("Enter a Course (ex: CSCI360): ");
                                course = key.nextLine().strip();
                                valid = validCourse(course);
                                if(valid)
                             	   break;
                                }
                                cTeaching.add(course);
                                count++;
                         }
                   } 
                   else if (menuOpt.equals("2")) {
                         break;
                   }
                   else
                 	  System.out.println("Not a valid menu option. Please try again.");
            }
            //add new ta to the index of the old ta
            TAs.set(index, new TA(fn, ln, dob, newID, dept, cTaught, cTeaching));
     }
}

 public void displayTA() {
     Scanner key = new Scanner(System.in);
     System.out.println("Display Menu:\n" + "1 - Display all TAs\n" + "2 - Display a given TA");
     String n = key.nextLine();
     //display all tas
     if (n.equals("1")) {
            for (TA p : TAs) {
                  System.out.println("First Name: " + p.getFName());
                  System.out.println("Last Name: " + p.getLName());
                  System.out.println("Date of Birth: " + p.getDOB());
                  System.out.println("University ID: " + p.getUnivID());
                  System.out.println("Semester: " + p.getDept());
                  System.out.print("Courses Assisted: ");
                  ArrayList<String> cTaught = p.getCTaught();
               for (int i = 0; i < cTaught.size(); i++) {
                      if (cTaught.get(i) != null)
                             System.out.print(cTaught.get(i) + " ");
                      else
                             break;
               }
                  System.out.println();
                  System.out.print("Courses Assisting: ");
   ArrayList<String> cTeaching = p.getCTeaching();
               for (int i = 0; i < cTeaching.size(); i++) {
                      if (cTeaching.get(i) != null)
                             System.out.print(cTeaching.get(i) + " ");
                      else
                             break;
               }
                  System.out.println("\n");
            }
     } 
     //display an existing ta based on their id
     else if (n.equals("2")) {
            System.out.print("Enter the University ID of the TA you want to display: ");
            String id = key.nextLine();
            int index = searchTA(id);
            if (index > -1) {
                  TA p = TAs.get(index);
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
                  System.out.print("Courses Assisting: ");
        ArrayList<String> cTeaching = p.getCTeaching();
               for (int i = 0; i < cTeaching.size(); i++) {
                      if (cTeaching.get(i) != null)
                             System.out.print(cTeaching.get(i) + " ");
                      else
                             break;
               }
               
                  System.out.println("\n");
            }
     }
     else
  	   System.out.println("Not a valid menu option. Please try again.");
}

 public int searchTA(String id) {
        for (int i = 0; i < TAs.size(); i++) {
               if (TAs.get(i).getUnivID().equals(id))
                     return i;
        }
        return -1;
 }
 //check is string is empty
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