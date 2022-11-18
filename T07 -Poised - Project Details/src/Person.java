
public class Person {

	private String role;
	private String name;
	private int phoneNumber;
	private String emailAddress;
	private String postalAddress;

	public Person(String role, String name, int phoneNumber, String emailAddress, String postalAddress) {
		this.role = role;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.postalAddress = postalAddress;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		String output = "Role: " + role + "\n";
		output += "Name: " + name + "\n";
		output += "Phone Number: " + phoneNumber + "\n";
		output += "Email Address: " + emailAddress + "\n";
		output += "Postal Address: " + postalAddress + "\n";
		return output;
	}
} 
