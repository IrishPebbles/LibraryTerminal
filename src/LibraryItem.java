
public abstract class LibraryItem {
	String name;
	String idNum;
	String status; // checked out or returned value. if returned " "
	String date; // date if the book is checked out or not

	public abstract String LibraryItem();

	public LibraryItem(String name, String idNum, String status, String date) {
		super();
		this.name = name;
		this.idNum = idNum;
		this.status = status;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getdate() {
		return date;
	}

	@Override
	public String toString() {
		return "LibraryItem [name=" + name + ", idNum=" + idNum + ", status=" + status;
	}
}
