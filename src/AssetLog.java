import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;



public class AssetLog {

	//creates a new ArrayList to store assets
	ArrayList<Asset> assetList = new ArrayList<Asset>();
	XStream xstream = new XStream();
	
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
			assetList.add(checkAssetType(line));
		}
	}
	
	public void splitPerson(String fileName) throws IOException
	{
		
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner personScan = new Scanner(reader);
		
		String line = null;
		while((line = reader.readLine()) != null)//while there is still a line in the file
		{
			System.out.println(line);
			Asset asset = checkAssetType(line);
			assetList.add(asset);
			writePerson(asset);
		}
	}
	
	public void writeAsset(Person person) {
	    System.out.println("save person XML");
	    FileOutputStream fos = null;
	    try{            
	        String xml = xstream.toXML(person);
	        fos = new FileOutputStream("data/Persons.xml", true);
	        fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
	        byte[] bytes = xml.getBytes("UTF-8");
	        fos.write(bytes);

	    }catch (Exception e){
	        System.err.println("Error in XML Write: " + e.getMessage());
	    }
	    finally{
	        if(fos != null){
	            try{
	                fos.close();
	            }catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	
	public void checkAssetType(String token){
		String[] array = token.split(";");
		if (array[1] == "D" ){
			parseDA(token);
		}
		else if (array[1] == "S"){
			parseStock(token);
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
		String strApr = array[3];
		double apr = Double.parseDouble(strApr);
		DepositAccount account = new DepositAccount(code, label,apr);
		return account;
	}
	
	public Stock parseStock(String token){
		String[] array = token.split(",");
		String code = array[0];
		String label = array[2];
		String strQuarterlyDividend = array[3];
		double quarterlyDividend = Double.parseDouble(strQuarterlyDividend);
		double baseRateOfReturn = Double.parseDouble(array[4]);
		double betaMeasure = Double.parseDouble(array[5]);
		String stockSymbol = array[6];
		double sharePrice = Double.parseDouble(array[7]);
		Stock stock = new Stock(code,label,quarterlyDividend,baseRateOfReturn,betaMeasure,stockSymbol,sharePrice);
		return stock;
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
