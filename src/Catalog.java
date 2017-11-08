import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Catalog {
	
	public static void readFromFile(String nameOfFile) {
		Path writeFile = Paths.get(nameOfFile);
		File file = writeFile.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			//This is a buffer and the benefit of using this is to store 
			//a block of memory that we can read data from later -- more efficient than scanner and it will not cause 
			BufferedReader reader = new BufferedReader(fr);
			//This is attempting to read the first line from the document
			String line = reader.readLine();
		while(line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();	
		} catch (IOException e) { //IO Exception is the parent exception and will automatically handle the FileNotFound Exception.
			e.printStackTrace();
		}
	}
	
	public static void displayArrayListFromFile() {
		BufferedReader bufReader = null;
		try {
			bufReader = new BufferedReader(new 
					FileReader("BookList.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				ArrayList<String> listOfLines = new ArrayList<>();
				String line = null;
				try {
					line = bufReader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} while (line != null)
				{
				    listOfLines.add(line);
				    try {
						line = bufReader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				try {
					bufReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				System.out.println(listOfLines);
	}
	
	
}
