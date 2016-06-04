import java.io.*;
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

    public void addContact() {
        input.nextLine();

        String[] values = new String[HEADERS.length];
        for (int i = 0; i < HEADERS.length; i++) {
            String header = HEADERS[i];
            System.out.print(header + ": ");
            values[i] = input.nextLine();
        }

        contacts.add(new ContactInfo(String.join(";", values)));
    }

	/**
	 * Print out a formatted list of contacts
	 * 
	 * @return Nothing.
	 */
	public void listContacts() {
		for (ContactInfo c : contacts) {
            System.out.println("[CONTACT #" + (contacts.indexOf(c) + 1) + "]");

            String[] values = c.valuesToArray();
            for (int i = 0; i < HEADERS.length; i++) {
                System.out.println(HEADERS[i].toUpperCase() + ": " + values[i]);
            }
            System.out.println("---");
        }

        System.out.println("\n---\n" + contacts.size() + " found");
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
                addContact();
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
    public void loadContacts() throws IOException {
        FileInputStream in = new FileInputStream(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		
		String csv;
		while((csv = reader.readLine()) != null) {
			try {
                // Allow comments in csv file starting with #
                if (!csv.startsWith("#")) {
                    contacts.add(new ContactInfo(csv));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
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
