import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ContactManager {
	
	private ArrayList<ContactInfo> contacts;
	
	public ContactInfo[] getContacts() {
		return contacts.toArray(new ContactInfo[contacts.size()]);
	}
	
	public void decideOperation() {
		
	}
	
	public void loadContacts(String fileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
		FileInputStream in = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-16"));
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
	
	public ContactManager() {
		contacts = new ArrayList<ContactInfo>();
		try {
			loadContacts("contacts.csv");
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
		cm.decideOperation();
		
		for(ContactInfo c : cm.getContacts()) {
			System.out.println(c);
		}
		
		System.out.println();
	}
}
