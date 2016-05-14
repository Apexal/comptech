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
		Coder[] encoders = {new SubstitutionCipher(), new ShuffleCipher()};
		
		Scanner input = new Scanner(System.in);
		System.out.println("Choose encoder: ");
		System.out.println("1: Caesar (Subsitution)");
		System.out.println("2: Shuffle");
		
		int choice = input.nextInt();
		while(choice < 1 || choice > encoders.length) {
			System.out.println("Invalid choice!");
			choice = input.nextInt();
		}
		
		Coder coder = encoders[choice - 1];
		coder.init(); // All encoders are required to have this method
		
		System.out.println("Enter lines: \n'encode: blah blah blah'");
		String plainText = input.nextLine();
		while(!plainText.equalsIgnoreCase("stop")) {
			String[] parts = plainText.split(": ");
			String line = parts[0];
			
			// If they don't specify encode/decode assume encode
			if(parts.length == 2) {
				line = parts[1];
			}
			
			// Make sure the String isn't empty
			if(line.length() != 0) {			
				if(parts[0].equalsIgnoreCase("decode")) {
					System.out.println(coder.decode(line));
				} else {
					System.out.println(coder.encode(line));
				}
			}
			plainText = input.nextLine();
		}
	}
}
