
public class Project {

	private int projectNumber;
	private String projectName;
	private String buildingType;
	private String postalAddress;
	private String erfNumber;
	private double totalFee;
	private double paidAmount;
	private String deadline;
	private String status;
	private String completionDate;
	private Person architect;
	private Person contractor;
	private Person customer;

	public Project(int projectNumber, String projectName, String buildingType, String postalAddress, String erfNumber,
			double totalFee, double paidAmount, String deadline, String status, String completionDate, Person architect,
			Person contractor, Person customer) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.postalAddress = postalAddress;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.paidAmount = paidAmount;
		this.deadline = deadline;
		this.status = status;
		this.completionDate = completionDate;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setContractor(Person contractor) {
		this.contractor = contractor;
	}

	public Person getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		String output = "Project Number: " + projectNumber + "\n";
		output += "Project Name: " + projectName + "\n";
		output += "Project Building Type: " + buildingType + "\n";
		output += "Project Postal Address: " + postalAddress + "\n";
		output += "Project ERF Number: " + erfNumber + "\n";
		output += "Project Total Fee: " + totalFee + "\n";
		output += "Project Amount Paid: " + paidAmount + "\n";
		output += "Project Deadline: " + deadline + "\n";
		output += "Project Status: " + status + "\n";
		output += "Project Completion Date: " + completionDate + "\n";
		output += "\n" + architect + "\n";
		output += contractor + "\n";
		output += customer + "\n";
		return output;
	}

}
