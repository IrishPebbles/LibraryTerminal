
public class Book extends LibraryItem {

	private String author = " ";
	
	public Book(String name, String idNum, String status, String date, String author) {
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
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String LibraryItem() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + ", idNum=" + idNum + ", status=" + status + date;
	}
	
	

}
