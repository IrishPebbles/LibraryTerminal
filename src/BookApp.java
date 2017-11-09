import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BookApp {

	public static void main(String[] args) {
		DateFormat dateFormat  = new SimpleDateFormat("yyyy/MM/dd");
		Date dateOfOrder;
		dateOfOrder = new Date();
		int noOfDays = 14;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfOrder);
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date returnDate = calendar.getTime();
		String returnTime = "Return " + returnDate.toString();
		System.out.println("Hello Books!");
		System.out.println("Goodbye!");
		Book book1 = new Book("StarWars", "101", "(Available)", " ", "George Lucas");
		Book book2 = new Book("Harry potter", "102", "(Checked out)", returnTime, "J.K. Rowling");
		Book book3 = new Book("Lord of the Rings", "103", "(Available)", " ", "J. R. R. Tolkien");
		ArrayList<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		System.out.println(bookList);
		
		
				
				
		

		// 1. User Menu with 6 options
		
		// 2. Class to decide based on options
		
		// 3. re-loop
		
		
		// ?. Save back to text file
	}

}
