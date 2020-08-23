class Library {
	String name;
	Address Location;
	List<BookItem> books;
}

class Address {
	int zipCode;
	String street;
	String city;
	String state;
	String country;
}

class Book {
	String uId;
	String title;
	List<Author> authors;
	BookType bookType;
}

class BookItem extends Book {
	String barCode;
	Date publicationDate;
	Rack rackLocation;
	BookStatus bookStatus;
	BookFormat bookFormat;
	Date issueDate;
}

public enum BookType {
	SCI-FI, ROMANTIC, FANTASY, DRAMA;
}

public enum BookFormat {
	HARDCOVER, PAPERBACK, NEWSPAPER, JOURNAL;
}

public enum BookStatus {
	ISSUES, AVAILABLE, RESERVED, LOST;
}

class Rack {
	int number;
	String locationId;
}

class Person {
	String firstName;
	String lastName;
}

class Author extends Person {
	List<Book> booksPublished;
	
}

class SystemUser extends Person {
	String email;
	String phone;
	Account account;
}

class Member extends SystemUser {
	int totalBooksCheckedOut;
	Search searchObj;
	BookIssueService issueService;
}

class Librarian extends SystemUser {
	Search searchObj;
	BookIssueService issueService;
	
	public void addBookItem(BookItem bookItem);
	public BookItem deleteBookItem(String barCode);
	public BookItem editBookItem(BookItem bookItem);
}

class Account {
	String userName;
	String password;
	int accountId;
}

class Search{
	public List<BookItem> getBookByTitle(String title);
	public List<BookItem> getBookByAuthor(Author author);
	public List<BookItem> getBookByType(BookType bookType);
	public List<BookItem> getBookByPublicationDate(Date publicationDate);
}

class BookIssueService {
	FineService fineService;
	
	public BookReservationDetail getReservationetail(BookItem bookItem);
	public void updateReservationDetail(BookReservationDetail bookReservationDetail);
	public BookReservationDetail reserveBook(BookItem bookItem, SystemUser user);
	public BookReservationDetail issueBook(BookItem bookItem, SystemUser user);
	public BookIssueDetail renewBook(BookItem bookItem, SystemUser user); 
	public void returnBook(BookItem book, SystemUser user);
}

class BookLending {
	BookItem book;
	Date startDate;
	SystemUser user;
}

class BookReservationDetail extends BookLending {
	ReservationStatus reservationStatus;
}

class BookIssueDetail extends BookLending {
	Date dueDate;
}

class FineService {
	public Fine calculateFine(BookItem bookItem, SystemUser user, int days);
}

class Fine {
	Date fineDate;
	BookItem bookItem;
	SystemUser user;
	Double fineValue;
}

	
	


	
	


