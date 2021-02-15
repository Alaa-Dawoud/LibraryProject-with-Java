
public class Book {
	// properties for the book
	private String book_name, book_author, genre, dept_name;
	private boolean is_borrowed = false;
	
	// constructor for the book object
	public Book(String book_name, String book_author,
			String genre, String dept_name) {
		this.book_name = book_name;
		this.book_author = book_author;
		this.genre = genre;
		this.dept_name = dept_name;
	}
	// getter for the object properties
	public String getBook_name() {
		return book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public String getGenre() {
		return genre;
	}
	public String getDept_name() {
		return dept_name;
	}
	public boolean isIs_borrowed() {
		return is_borrowed;
	}
	// is_borrowed might change
	public void setIs_borrowed(boolean is_borrowed) {
		this.is_borrowed = is_borrowed;
	}
	
}
