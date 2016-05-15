import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String fileName = "contacts.csv";

		try {
			FileInputStream in = new FileInputStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-16"));
			reader.readLine(); // Skip header
			
			ArrayList<ContactInfo> contacts = new ArrayList<ContactInfo>();
			
			String csv;
			while((csv = reader.readLine()) != null) {
				try {
					contacts.add(new ContactInfo(csv));
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid line!");
				}
			}
			
			// Print info on each contact
			for(ContactInfo c : contacts) {
				System.out.println(c);
			}
			
			in.close();
		} catch(Exception e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}
}
