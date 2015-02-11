import java.io.IOException;


public class FileProcessor {
	private PersonLog personLog;
	
	public FileProcessor(){
		this.personLog = new PersonLog();
	}
	
	public void processFile(String fileName) throws IOException{
		personLog.splitPerson(fileName);
	}
	
	public static void main(String[] args) throws IOException{
		FileProcessor fileProcessor = new FileProcessor();
		
		fileProcessor.processFile("data/Persons.dat");
		
	}

}
