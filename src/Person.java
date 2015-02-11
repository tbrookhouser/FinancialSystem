import java.util.ArrayList;


public class Person {
 
	private String idNumber;
	private String brokerData;
	private Name name;
	private Address address;
	private ArrayList<String> email;
	
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getBrokerData() {
		return brokerData;
	}


	public void setBrokerData(String brokerData) {
		this.brokerData = brokerData;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public ArrayList<String> getEmail() {
		return email;
	}


	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public Person(){
		idNumber = "";
		brokerData = "";
		this.name = new Name();
		this.address = new Address();
		email = new ArrayList<String>();
		
	}
	public Person(String idNumber, String brokerData, Name name, Address address, ArrayList<String> email){
		this.idNumber = idNumber;
		this.brokerData = brokerData;
		this.name = name;
		this.address = address;
		this.email = email;
		
	}
}
