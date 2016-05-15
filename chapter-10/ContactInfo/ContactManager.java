import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
	
	private ArrayList<ContactInfo> contacts;
	final private String PATH = "contacts.csv"; 
	final private String[] HEADERS = {"First Name", "Last Name", "Business Number", "Home Number", "Mobile Number", "Email", "Home Address"};
	Scanner input;
	
	/**
	 * Returns the contacts arraylist as an array.
	 * 
	 * @return ContactInfo[] An array containing all of the contacts.
	 */
	public ContactInfo[] getContacts() {
		return contacts.toArray(new ContactInfo[contacts.size()]);
	}
	
	/**
	 * Print out a formatted list of contacts
	 * 
	 * @return Nothing.
	 */
	public void listContacts() {
		for(String s : HEADERS) {
			System.out.print(s + "\t");
		}
		
		for (ContactInfo c : contacts) {
			String[] row = {c.getFirstName(), c.getLastName()};
			for(String s : row) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints the possible operations and runs the correct one based on user
	 * input.
	 * 
	 * @return Nothing.
	 */
	public void decideOperation() {
		System.out.println("Choose an Operation:\n1: List contacts\n2: Add contact\n3: Remove contact\n4: Quit");
		
		switch(input.next()) {
			case "1":
				listContacts();
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				quit();
				break;
		}
		System.out.println();
	}
	
	/**
	 * Reads the csv file and fills the contacts list with contacts from the file.
	 * 
	 * @return Nothing.
	 */
	public void loadContacts() throws FileNotFoundException, UnsupportedEncodingException, IOException{
		FileInputStream in = new FileInputStream(PATH);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		reader.readLine(); // Skip header
		
		String csv;
		while((csv = reader.readLine()) != null) {
			try {
				contacts.add(new ContactInfo(csv));
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid line!");
			}
		}
		in.close();
	}
	
	/**
	 * Overwrite the csv file with the header and the current contacts list.
	 * 
	 * @return Nothing.
	 */
	public void writeContacts() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(PATH, "UTF-8");
		writer.println("First Name;Last Name;Business Number;Home Number;Mobile Number;Email;Home Address");
		for(ContactInfo c : contacts) {
			writer.println(c);
		}
		writer.close();
	}
	
	/**
	 * Finishes the program by saving the contacts in the text file.
	 * 
	 * @return Nothing.
	 */
	public void quit() {	
		try {
			writeContacts();
		} catch(FileNotFoundException e) {
			System.out.println("No such file to save!");
		} catch(UnsupportedEncodingException e) {
			System.out.println("Failed to save file! Unsupported encoding.");
		}
		System.exit(0);
	}
	
	public ContactManager() {
		input = new Scanner(System.in);
		contacts = new ArrayList<ContactInfo>();
		try {
			loadContacts();
		} catch(FileNotFoundException e) {
			System.out.println("Could not find file!");
		} catch(UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding!");
		} catch(IOException e) {
			System.out.println("Failed to read file!");
		}
	}
	
	public static void main(String[] args) {
		ContactManager cm = new ContactManager();
		
		while(true) {
			cm.decideOperation();
		}
	}
}
