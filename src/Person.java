import java.util.ArrayList;


public class Person {
 
	private int idNumber;
	private String brokerData;
	private Name name;
	private Address address;
	private ArrayList email;
	
	
	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
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


	public ArrayList getEmail() {
		return email;
	}


	public void setEmail(ArrayList email) {
		this.email = email;
	}

	public Person(){
		idNumber = 0;
		brokerData = "";
		this.name = new Name();
		this.address = new Address();
		email = new ArrayList<String>();
		
	}
	public Person(int idNumber, String brokerData, Name name, Address address, ArrayList email){
		this.idNumber = idNumber;
		this.brokerData = brokerData;
		this.name = name;
		this.address = address;
		this.email = email;
		
	}
}
