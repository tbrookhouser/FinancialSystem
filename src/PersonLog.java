import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;



public class PersonLog {
		
		//creates a new ArrayList to store people
		ArrayList<Person> personList = new ArrayList<Person>();
		
		/**
		 * returns the person array List
		 * @return personList
		 */
		public ArrayList<Person> getPersonList()
		{
			return this.personList;
		}
		
		/**
		 * sets the person array List
		 * @param personList
		 */
		public void setPersonList(ArrayList<Person> personList)
		{
			this.personList = personList;
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
		public void splitVehicle(String fileName) throws IOException
		{
			
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner vehicleScan = new Scanner(reader);
			
			String line = null;
			while((line = reader.readLine()) != null)//while there is still a line in the file
			{
				personList.add(parsePerson(line));
			}
		}
		
		/**
		 * parseVehicle takes a string and splits it into an array by each space
		 * it then sets each element in the array equal to a vehicle data member
		 * @param token
		 * @return Vehicle object 
		 */
		public Person parsePerson(String token)
		{
			String[] array = token.split(";");
			int idNumber = Integer.parseInt(array[0]);
			String name = array[1];
			Name customerName = parseName(name);
			String address = array[2];
			Address customerAddress = parseAddress(address);
			String email = array[3];
			ArrayList customerEmail = parseEmail(email);
			Person customer = new Person(name, address, email);
			
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
		/**
		 * updateLog calls the check test date method or each vehicle in the array list
		 * and updates the information. It then adds all of the data from each vehicle object to s string
		 * and writes it to a file
		 * @param fileName that was chosen by user
		 * @throws IOException
		 */
		public void updateLog(String fileName) throws IOException
		{
			File updatedLog = new File(fileName);
			FileWriter fileWriter = new FileWriter(updatedLog, false);
			for (Vehicle vehicle : vehicleList)
			{
				String vehicleString = "";
				vehicle.checkTestDate();
				{
					vehicleString+=(vehicle.getIdNumber()+" ");
					vehicleString+=(vehicle.getSerialNumber()+" ");
					vehicleString+=(vehicle.getTypeOfVehicle()+" ");
					vehicleString+=(vehicle.getMileage()+" ");
					vehicleString+=(vehicle.getMechanicalFaults()+" ");
					vehicleString+=(vehicle.getElectricalFaults()+" ");
					vehicleString+=(vehicle.getStealthIndex()+" ");
					vehicleString+=(vehicle.getTopSpeed()+" ");
					vehicleString+=(vehicle.getWeaponsRating()+" ");
					vehicleString+=((vehicle.getLastTested()).get(Calendar.MONTH)+1+"/"+(vehicle.getLastTested()).get(Calendar.DAY_OF_MONTH)+"/"+(vehicle.getLastTested()).get(Calendar.YEAR)+" ");
					//adds a number 1 for passing tests or 0 for failing rather than a boolean
					if (vehicle.getNavigationTest())
					{
						vehicleString+= 1+" ";
					}
					else
					{
						vehicleString+= 0+" ";
					}
						
					if (vehicle.getWeaponsTest())
					{
						vehicleString+= 1;
					}
					else
					{
						vehicleString+= 0;
					}
					fileWriter.write(vehicleString + "\r\n");
				}
			}
			fileWriter.close();
			
		}	
		
		/**
		 * findBestVehicle takes each Bat-Mobile vehicle that has passed both the weapons 
		 * and navigations test and adds it to an array list batIndexArray. If there is a vehicle 
		 * in the array, it is set to lowestBatIndex. For every vehicle in the array, the bat index 
		 * is compared and the lowest one will replace it. The information about that vehicle is then
		 * printed out. If there is not vehicle that qualifies, the user is notified.
		 */
		public void findBestVehicle()
		{
			//creates an array list to hold vehicles with a bat index
			ArrayList<Vehicle> batIndexArray= new ArrayList<Vehicle>();
			for (Vehicle vehicle : vehicleList)
			{
				//each vehicle that is a Bat-Mobile and passed both tests is added to the array list
				if ( vehicle.getTypeOfVehicle().equals("Bat-Mobile")&&vehicle.getWeaponsTest()==true && vehicle.getNavigationTest() == true)
				{
					batIndexArray.add(vehicle);
				}
			}
			if (!batIndexArray.isEmpty()){//if the array list is not empty
				lowestBatIndex = batIndexArray.get(0);//the first vehicle is set as lowestBatIndex
				for (Vehicle vehicle : batIndexArray)
				{
					//if a vehicle in the array list has a lower bat index, it replaces
					//the previous vehicle as lowestBatIndex
					if (vehicle.calculateBatIndex()< lowestBatIndex.calculateBatIndex())
					{
						lowestBatIndex = vehicle;
					}
				}
				System.out.println("Vehicle Serial Number:\t" + lowestBatIndex.getSerialNumber());
				System.out.println("Type:\t\t\t" + lowestBatIndex.getTypeOfVehicle());
				System.out.println("Mileage:\t\t" + lowestBatIndex.getMileage());
				System.out.println("# of Mechanical Faults:\t" + lowestBatIndex.getElectricalFaults());
				System.out.println("# of Electrical Faults:\t" + lowestBatIndex.getStealthIndex());
				System.out.println("Weapons Rating:\t\t" + lowestBatIndex.getWeaponsRating());
				System.out.println("Top Speed:\t\t" + lowestBatIndex.getTopSpeed());
				System.out.println("Testing Date:\t\t" + (lowestBatIndex.getLastTested().get(Calendar.MONTH)+1)+"/"+ lowestBatIndex.getLastTested().get(Calendar.DAY_OF_MONTH) + "/" + lowestBatIndex.getLastTested().get(Calendar.YEAR));
				
			}
			else
			{
				System.out.println("No vehicles qualify.");
			}
		}
		
		/**
		 * writeNewFile takes the information of lowestBatIndex and writes it to a new file
		 * based on the file name provided by the user.
		 * @param outputFileName name chosen by user in BatVehicleSearch
		 * @throws IOException
		 */
		public void writeNewFile(String outputFileName) throws IOException
		{
				try{
					File outputFile = new File(outputFileName);
					FileWriter fileWriter = new FileWriter(outputFile);
					fileWriter.append("Vehicle Serial Number: " + lowestBatIndex.getSerialNumber());
					fileWriter.append("\r\nType: " + lowestBatIndex.getTypeOfVehicle());
					fileWriter.append("\r\nMileage: " + lowestBatIndex.getMileage());
					fileWriter.append("\r\n# of Mechanical Faults: " + lowestBatIndex.getElectricalFaults());
					fileWriter.append("\r\n# of Electrical Faults: " + lowestBatIndex.getStealthIndex());
					fileWriter.append("\r\nWeapons Rating: " + lowestBatIndex.getWeaponsRating());
					fileWriter.append("\r\nTop Speed: " + lowestBatIndex.getTopSpeed());
					fileWriter.append("\r\nTesting Date: " + (lowestBatIndex.getLastTested().get(Calendar.MONTH)+1)+"/"+ lowestBatIndex.getLastTested().get(Calendar.DAY_OF_MONTH) + "/" + lowestBatIndex.getLastTested().get(Calendar.YEAR));
					fileWriter.close();
					} catch (Exception e){   //if there is no lowestBatIndex, this will catch the error
					System.out.println("No vehicle available with bat index.");//and print an error message
				}
		}
	

}
