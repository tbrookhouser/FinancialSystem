
 
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class WritePersonXML {
	

	private Name name;
	private Address address;
	
	public WritePersonXML(){

		this.name = new Name();
		this.address = new Address();
		//DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	}
 
	public void writeToPersonXml(Person person) {
 
	  
		try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("persons");
		doc.appendChild(rootElement);
 
		// person elements
		Element personTag = doc.createElement("person");
		rootElement.appendChild(personTag);
 
		// code elements
		Element code = doc.createElement("code");
		code.appendChild(doc.createTextNode(person.getIdNumber()));
		personTag.appendChild(code);
 
		// firstName elements
		Element firstName = doc.createElement("firstName");
		firstName.appendChild(doc.createTextNode(name.getFirstName()));
		personTag.appendChild(firstName);
 
		// lastName elements
		Element lastName = doc.createElement("lastName");
		lastName.appendChild(doc.createTextNode(name.getLastName()));
		personTag.appendChild(lastName);
 
		// address elements
		Element addressTag = doc.createElement("address");
		personTag.appendChild(addressTag);
		
		Element street = doc.createElement("street");
		street.appendChild(doc.createTextNode(address.getStreet1()));
		addressTag.appendChild(street);
		
		Element city = doc.createElement("city");
		city.appendChild(doc.createTextNode(address.getCity()));
		addressTag.appendChild(city);
		
		Element state = doc.createElement("state");
		state.appendChild(doc.createTextNode(address.getState()));
		addressTag.appendChild(state);
		
		Element country = doc.createElement("country");
		country.appendChild(doc.createTextNode(address.getCountry()));
		addressTag.appendChild(country);
		
		Element zipcode = doc.createElement("zipcode");
		zipcode.appendChild(doc.createTextNode(address.getZip()));
		addressTag.appendChild(zipcode);
		
		Element emails = doc.createElement("emails");
		personTag.appendChild(emails);
		
		for(int i = 0; i< person.getEmail().length; i++){  
			String [] emailArray = new String [person.getEmail().length];
			emailArray[i] = person.getEmail()[i];
			
			Element string = doc.createElement("string");
			string.appendChild(doc.createTextNode(emailArray[i]));
			emails.appendChild(string);
		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("data/Persons.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}