
public class Book extends LibraryItem {

	private String author = " ";

	public Book(String name, String author, String idNum, String status, String date) {
		super(name, idNum, status, date);
		this.author = author;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String LibraryItem() {
		return null;
	}

	@Override
	public String toString() {
		return name + "/ " + author + "/ " + idNum + "/ " + status + "/ " + date;
	}
}
