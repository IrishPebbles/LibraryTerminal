import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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

		for (int i = 0; i < arrayList1.size(); i++) {

			if (arrayList1.get(i).getName().equalsIgnoreCase(input)) {
				// This tests to see if input is equal to the name of the item.
				if (arrayList1.get(i).getStatus().contains("Available")) { // This tests status to see if it is checked
																			// out or not

					System.out.println("you checked out " + arrayList1.get(i).getName()); // if status isnt set to
																							// change it to checked out
					arrayList1.get(i).setStatus("Checked out");
					arrayList1.get(i).setDate(returnTime);
					System.out.println("Must return by:" + arrayList1.get(i).getdate());
					return arrayList1;
				}
				if (arrayList1.get(i).getStatus().contains("Checked out")) { // if book is checked out this is returned
					System.out.println(arrayList1.get(i).getName() + " is already checked out!");
					return arrayList1;
				}
			}
		}

		System.out.println("That wasn't an option!");

		return arrayList1;
	}

	// reads from text file to write arraylist
	public static ArrayList readFromFile(ArrayList<Book> bookList) {
		Path writeFile = Paths.get("BookList.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {

				String[] lineArr = line.split("/ "); // Grabs the information on the line up until the point of finding
														// the back slash.
														// Then adds it to the array list accordingly.
				bookList.add(new Book(lineArr[0], lineArr[1], lineArr[2], lineArr[3], lineArr[4]));

				line = reader.readLine(); // scnr.nextLine essentially, pushes to the next line

			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	// Writes to the text file from the arraylist
	public static void writeToFile(ArrayList<Book> arrayList1) {
		Path writeFile = Paths.get("BookList.txt");
		File file = writeFile.toFile();
		try {

			PrintWriter out = new PrintWriter(new FileOutputStream(file));
			for (Book book : arrayList1) { // iterates through the arraylist to out print each array on a line
				out.println(book);
			}

			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found here...");
			e.printStackTrace();
		}

	}

	public static void libraryList(ArrayList<Book> arrayList1) { // used to print list of current library books and
																	// status

		for (int i = 0; i < arrayList1.size(); i++) {
			System.out.print(String.format("%-30s", "Title: " + arrayList1.get(i).getName()));
			System.out.print(String.format("%-30s", "Author: " + arrayList1.get(i).getAuthor()));
			System.out.print(String.format("%-30s", "This book is currently: " + arrayList1.get(i).getStatus() + "\n"));

		}

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
		System.out.println("\nYour Search is complete.");
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

		System.out.println("\nYour Search is complete.");
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

		// Goes through our entire book arraylist.
		for (int i = 0; i < arrayList1.size(); i++) {
			// Checks to see if the user's selected book is the correct one and
			// if it's been checked out. If it's been checked out, it changes that book's
			// status to
			// available and also resets the date.
			if (userChoice.equalsIgnoreCase(arrayList1.get(i).getName())) {
				if (arrayList1.get(i).getStatus().contains("Checked out")) {
					arrayList1.get(i).setStatus("Available");
					arrayList1.get(i).setDate(" ");
					System.out.println("Thank you for returning: " + arrayList1.get(i).getName());
				} else {
					System.out.println("You can't return a book that has not been checked out.");
				}
			}
		}
		return arrayList1;
	}
}