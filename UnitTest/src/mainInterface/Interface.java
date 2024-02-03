package mainInterface; //soon as I run it, the code wipes out info.
import java.util.Scanner;

import Professor.*;
import Staff.*;
import Student.*;
import TA.*;
import java.io.*;
import java.util.*;

public class Interface {

       public void mainMenu() throws IOException  {
              
              ProfessorManager pfm = new ProfessorManager();
              //this is the place to convert objects from files into "lists" //professor lists, TA lists.
              
              // read Dates file using Scanner
           Scanner input = new Scanner( new File("ProfessorData.txt") );
                  
           ArrayList<String> cT = new ArrayList<String>();
           ArrayList<String> cTE = new ArrayList<String>();
           ArrayList<String> tA = new ArrayList<String>();
           // read each line
           while(input.hasNext())
           {
              String FName = input.nextLine();
              String LName = input.nextLine();
              String DOB = input.nextLine();
              String UnivID = input.nextLine();
              String Dept = input.nextLine();
              
              String CTaught = input.nextLine();
              
              StringTokenizer stnizer = new StringTokenizer(CTaught, " ");
                     
              
              while(stnizer.hasMoreTokens()) { // token loop search
                     String temp = stnizer.nextToken();
                     cT.add(temp + " ");
              }
              
              
              String CTeaching = input.nextLine();
              
              stnizer = new StringTokenizer(CTeaching, " ");
              
              while(stnizer.hasMoreTokens()) { //token loop
                     String temp = stnizer.nextToken();
                     cTE.add(temp + " ");
              }
              
              String TAs = input.nextLine();
              
              stnizer = new StringTokenizer(TAs, " ");
              
              while(stnizer.hasMoreTokens()) { // token loop
                     String temp = stnizer.nextToken();
                     tA.add(temp + " ");
              }
              
              Professor tempProfessor = new Professor(FName, LName, DOB, UnivID, Dept, cT, cTE, tA); // item
              pfm.getProfessors().add(tempProfessor);
              
              
       }
           input.close();
              PrintWriter write = new PrintWriter(new FileWriter("ProfessorData.txt", false)); //creates the txt
              
              write.flush();
              
       //////////////////////////////////////////////////////////////////////////////////////
              
              StaffManager sfm = new StaffManager();
              
              Scanner input1 = new Scanner( new File("StaffData.txt") );
              

              // read each line
              while(input1.hasNext())
              {
                 String FName = input1.nextLine();
                 String LName = input1.nextLine();
                 String DOB = input1.nextLine();
                 String UnivID = input1.nextLine();
                 String Dept = input1.nextLine();
                 
                 Staff tempStaff = new Staff(FName, LName, DOB, UnivID, Dept); // items
                 sfm.getStaffs().add(tempStaff);
              }
              input1.close();
              PrintWriter write1 = new PrintWriter(new FileWriter("StaffData.txt", false )); //creates the txt
              
              write1.flush();
              ///////////////////////////////////////////////////////////////
              
              StudentManager sdm = new StudentManager();
              //this is the place to convert objects from files into "lists" //professor lists, TA lists.
              
              // read Dates file using Scanner
           Scanner input2 = new Scanner( new File("StudentData.txt") );
                  
           ArrayList<String> cO = new ArrayList<String>();
           ArrayList<String> sE = new ArrayList<String>();
           ArrayList<Integer> nG = new ArrayList<Integer>(); //array list for these are in the packages for there class
           ArrayList<String> lG = new ArrayList<String>();
           // read each line
           while(input2.hasNext())
           {
              String FName = input2.nextLine();
              String LName = input2.nextLine();
              String DOB = input2.nextLine();
              String UnivID = input2.nextLine();
              
              
              String Courses = input2.nextLine();
              
              StringTokenizer stnizer = new StringTokenizer(Courses, " "); // token for saving a loop 
                     
              
              while(stnizer.hasMoreTokens()) { // calling the token
                     String temp = stnizer.nextToken();
                     cO.add(temp + " ");
              }
              
              
              String Semester = input2.nextLine();
              
              stnizer = new StringTokenizer(Semester, " "); // token for saving a loop 
              
              while(stnizer.hasMoreTokens()) { // calling the token
                     String temp = stnizer.nextToken();
                     sE.add(temp + " ");
              }
              
              String NGrades = input2.nextLine();

              stnizer = new StringTokenizer(NGrades, " "); // token for saving a loop 
              
              while(stnizer.hasMoreTokens()) { // calling the token
                     String temp = stnizer.nextToken();
                     nG.add(Integer.parseInt(temp));
              }
              
              String LGrades = input2.nextLine();
              
              stnizer = new StringTokenizer(LGrades, " "); // token for saving a loop 
              
              while(stnizer.hasMoreTokens()) { // calling the token
                     String temp = stnizer.nextToken();
                     lG.add(temp + " ");
              }
              
              Student tempStudent = new Student(FName, LName, DOB, UnivID, cO, sE, nG, lG); // items for this class
              sdm.getStudents().add(tempStudent);
              
              
       }
           input2.close();
           PrintWriter write2 = new PrintWriter(new FileWriter("StudentData.txt", false)); //creates the txt
              
              write2.flush();
              
       //////////////////////////////////////////////////////////////////////////////////////
              
              
              TAManager tam = new TAManager();
      		// this is the place to convert objects from files into "lists" //professor
      		// lists, TA lists.

      		// read Dates file using Scanner
      		Scanner input3 = new Scanner(new File("TAData.txt"));

      		ArrayList<String> cTs = new ArrayList<String>();
      		ArrayList<String> cTEA = new ArrayList<String>();

      		// read each line
      		while (input3.hasNext()) {
      			String FName = input3.nextLine();
      			String LName = input3.nextLine();
      			String DOB = input3.nextLine();
      			String UnivID = input3.nextLine();
      			String Dept = input3.nextLine();

      			String CTaught = input3.nextLine();

      			StringTokenizer stnizer = new StringTokenizer(CTaught, " "); // token for saving a loop of courses taught

      			while (stnizer.hasMoreTokens()) { // calls string token
      				String temp = stnizer.nextToken();
      				cTs.add(temp + " ");
      			
      			}
      			

      			String CTeaching = input3.nextLine(); 

      			stnizer = new StringTokenizer(CTeaching, " "); // token for saving a loop of courses teaching

      			while (stnizer.hasMoreTokens()) { // calls the string token
      				String temp = stnizer.nextToken();
      				cTEA.add(temp + " ");
      			}

      			TA tempTA = new TA(FName, LName, DOB, UnivID, Dept, cTs, cTEA); // TA items
      			tam.getTAs().add(tempTA);

      		}

      		input3.close();
      		PrintWriter write3 = new PrintWriter(new FileWriter("TAData.txt", false)); // creation of txt file

      		write3.flush(); // flush txt // does not really work for some reason.

              ///////////////////////////////////////////////////////////
              

              // put this into an array list
              // read the content from the file and put them into the array list.
      		  // when you run your system, put one course.
              
              

              
              //StartupScreen sus = new StartupScreen();
              //PrintWriter write4 = new PrintWriter(new FileWriter("AdminData.txt"));
              
              Scanner key = new Scanner(System.in);
              
                     
             		while(true) { // main menu selection
                        System.out.println("Main Menu:");
                        System.out.println("1 - Professor Menu\n"
                                     + "2 - TA menu\n"
                                     + "3 - Staff menu\n"
                                     + "4 - Student menu\n"
                                     + "5 - exit program\n");
            			String menuOption = key.nextLine();
            			if(menuOption.equals("1"))
            				pfm.profManMenu(); // directs you to professorManager class
            			else if(menuOption.equals("2"))
            				tam.taManMenu(); // directs you to TAManager class
            			else if(menuOption.equals("3"))
            				sfm.staffManMenu(); // directs you to StaffManager class
            			else if(menuOption.equals("4"))
            				sdm.studManMenu(); // directs you to StudentManager class
            			else if(menuOption.equals("5")) { // closing the program
            				

                           //this is a place to add professors, staff, students, TA's, into files.
                           for(Professor p : pfm.getProfessors()) {
 
                                write.println(p.getFName()); 
                                write.println(p.getLName());
                                write.println(p.getDOB());
                                write.println(p.getUnivID());
                                write.println(p.getDept());

                           
                                for (String s : p.getCTaught()) { //loop for classes taught - 1 to n
                                     write.write(s + " ");
                                }
                                
                                write.println();
                                
                                
                                
                                for (String s : p.getCTeaching()) { //loop for classes teaching - 1 to n
                                     write.write(s + " ");
                                }
                                write.println();
                                
                                
                                
                                for (String s : p.getTAs()) { //loop for TA - 1 to n
                                     write.write(s + " "); 
                                }
                                write.println();
                                
                               
                               
                            
                                  
                           }
                           
                           write.close();//finish putting all professor objects into a file.
                           
                           for(Staff s : sfm.getStaffs()) {
                                  // add p into a file
 
                                write1.println(s.getFName());
                                write1.println(s.getLName());
                                write1.println(s.getDOB());
                                write1.println(s.getUnivID());
                                write1.println(s.getDept());
                            
                                  
                           }
                           
                           write1.close();//finish putting all Staff objects into a file.
                           
                           
                           for(Student st : sdm.getStudents()) {
                                  // add p into a file
                            
                                write2.println(st.getFName());
                                write2.println(st.getLName());
                                write2.println(st.getDOB());
                                write2.println(st.getUnivID());
                                
                                
                                for (String s : st.getSemester()) { //loop for semester - 1 to n
                                     write2.write(s + " ");
                                }
                                
                                write2.println();
                                
                                
                                for (String s : st.getCourses()) { //loop for Courses - 1 to n
                                     write2.write(s + " ");
                                }

                                write2.println();
                                
                                for (int s : st.getNGrades()) { //loop for number grade - 1 to n
                                     write2.write(s + " ");
                                }
                                
                                write2.println();
                                
                                for (String s : st.getLGrades()) { //loop for letter grade - 1 to n
                                     write2.write(s + " ");
                                }
                                write2.println();
                            
                                  
                           }
                           
                           write2.close();//finish putting all student objects into a file.
                           
                           for (TA t : tam.getTAs()) {
           					// add p into a file

           					write3.println(t.getFName());
           					write3.println(t.getLName());
           					write3.println(t.getDOB());
           					write3.println(t.getUnivID());
           					write3.println(t.getDept());

           					for (String s : t.getCTaught()) { //loop for classes assisted - 1 to n
           						write3.write(s + " ");
           					}

           					write3.println();

           					for (String s : t.getCTeaching()) { //loop for classes assisting - 1 to n
           						write3.write(s + " ");
           					}

           					write3.println();

           				}

           				write3.close();// finish putting all TA objects into a file.

                           
                           
                           break;
                           }
               			else 
            				System.out.println("Not a valid option. Please enter the number that corresponds to the menu you are trying to access.");
            			
                     } // ends else if = 5
             		  System.out.println("Thank you for visiting your University's Manager. Come again soon");

              } // ends while loop
            
       } // ends main menu



