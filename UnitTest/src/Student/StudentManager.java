package Student;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import mainInterface.Interface;
import java.io.*;

public class StudentManager {

	ArrayList<Student> students = new ArrayList<Student>();

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void studManMenu() {
		Scanner key = new Scanner(System.in);
        while (true) {
     	  
               System.out.println("Student Menu:");
               System.out.println("1 - Add\n" + "2 - Delete\n" + "3 - Edit\n" + "4 - Display\n" + "5 - Return to Main Menu");
               String menuOption = key.nextLine();
               if (menuOption.equals("1"))
                     addStudent();
               else if (menuOption.equals("2"))
                     deleteStudent();
               else if (menuOption.equals("3"))
                     editStudent();
               else if (menuOption.equals("4"))
                     displayStudent();
               else if (menuOption.equals("5"))
                     break;
               else
             	  System.out.println("Not a valid menu option. Please try again.");
        }

 }

	public void addStudent() {
        Scanner key = new Scanner(System.in);
        boolean valid;
        String fn, ln, dob, id;
        //get first name
        while(true) {
     	   System.out.print("Student's first name (ex: John): ");
     	   fn = key.nextLine().strip();
     	   valid = validString(fn);
     	   if(valid)
     		  break;
        }
        //get last name
        while(true) {
     	   System.out.print("Student's last name (ex: Doe): ");
     	   ln = key.nextLine().strip();
     	   valid = validString(ln);
     	   if(valid)
     		   break;
        }
        //get date of birth
        while(true) {
     	   System.out.print("Student's date of birth (ex: 01/01/01): ");
     	   dob = key.nextLine().strip();
     	   SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
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
     	   System.out.print("Student's University ID (ex: 0000001): ");
     	   id = key.nextLine().strip();
     	   valid = validID(id);
     	   if(valid)
     		   break;
        }
        int count = 0;
        ArrayList<String> semester = new ArrayList<String>();
        String sem;
        ArrayList<String> courses = new ArrayList<String>();
        String course;
        String cNum;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        for(int i=0; i<grades.size(); i++) {
     	   grades.add(i);
        }
        int grade;
        ArrayList<String> lgrades = new ArrayList<String>();
        String lgrade;
        count = 0;
        //get number of grades the user wants to add
        while(true) {
				try {
					System.out.print("How many grades do you want to add? ");
					cNum =key.nextLine();
					count = Integer.parseInt(cNum);
					break;
				}
				catch(NumberFormatException e) {
					System.out.println("Please enter an integer.");
				}
			}
        //get information for each grade
        for(int i=0; i<count; i++) {
     	   int num = i+1;
     	   System.out.println("Course " + num + ": ");
     	   //get semester
     	   while(true) {
     		   System.out.print("Enter the semester (ex: S22 for Spring '22, F21 for Fall '21): ");
     		   sem = key.nextLine();
     		   valid = validSem(sem);
     		   if(valid)
     			   break;
     	   }
     	   semester.add(sem);
     	   //get course
     	   while(true) {
     		   System.out.print("Enter the course (ex: CSCI360): ");
     		   course = key.nextLine();
     		   valid = validCourse(course);
     		   if(valid)
     			   break;
     	   }
     	   courses.add(course);
     	   //get grade
     	   while(true) {
     		   System.out.print("Enter number grade for the course (ex: 72): ");
     		   grade = key.nextInt();key.nextLine();
     		   int length = (int)(Math.log10(grade)+1);
     		   if(length < 4 && length > 0)
     			   break;
     		   else
     			   System.out.print("Format of the grade you entered is incorrect. ");
     	   }
     	   grades.add(grade);
     	   //get the letter grade
     	   lgrade = calcLGrade(grade);
     	   lgrades.add(lgrade);
        }
        //add new student to the list
        students.add(new Student(fn, ln, dob, id, courses, semester, grades, lgrades));
        System.out.println("You added " + fn + " " + ln + " to the Students list.");
 }

