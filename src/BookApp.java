import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		String userInput = " "; // string to accept user input
		String menuPrompt = " ";
		int userChoice = 0; 	// user menu selection
		int noOfDays = 14; // 2 week return time
		
		ArrayList<Book> bookList = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		Date dateOfOrder = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfOrder);
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays); // adds the 2 weeks to the date for retrning
		Date returnDate = calendar.getTime();
		String returnTime = " Return " + returnDate.toString(); // creates the string for date to input

		Book book1 = new Book("StarWars", "101", "(Available)", " ", "George Lucas");
		Book book2 = new Book("Harry potter", "102", "(Checked out)", returnTime, "J.K. Rowling");
		Book book3 = new Book("Lord of the Rings", "103", "(Available)", " ", "J. R. R. Tolkien");
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		/*
		 * System.out.println("What book would you like to check out?"); userInput =
		 * scnr.nextLine(); Catalog.bookCheckout(userInput, bookList);
		 * System.out.println(bookList);
		 */


		while (userChoice != 6) {
			// 1. User Menu with 6 options
			userChoice = menu(scnr, userChoice);

			// 2. Switch to decide based on options
			switch (userChoice) {
			case 1:
				// method that lists books
				break;
			case 2:
				menuPrompt = "Please enter search term\n";
				userInput = Validator.getString(scnr, menuPrompt);
				Catalog.SearchAuthor(userInput, bookList);
				break;
			case 3:
				menuPrompt = "Please enter search term\n";
				userInput = Validator.getString(scnr, menuPrompt);
				Catalog.SearchTitle(userInput, bookList);
				break;
			case 4:
				menuPrompt = "Please enter book name\n";
				userInput = Validator.getString(scnr, menuPrompt);
				Catalog.bookCheckout(userInput, bookList);
				break;
			case 5:
				menuPrompt = " \n"; //TODO: figure out what this looks like
				userInput = Validator.getString(scnr, menuPrompt);
				Catalog.returnABook(userInput, bookList);
				break;
			case 6:
				System.out.println("Thank you! Good-Bye!");
				break;
			default:
				System.out.println();
				break;
			}
		}

		// ?. Save back to text file
	}

	public static int menu(Scanner sc, int i) {

		String prompt = 
				"Please select one of the options below.\n" 
				+ "\t1. Display list of books\n"
				+ "\t2. Search for a book by AUTHOR\n" 
				+ "\t3. Search for a book by TITLE Keyword"
				+ "\t4. Select a book from the list to check out" 
				+ "\t5. Return a book" 
				+ "\t6. Quit";

		return Validator.getInt(sc, prompt, 1, 6);
	}
}
