
public class Address {
	private String street1;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	
	
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(){
		street1 = "";
		city = "";
		state = "";
		zip = "";
		country = "";
	}
	
	public Address(String street1, String city, String state, String zip, String country){
		this.street1 = street1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	
}
