
// the library class manages operations on books like add_book

// borrow, return, search(by name or author) and num of books and genres
import java.util.*;

public class Library {
	// properties for the Library
	private ArrayList<Book> listOfBooks = new ArrayList<Book>();
	// string in mapOfBorrowedBooks is the student name
	private Map<Integer, Integer> mapOfBorrowedBooks = new HashMap<Integer, Integer>();

	// add_book method
	void add_book() {
		// get from the user the information about the book (we can assume that the
		// index of the array is the book_id)
		Scanner add_book_input = new Scanner(System.in);
		// get book name
		System.out.print("Please Enter the book Name : ");
		String book_name = add_book_input.nextLine();
		// get book author
		System.out.print("Please Enter the book Author : ");
		String book_author = add_book_input.nextLine();
		// get book genre
		System.out.print("Please Enter the book Genre : ");
		String book_genre = add_book_input.nextLine();
		// get book department
		System.out.print("Please Enter the Department Name book belongs to : ");
		String book_dept = add_book_input.nextLine();
		listOfBooks.add(new Book(book_name, book_author, book_genre, book_dept));
		System.out.println("book has been added");
	}

	// method to get the number of books
	int getNumberOfBooks() {
		return listOfBooks.size();
	}

	// method to get a list of genres of library
	ArrayList<String> getListOfGenres() {
		ArrayList<String> list_of_genres = new ArrayList<String>();
		for (Book book : listOfBooks) {
			if (list_of_genres.contains(book.getGenre())) {
				continue;
			} else {
				list_of_genres.add(book.getGenre());
			}
		}
		return list_of_genres;
	}

	// search method for book by book name or author
	void search() {
		System.out.print("Please Enter book name or book author : ");
		Scanner search_input = new Scanner(System.in);
		String book_search_text = search_input.nextLine();
		int total_founds = 0;
		for (int i = 0; i < listOfBooks.size(); i++) {
			if ((listOfBooks.get(i).getBook_name().equals(book_search_text))
					|| (listOfBooks.get(i).getBook_author().equals(book_search_text))) {
				System.out.println("Book Found at id : " + i + " (index of the list).");
				System.out.println("Book Info ");
				System.out.println("book name: " + listOfBooks.get(i).getBook_name());
				System.out.println("book author: " + listOfBooks.get(i).getBook_author());
				System.out.println("book genre: " + listOfBooks.get(i).getGenre());
				System.out.println("book dept_name: " + listOfBooks.get(i).getDept_name());
				System.out.println("book borrow status: " + listOfBooks.get(i).isIs_borrowed());
				System.out.println("+++++++");
				total_founds++;
			}
		}
		if (total_founds>0) {
			System.out.println("found "+total_founds+" books");
		} else {
			System.out.println("The book is not exist.");
		}
	}

	// method to borrow a book
	void borrow() {
		System.out.print("Please enter student id : ");
		Scanner borrow_input = new Scanner(System.in);
		int student_id = borrow_input.nextInt();
		System.out.print("Please enter book_id: ");
		int book_id = borrow_input.nextInt();
		listOfBooks.get(book_id).setIs_borrowed(true);
		mapOfBorrowedBooks.put(student_id, book_id);
		System.out.println("book has been borrowed");
	}

	// method to return a book
	void return_book() {
		System.out.print("Please enter student id: ");
		Scanner return_book_input = new Scanner(System.in);
		int student_id = return_book_input.nextInt();
		if (!mapOfBorrowedBooks.containsKey(student_id)) {
			System.out.println("this student id is not in the borrow list");
			return;
		}
		listOfBooks.get(mapOfBorrowedBooks.get(student_id)).setIs_borrowed(false);
		mapOfBorrowedBooks.remove(student_id);
		System.out.println("book has been returned.");
	}

}
