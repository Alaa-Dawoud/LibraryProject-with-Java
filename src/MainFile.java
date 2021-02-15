
// Library project 
import java.util.Scanner;

public class MainFile {
	public static void main(String args[]) {
		Library myLibrary = new Library();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("_____________________________");
			System.out.println("Enter on of these operations: ");
			System.out.println("[add_book, getNumberOfBooks, getListOfGenres, search, borrow, return_book, exit]");
			System.out.print("operation: ");
			String user_input = input.nextLine();
			switch (user_input) {
			case ("add_book"):
				myLibrary.add_book();
				break;
			case ("getNumberOfBooks"):
				System.out.println(myLibrary.getNumberOfBooks());
				break;
			case ("getListOfGenres"):
				System.out.println(myLibrary.getListOfGenres());
				break;
			case ("search"):
				myLibrary.search();
				break;
			case ("borrow"):
				myLibrary.borrow();
				break;
			case ("return_book"):
				myLibrary.return_book();
				break;
			default: System.out.println("enter correct operation name");
			}
			if (user_input.equals("exit")) {
				break;
			}
		}
	}
}
