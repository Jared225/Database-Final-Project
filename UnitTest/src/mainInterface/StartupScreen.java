package mainInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//import Staff.Staff;

public class StartupScreen {
	
	static Interface itf = new Interface();
	ArrayList<StartupScreen> StartupScreens = new ArrayList<StartupScreen>();

	public ArrayList<StartupScreen> getStartupScreens() {
		return StartupScreens;
	}

	
	

	public static void main(String[] args) throws IOException{
		// test the Interface class

		
		System.out.println("THIS SOFTWARE IS NOT TO BE USED FOR UNIVERSITY MANAGEMENT PURPOSE");
		

		
		
		try {
			itf.mainMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}