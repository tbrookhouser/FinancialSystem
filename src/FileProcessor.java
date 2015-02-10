
public class FileProcessor {
	private PersonLog personLog;
	private WritePersonXML writePersonXml;
	
	public FileProcessor{
		this.PersonLog = new PersonLog();
		this.writePersonXml = new WritePersonXML();
	}
	
	public void processFile(fileName){
		personLog.splitPerson(fileName);
	}
	public static void main(String[] args){
		FileProcessor fileProcessor = new FileProcessor();
		
		fileProcessor.processFile("data/Persons.dat");
		
	}

}
