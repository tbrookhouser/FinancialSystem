import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class AssetLog {

	//creates a new ArrayList to store assets
	ArrayList<Asset> assetList = new ArrayList<Asset>();
	
	/**
	 * returns the person array List
	 * @return personList
	 */
	public ArrayList<Asset> getAssetList()
	{
		return this.assetList;
	}
	
	/**
	 * sets the person array List
	 * @param personList
	 */
	public void setAssetList(ArrayList<Asset> assetList)
	{
		this.assetList = assetList;
	}
	
	
	/**
	 * checkFile takes the user input string for a file name and checks it if exists 
	 * and is readable.
	 * If it is, it returns true. If not, it returns false.
	 * @param fileName
	 * @return boolean readable or not
	 */
	public boolean checkFile(String fileName)
	{
		File file = new File(fileName);
		if (file.exists() && file.canRead())
		{
			return true;
		}
		else
		{
			return false;
		}
	} 
	
	/**
	 * splitPeople reads a file and adds each line of the file into a person
	 * array list
	 * @param fileName
	 * @throws IOException
	 */
	public void splitAsset(String fileName) throws IOException
	{
		
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner assetScan = new Scanner(reader);
		
		String line = null;
		while((line = reader.readLine()) != null)//while there is still a line in the file
		{
			assetList.add(checkAsset(line));
		}
	}
	
	
	public void checkAssetType(String token){
		String[] array = token.split(";");
		if (array[1] == "D" ){
			parseDA(token);
		}
		else if (array[2] == "S"){
			
		}
		else {
			
		}
	}
	
	/**
	 * parseVehicle takes a string and splits it into an array by each space
	 * it then sets each element in the array equal to a vehicle data member
	 * @param token
	 * @return Vehicle object 
	 */
	public DepositAccount parseDA(String token)
	{
		String[] array = token.split(";");
		String code = array[0];
		String label = array[2];
		String 
	}
	
	public Address parseAddress(String address){
		String[] addressArray = address.split(",");
		String street1 = addressArray[0];
		String city = addressArray[1];
		String state = addressArray[2];
		String zip = addressArray[3];
		String country = addressArray[4];
		Address addressObject = new Address(street1, city, state, zip, country);
		return addressObject;
	}
	
	public Name parseName(String name){
		String[] nameArray = name.split(",");
		String firstName = nameArray[0];
		String lastName = nameArray[1];
		Name nameObject = new Name(firstName, lastName);
		return nameObject;
	}
	
	public ArrayList parseEmail(String email){
		ArrayList <String> emailList = (ArrayList<String>) Arrays.asList(email.split("\\s*,\\s*"));
		return emailList;
	}



}
