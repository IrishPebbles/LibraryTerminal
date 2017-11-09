import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Catalog {
	
	
	// THIS METHOD IS TO DETERMINE IF A LIBRARY ITEM IS CHECKED OUT. IF NOT, TO CHECK IT OUT
	public static ArrayList bookCheckout(String input, ArrayList<LibraryItem> arrayList1) {

		input = input.toLowerCase();
		

		for (int i = 0; i < arrayList1.size(); i++) {
			
			if (input.equalsIgnoreCase(arrayList1.get(i).getName())) {  // This tests to see if input is equal to the name of the item.
			if (arrayList1.get(i).getStatus().contains(" ")) { // This tests status to see if it is checked out or not
				if (arrayList1.get(i).getStatus().contains("checked out")) { // if book is checked out this is returned
					System.out.println(arrayList1.get(i).getName() + " is already checked out!");
					return arrayList1;
				}
				System.out.println("you checked out " + input); // if status isnt set to checked out, this will change it to checked out
				arrayList1.get(i).setStatus("checked out");
				System.out.println(arrayList1.get(i).getStatus());
				return arrayList1;
			}

		}
		}

		System.out.println("That wasn't an option!");

		return arrayList1;
	}
	
<<<<<<< HEAD
	//This will allow us to read from the text file.  
=======
	
	
	
	
	
	
>>>>>>> c97e9f3a85616746d33382ece52ade6af3fe280f
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
	
	//This method will allow us to transfer content from a text file into an ArrayList.  
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
