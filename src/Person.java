import java.util.ArrayList;


public class Person {
 
	private int idNumber;
	private Name name;
	private Address address;
	private ArrayList email;
	
	public Person(int idNumber, Name name, Address address, ArrayList email){
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.email = email;
		
	}
}