	public void deleteStudent() {
		  Scanner key = new Scanner(System.in);
          //get the id
          System.out.print("Enter the University ID of the Student you would like to delete: ");
          String id = key.nextLine();
          int index = searchStudent(id);
          //remove the student
          if (index > -1) {
                 students.remove(index);
                 System.out.println("You successfully deleted the Student with the id " + id);
          } 
          else {
                 System.out.println("The Student you are looking for does not exist.");
          }
   }

	public void editStudent() {
        Scanner key = new Scanner(System.in);
        //get id of student you want to edit
        System.out.print("Enter the University ID of the Student you would like to edit: ");
        String id = key.nextLine();
        int index = searchStudent(id);
        String fn, ln, dob, newID;
        boolean valid;
        if (index > -1) {
               students.set(index, null);
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
            	   System.out.print("Enter new date of birth (ex: 01/01/01): ");
            	   dob = key.nextLine().strip();
            	   SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
            	   format.setLenient(false);
       				try {
       					format.parse(dob);
       					break;
       				}
       				catch(ParseException e) {
       					System.out.println(dob + " is not a valid pattern according to " + format.toPattern());}
               }
               //get new id
               while(true) {
            	   System.out.print("Enter new University ID (ex: 0000001): ");
            	   newID = key.nextLine().strip();
            	   valid = validID(newID);
            	   if(valid)
            		   break;
               }
               int count = 0;
               ArrayList<String> semester = new ArrayList<String>();
               String sem;
               ArrayList<String> courses = new ArrayList<String>();
               String course;
               ArrayList<Integer> grades = new ArrayList<Integer>();
               for(int i=0; i<grades.size(); i++) {
            	   grades.add(i);
               }
               int grade;
               ArrayList<String> lgrades = new ArrayList<String>();
               String lgrade;
               count = 0;
               String cNum;
               //get new grades
               while(true) {
   				try {
   					System.out.print("How many grades do you want to add? ");
   					cNum =key.nextLine();
   					count = Integer.parseInt(cNum);
   					break;
   				}
   				catch(NumberFormatException e) {
   					System.out.println("Please enter an integer.");
   				}
   			}
               for(int i=0; i<count; i++) {
            	   int num = i+1;
            	   System.out.println("Course " + num + ": ");
            	   while(true) {
            		   System.out.print("Enter the semester (ex: S22 for Spring '22, F21 for Fall '21): ");
            		   sem = key.nextLine();
            		   valid = validSem(sem);
            		   if(valid)
            			   break;
            	   }
            	   semester.add(sem);
            	   while(true) {
            		   System.out.print("Enter the course (ex: CSCI360): ");
            		   course = key.nextLine();
            		   valid = validCourse(course);
            		   if(valid)
            			   break;
            	   }
            	   courses.add(course);
            	   while(true) {
            		   System.out.print("Enter number grade for the course (ex: 72): ");
            		   grade = key.nextInt();key.nextLine();
            		   int length = (int)(Math.log10(grade)+1);
            		   if(length < 4 && length > 0)
            			   break;
            		   else
            			   System.out.print("Format of the grade you entered is incorrect. ");
            	   }
            	   grades.add(grade);
            	   lgrade = calcLGrade(grade);
            	   lgrades.add(lgrade);
               }
               //set new professor to the index of the old professor
               students.set(index, new Student(fn, ln, dob, id, courses, semester, grades, lgrades));
        }
 }

	public void displayStudent() {
        Scanner key = new Scanner(System.in);
        System.out.println("Display Menu:\n" + "1 - Display all Students\n" + "2 - Display a given Student");
        String n = key.nextLine();
        key.nextLine();
        //display all students
        if (n.equals("1")) {
               for (Student p : students) {
                     System.out.println("First Name: " + p.getFName());
                     System.out.println("Last Name: " + p.getLName());
                     System.out.println("Date of Birth: " + p.getDOB());
                     System.out.println("University ID: " + p.getUnivID());
                     System.out.print("Semester: ");
					ArrayList<String> sem = p.getSemester();
					for (int i = 0; i < sem.size(); i++) {
						if (sem.get(i) != null)
							System.out.print(sem.get(i) + " ");
						else
							break;
					}
                     System.out.print("\nCourses Taken: ");
					ArrayList<String> courses = p.getCourses();
					for (int i = 0; i < courses.size(); i++) {
						if (courses.get(i) != null)
							System.out.print(courses.get(i) + " ");
						else
							break;
					}
                     System.out.println();
                     System.out.print("Courses Number Grade: ");
  					ArrayList<Integer> nGrades = p.getNGrades();
					for (int i = 0; i < nGrades.size(); i++) {
						if (nGrades.get(i) != -1)
							System.out.print(nGrades.get(i) + " ");
						else
							break;
					}
                     System.out.println();
                     System.out.print("Courses Letter Grade: ");
					ArrayList<String> lGrades = p.getLGrades();
					for (int i = 0; i < lGrades.size(); i++) {
						if (lGrades.get(i) != null)
							System.out.print(lGrades.get(i) + " ");
						else
							break;
					}
                     System.out.println("\n");
               }
        } 
        //get id of student you want to display
        else if (n.equals("2")) {
               System.out.print("Enter the University ID of the Student you want to display: ");
               String id = key.nextLine();
               int index = searchStudent(id);
               if (index > -1) {
                     Student p = students.get(index);
                     System.out.println("First Name: " + p.getFName());
                     System.out.println("Last Name: " + p.getLName());
                     System.out.println("Date of Birth: " + p.getDOB());
                     System.out.println("University ID: " + p.getUnivID());
                     System.out.print("Semester: ");
 				ArrayList<String> sem = p.getSemester();
					for (int i = 0; i < sem.size(); i++) {
						if (sem.get(i) != null)
							System.out.print(sem.get(i) + " ");
						else
							break;
					}
                     System.out.print("\nCourses Taken: ");
				ArrayList<String> courses = p.getCourses();
					for (int i = 0; i < courses.size(); i++) {
						if (courses.get(i) != null)
							System.out.print(courses.get(i) + " ");
						else
							break;
					}
                     System.out.println();
                     System.out.print("Courses Number Grade: ");
			ArrayList<Integer> nGrades = p.getNGrades();
					for (int i = 0; i < nGrades.size(); i++) {
						if (nGrades.get(i) != -1)
							System.out.print(nGrades.get(i) + " ");
						else
							break;
					}
                     System.out.println();
                     System.out.print("Courses Letter Grade: ");
					ArrayList<String> lGrades = p.getLGrades();
					for (int i = 0; i < lGrades.size(); i++) {
						if (lGrades.get(i) != null)
							System.out.print(lGrades.get(i) + " ");
						else
							break;
					}
                     System.out.println("\n");
               } else
                     System.out.println("The Student you are trying to display does not exist.");
        }
        else
     	   System.out.println("Not a valid menu option. Please try again.");
 }

	public int searchStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getUnivID().equals(id))
				return i;
		}
		return -1;
	}

	public String calcLGrade(int g) {
		String lgrade = "";
		if (g >= 90)
			lgrade = "A";
		else if (g >= 80)
			lgrade = "B";
		else if (g >= 70)
			lgrade = "C";
		else if (g >= 60)
			lgrade = "D";
		else
			lgrade = "F";
		return lgrade;

	}
	
	public boolean validString(String n) {
		if(n.isEmpty()) 
			return false;
		else
			return true;
	}
    //check if the id is seven numbers
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
    //check if the semester is in the proper format
    public boolean validSem(String sem) {
    	boolean v = false;
    	boolean valid = validString(sem);
		   if(valid) {
			   int length = sem.length();
			   if(length == 3) {
				   boolean check = true;
				   char letter = sem.charAt(0);
				   if(letter == 'F' || letter == 'S') {
					   for(int j=1; j<3; j++) {
						   boolean digit = Character.isDigit(sem.charAt(j));
							if(digit == false) 
								check = false;
					   }
					   if(check == true)
						   v = true;
					   else
						   System.out.print("The semester you entered is not the proper format. ");
				   }
				   else
					   System.out.print("The semester you entered is not the proper format. ");
			   }
			   else
				   System.out.print("The semester you entered is not the proper format. ");
		   }
		   else
			   System.out.print("The semester you entered is not the proper format. ");
		   return v;
    }
    //check if course is in proper format
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