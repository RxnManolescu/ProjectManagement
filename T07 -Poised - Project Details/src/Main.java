import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		
		// Display prompt
		System.out.println("Please add the following details: \n");
		
		// Instantiate a project object by calling the addProject method
		Project project = addProject();
		
		System.out.println("Please see below details added!\n");
		
		// Display project details to user
		System.out.println(project.toString());
		
		// Loop to continuously ask user for choices until user decides to quit
		while (true) {
			showMenu(); // Display menu to user
			System.out.println("Enter choice: ");
			// Loop to check whether the input is an integer
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			// Statement to allow user to change deadline
			if (choice == 1) {
				String newDeadline = "";
				while (true) {
					System.out.println("Enter new deadline(dd-MM-yyyy): ");
					// Format date to day-month-year
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						newDeadline = scanner.nextLine();
						formatter.parse(newDeadline);
						break;
					}
					// Catch invalid date format
					catch(Exception e) {
						System.out.println("Date format not valid!");
					}
				}
				// Set project new deadline and display updated details to user
				project.setDeadline(newDeadline);
				System.out.println("Please see below the project details after deadline updated!\n");
				System.out.println(project.toString());
			}
			// Statement to allow user to update paid amount
			else if (choice == 2) {
				while(true) {
					System.out.println("Enter updated fee amount paid: ");
					while (!scanner.hasNextDouble()) {
						System.out.println("Invalid input!");
						scanner.next();
					}
					double newAmountPaid = scanner.nextDouble();
					// Display error message if the new amount is more than the total fee
					if (newAmountPaid > project.getTotalFee()) {
						System.out.println("You cannot pay more than the project's total fee of " + project.getTotalFee() + "\n");
					}
					// Update new amount paid on the project
					else {
						project.setPaidAmount(newAmountPaid);
						System.out.println("Please see below the project details after paid amount updated!\n");
						System.out.println(project.toString());
						break;
					}
				}
			}
			// Statement to allow user to update contractor details
			else if (choice == 3) {
				// Instantiate a new contractor object by calling the method to add a contractor
				Person updatedContractor = addContractor(); 
				// Update contractor details and display update project details to user
				project.setContractor(updatedContractor);
				System.out.println("Please see below the project details after contrator details updated!\n");
				System.out.println(project.toString());
			}
			else if (choice == 4) {
				// Condition to allow user to mark project as finalised if total fee and fee amount paid are the same
				if (project.getPaidAmount() == project.getTotalFee()) {
					project.setStatus("finalised");
					String dateCompleted;
					// Loop to ask user to enter completion date, parse it to a date format or 
					// display error message otherwise
					while (true) {
						System.out.println("Enter completion date(dd-MM-yyy); ");
						DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						try {
							dateCompleted = scanner.nextLine();
							format.parse(dateCompleted);
							break;
						}
						catch(Exception e) {
							System.out.println("Date format not valid!");
						}
					}
					project.setCompletionDate(dateCompleted);
					System.out.println("Please see below the project details after project has been finalised!\n");
					System.out.println(project.toString());
				}
				// Condition to display invoice with customer details and the amount of fee still due to be paid
				// project will not be marked as finalised until the total fee is paid in full
				else if (project.getPaidAmount() < project.getTotalFee()) {
					double overdueFee =  project.getTotalFee() - project.getPaidAmount();
					System.out.println("INVOICE");
					System.out.println(project.getCustomer().toString());
					System.out.println("Fee amount still due: " + overdueFee + "\n");
					System.out.println("Please ensure the total fee is paid in full before marking the project as \"finalised\"\n");
				}
			}
			else if (choice == 0) {
				// Display exit message when user chooses to quit menu
				System.out.println("Thank you for using the Project Management. Goodbye!");
				System.out.println();
				System.exit(0);
			}
			else {
				// Display error message when user choice is not available
				System.out.println("No such option is available! Please try again!");
				System.out.println();
			}
		}
	}
	
		// Method to display menu to user
		public static void showMenu() {
			System.out.println("1 - Edit project due date");
			System.out.println("2 - Edit fee paid amount");
			System.out.println("3 - Update contractor's contact details");
			System.out.println("4 - Finalise project");
			System.out.println("0 - Exit");
		}
		
		// Method to return an architect person
		public static Person addArchitect() {
			// Ask user to enter all details
			System.out.println("Enter architect name: ");
			String architectName = scanner.nextLine();
			System.out.println("Enter architect phone number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			int architectPhoneNumber = scanner.nextInt();
			scanner.nextLine(); // Consume the \n character left in the scanner
			System.out.println("Enter architect email address: ");
			String architectEmailAddress = scanner.nextLine();
			System.out.println("Enter architect postal address: ");
			String architectPostalAddress = scanner.nextLine();
			
			return new Person("Architect", architectName, architectPhoneNumber, architectEmailAddress, architectPostalAddress);
		}
		
		// Method to return a contractor person
		public static Person addContractor() {
			// Ask user to enter all details
			System.out.println("Enter contractor name: ");
			String contractorName = scanner.nextLine();
			System.out.println("Enter contractor phone number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			int contractorPhoneNumber = scanner.nextInt();
			scanner.nextLine(); // Consume the \n character left in the scanner
			System.out.println("Enter contractor email address: ");
			String contractorEmailAddress = scanner.nextLine();
			System.out.println("Enter contractor postal address: ");
			String contractorPostalAddress = scanner.nextLine();
			
			return new Person("Contractor", contractorName, contractorPhoneNumber, contractorEmailAddress, contractorPostalAddress);
		}
		
		// Method to return a customer person
		public static Person addCustomer() {
			// Ask user to enter all details
			System.out.println("Enter customer name: ");
			String customerName = scanner.nextLine();
			System.out.println("Enter customer phone number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			int customerPhoneNumber = scanner.nextInt();
			scanner.nextLine(); // Consume the \n character left in the scanner
			System.out.println("Enter customer email address: ");
			String customerEmailAddress = scanner.nextLine();
			System.out.println("Enter customer postal address: ");
			String customerPostalAddress = scanner.nextLine();
			
			return new Person("Customer", customerName, customerPhoneNumber, customerEmailAddress, customerPostalAddress);
		}
		
		// Method to return a project object
		public static Project addProject() throws ParseException {
		// Calling methods to help create a project object using all values
			Person architect = addArchitect();
			Person contractor = addContractor();
			Person customer = addCustomer();
			
			// Ask user to enter all details
			System.out.println("Enter building type: ");
			String buildingType = scanner.nextLine();
			System.out.println("Enter project number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			int projectNumber = scanner.nextInt();
			String projectName;
			scanner.nextLine();
			// Loop to allow customer to pick a customised project name, otherwise a project name will
			// automatically be generated, made of the building type and the customer's name
			while (true) {
				System.out.println("Customise project name? yes or no?");
				String nameChoice = scanner.nextLine();
				if (nameChoice.equalsIgnoreCase("yes")) {
					System.out.println(("Enter project name: "));
					projectName = scanner.nextLine();
					break;
				}
				else if (nameChoice.equalsIgnoreCase("no")) {
					projectName = buildingType + " " + customer.getName();
					break;
				}
				else {
					System.out.println("Option invalid!");
				}
			}
			System.out.println("Enter postal address: ");
			String postalAddress = scanner.nextLine();
			System.out.println("Enter ERF number: ");
			String erfNumber = scanner.nextLine();
			System.out.println("Enter total fee: ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Invalid input!");
				scanner.next();
			}
			double totalFee = scanner.nextDouble();
			scanner.nextLine(); // Consume the \n character left in the scanner
			double amountPaid;
			while (true) {
				System.out.println("Enter amount paid: ");
				while (!scanner.hasNextDouble()) {
					System.out.println("Invalid input!");
					scanner.next();
				}
				amountPaid = scanner.nextDouble();
				// Statement to display error message if the amount to be paid is more than total fee due
				if (amountPaid > totalFee) {
					System.out.println("You cannot pay more than the project's total fee of " + totalFee + "\n");
				}
				else {
					break;
				}
			}
			scanner.nextLine(); // Consume the \n character left in the scanner
			String deadline;
			// Loop to allow user to enter deadling and parse input to a valid date format or
			// display error message
			while (true) {
				System.out.println("Enter deadline(dd-MM-yyyy): ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				try {
					deadline = scanner.nextLine();
					formatter.parse(deadline);
					break;
				}
				catch(Exception e) {
					System.out.println("Date format not valid!");
				}
			}
			// Variable to set default status value
			String status = "ongoing";
			
			// Variable to set default completion date
			String completionDate = "00-00-0000";
			
			return new Project(projectNumber, projectName, buildingType, postalAddress,
					erfNumber, totalFee, amountPaid, deadline, status, completionDate, architect, contractor, customer);
		}
			
}
