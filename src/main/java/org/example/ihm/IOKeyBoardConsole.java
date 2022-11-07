package org.example.ihm;

import java.util.Scanner;

/**
 * Your class in package ihm to read from the keyboard and write on the screen
 * @author Allain
 *
 */
public class IOKeyBoardConsole {

	// The Scanner is in another class according to MVC Design Pattern
	private static final Scanner sc = new Scanner(System.in); 

	/**
	 * example
	 * age = IOKeyBoardConsole.readANumber("enter your age :");
	 * @param text
	 * @return
	 */
	public static int readANumber(String text) {
		System.out.println(text);
		int number = sc.nextInt();		
		//System.out.println("number given = "+number);
		return number;
	}

	/**
	 * example
	 * name = IOKeyBoardConsole.readAString("Enter your name :");
	 * @param text
	 * @return
	 */
	public static String readAString(String text) {
		System.out.println(text);
		String word = sc.next();		
		//System.out.println("number given = "+word);
		return word;
	}

	/**
	 * You should only close once your scanner, at the end of the program
	 */
	public static void close() {
		sc.close();
	}

	public static void print(Object object) {
		System.out.println(object);
	}
	
	public static void pressEnter() {
		System.out.println("press Enter to continue...");
		sc.nextLine();	
	}
	
	/**
	 * example
	 * continue = IOKeyBoardConsole.readABoolean("Do you want to play again ?");
	 * @param string
	 * @return
	 */
	public static boolean readABoolean(String string) {
		System.out.println(string+" y/Y n/N");
		String word = sc.next();		
		return word.equals("y")||word.equals("Y");
	}
	
}
