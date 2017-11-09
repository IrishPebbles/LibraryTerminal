import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		String userInput; // string to accept user input
		Scanner scnr = new Scanner(System.in); 
		
		DateFormat dateFormat  = new SimpleDateFormat("yyyy/MM/dd"); // setting up dates
		Date dateOfOrder;
		dateOfOrder = new Date();
		int noOfDays = 14; // 2 week return time
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfOrder);
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays); // adds the 2 weeks to the date for retrning
		Date returnDate = calendar.getTime(); 
		String returnTime = "Return " + returnDate.toString(); // creates the string for date to input
		
		System.out.println("Hello Books!");
		System.out.println("Goodbye!");
		Book book1 = new Book("StarWars", "101", "(Available)", " ", "George Lucas");
		Book book2 = new Book("Harry potter", "102", "Checked out", returnTime, "J.K. Rowling");
		Book book3 = new Book("Lord of the Rings", "103", "(Available)", " ", "J. R. R. Tolkien");
		ArrayList<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		System.out.println("What book would you like to check out?");
		userInput = scnr.nextLine();
		Catalog.bookCheckout(userInput, bookList);
		System.out.println(bookList);
		
		
		
		
				
				
		

		// 1. User Menu with 6 options
		
		// 2. Class to decide based on options
		
		// 3. re-loop
		
		
		// ?. Save back to text file
	}

}
