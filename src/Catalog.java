import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Catalog {

	// THIS METHOD IS TO DETERMINE IF A LIBRARY ITEM IS CHECKED OUT. IF NOT, TO
	// CHECK IT OUT
	public static ArrayList bookCheckout(String input, ArrayList<Book> arrayList1) {
		Date dateOfOrder;
		dateOfOrder = new Date();
		int noOfDays = 14; // 2 week return time
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfOrder);
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays); // adds the 2 weeks to the date for retrning
		Date returnDate = calendar.getTime();
		String returnTime = "Return " + returnDate.toString(); // creates the string for date to input

		input = input.toLowerCase();

		for (int i = 0; i < arrayList1.size(); i++) {

			if (input.equalsIgnoreCase(arrayList1.get(i).getName())) { // This tests to see if input is equal to the
																		// name of the item.
				if (arrayList1.get(i).getStatus().contains("(Available)")) { // This tests status to see if it is
																				// checked out or not
					if (arrayList1.get(i).getStatus().contains("Checked out")) { // if book is checked out this is
																					// returned
						System.out.println(arrayList1.get(i).getName() + " is already checked out!");
						return arrayList1;
					}
					System.out.println("you checked out " + arrayList1.get(i).getName()); // if status isnt set to
																							// change it to checked out
					arrayList1.get(i).setStatus("(Checked out)");
					arrayList1.get(i).setDate(returnTime);
					System.out.println("Must return by:" + arrayList1.get(i).getdate());
					return arrayList1;
				}
			}
		}

		System.out.println("That wasn't an option!");

		return arrayList1;
	}

	public static void SearchTitle(String input, ArrayList<Book> list) {
		String tempValue;
		input = input.toLowerCase();

		for (int i = 0; i < list.size(); i++) {
			tempValue = list.get(i).getName();

			if (tempValue.toLowerCase().contains(input.toLowerCase())) {
				System.out.println("\nTitle: " + list.get(i).getName() + ", Author: " + list.get(i).getAuthor());
			}
		}
		System.out.println("\nYour Search is complete.\n");
	}

	public static void SearchAuthor(String input, ArrayList<Book> list) {
		String tempValue;
		input = input.toLowerCase();

		for (int i = 0; i < list.size(); i++) {
			tempValue = list.get(i).getAuthor();
			if (tempValue.toLowerCase().contains(input.toLowerCase())) {
				System.out.println("\nTitle: " + list.get(i).getName() + ", Author: " + list.get(i).getAuthor());
			}
		}

		System.out.println("\nYour Search is complete.\n");
	}

	public static void readFromFile(String nameOfFile) {
		Path writeFile = Paths.get(nameOfFile);
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) { // IO Exception is the parent exception and will automatically handle the
									// FileNotFound Exception.
			e.printStackTrace();
		}
	}

	public static void displayArrayListFromFile() {
		BufferedReader bufReader = null;
		try {
			bufReader = new BufferedReader(new FileReader("BookList.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> listOfLines = new ArrayList<>();
		String line = null;
		try {
			line = bufReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			listOfLines.add(line);
			try {
				line = bufReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			bufReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(listOfLines);
	}

	public static ArrayList returnABook(String userChoice, ArrayList<Book> arrayList1) {
		userChoice = userChoice.toLowerCase();

		for (int i = 0; i < arrayList1.size(); i++) {

			if (userChoice.equalsIgnoreCase(arrayList1.get(i).getName())) {
				if (arrayList1.get(i).getStatus().contains("checked out")) {
					arrayList1.get(i).setStatus(" ");
					System.out.println("Thank you for returning: " + arrayList1.get(i));
				} else {
					System.out.println("You can't return a book that has not been checked out.");
				}
			}
		}
		return arrayList1;
	}
}