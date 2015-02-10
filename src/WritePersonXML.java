package com.mkyong.core;
 
import java.io.File;
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
	
	public WritePersonXML{
		Person person = new Person();
		Name name = new Name();
		Address address = new Address();
	}
 
	public static void main() {
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("persons");
		doc.appendChild(rootElement);
 
		// person elements
		Element staff = doc.createElement("person");
		rootElement.appendChild(person);
 
		// code elements
		Element code = doc.createElement("code");
		code.appendChild(doc.createTextNode(person.getCode()));
		person.appendChild(code);
 
		// firstName elements
		Element firstName = doc.createElement("firstName");
		lastname.appendChild(doc.createTextNode(name.getFirstName()));
		person.appendChild(firstName);
 
		// lastName elements
		Element lastName = doc.createElement("lastName");
		nickname.appendChild(doc.createTextNode(name.getLastName));
		person.appendChild(lastName);
 
		// address elements
		Element address = doc.createElement("address");
		person.appendChild(address);
		
		Element street = doc.createElement("street");
		street.appendChild(doc.createTextNode(address.getStreet1()));
		address.appendChild(street);
		
		Element city = doc.createElement("city");
		city.appendChild(doc.createTextNode(address.getCity()));
		address.appendChild(city);
		
		Element state = doc.createElement("state");
		state.appendChild(doc.createTextNode(address.getState()));
		address.appendChild(state);
		
		Element country = doc.createElement("country");
		country.appendChild(doc.createTextNode(address.getCountry()));
		address.appendChild(country);
		
		Element zipcode = doc.createElement("zipcode");
		zipcode.appendChild(doc.createTextNode(address.getZip()));
		address.appendChild(zipcode);
		
		Element emails = doc.createElement("emails");
		person.appendChild(emails);
		
		Element string = doc.createElement("string");
		string.appendChild(person.getEmail());
		emails.appendChild(string);
		
		
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