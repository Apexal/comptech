public class ContactInfo {
	private String firstName;
	private String lastName;
	
	private String businessNumber;
	private String homeNumber;
	private String mobileNumber;
	
	private String email;
	
	private String homeAddress;
	
	// When you want to read a text file of contacts
    public ContactInfo(String csv) throws InvalidContactException {
        String[] info = csv.split(";");

        if (info.length != 7) {
            throw new InvalidContactException();
        }

		this.firstName = info[0];
		this.lastName = info[1];
		this.businessNumber = info[2];
		this.homeNumber = info[3];
		this.mobileNumber = info[4];
		this.email = info[5];
		this.homeAddress = (info.length == 7 ? info[6] : "");
	}
	
	// In case you want to manually create a contact
	public ContactInfo(String firstName, String lastName, String businessNumber, 
		String homeNumber, String mobileNumber, String email, String homeAddress) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessNumber = businessNumber;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.homeAddress = homeAddress;
	}
	
	// Get methods for all the private class variables
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getHomeAddress() {
		return homeAddress;
	}

    public String[] valuesToArray() {
        return new String[]{getFirstName(), getLastName(), getBusinessNumber(), getHomeNumber(), getMobileNumber(), getEmail(), getHomeAddress()};
    }

	public String toString() {
		return firstName + ";" + lastName + ";" + businessNumber + ";" + 
			homeNumber + ";" + mobileNumber + ";" + email + ";" + homeAddress;
	}
}
