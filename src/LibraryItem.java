
public abstract class LibraryItem {
String name;
String idNum;
String status; //checked out or returned value 


LibraryItem() {
}


public LibraryItem(String name, String idNum, String checkOut, String return1) {
	super();
	this.name = name;
	this.idNum = idNum;
	this.status = checkOut;
	
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



public void setStatus(String checkOut) {
	this.status = status;
}









@Override
public String toString() {
	return "LibraryItem [name=" + name + ", idNum=" + idNum + ", status=" + status;
}
}
