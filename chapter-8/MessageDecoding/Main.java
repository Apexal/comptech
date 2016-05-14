/**
 * This program allows the user to select a specific encoder from a list
 * and then continuously encode text line by line using the chosen
 * encoding method.
 * 
 * @author Frank Matranga
 * @version 2016-05-13
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Holds the possible encoders as MessageEncoders
		MessageEncoder[] encoders = {new SubstitutionCipher()};
		
		Scanner input = new Scanner(System.in);
		System.out.println("Choose encoder: ");
		System.out.println("0: Caesar (Subsitution)");
		
		int choice = input.nextInt();
		while(choice < 0 || choice + 1 > encoders.length) {
			System.out.println("Invalid choice!");
			choice = input.nextInt();
		}
		
		MessageEncoder encoder = encoders[choice];
		encoder.init(); // All encoders are required to have this method
		
		String plainText = input.nextLine();
		while(!plainText.equalsIgnoreCase("stop")) { 
			System.out.print(encoder.encode(plainText) + "\n>");
			plainText = input.nextLine();
		}
	}
}
