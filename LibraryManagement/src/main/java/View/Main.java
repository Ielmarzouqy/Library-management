package View;

import DbConnection.Myjdbc;

import java.sql.SQLException;

import Controllers.AuthorController;
import Controllers.BookController;

import Models.Author;
import Models.Book;
import Models.BorrowBook;

import Models.Collection;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Myjdbc myjdbc = new Myjdbc();
        myjdbc.database();
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();
        Author author = new Author();
        Book book = new Book();
        Collection collection = new Collection();
        BorrowBook borrowBook = new BorrowBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Display Authors");
            System.out.println("2. Display Books");
            System.out.println("3. Display Available Books");
            System.out.println("4. Create Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Create Author");
            System.out.println("8. Delete Author by ID");
            System.out.println("9. Update Author by ID");
            System.out.println("10. Delete Book");
            System.out.println("11. Update Book");

            System.out.println("12. Borrow Book");
           System.out.println("13. Non available  Book");
            System.out.println("14. Return  Book");
            System.out.println("15. get statistic of books");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    authorController.displayAuthor();
                    break;
                case 2:
                    bookController.displayBook();
                    break;
                case 3:
                    bookController.displayAvailableBooks();
                    break;
                case 4:
                    book.createBook();
                    break;
                case 5:
                    book.searchBookByTitle();
                    break;
                case 6:
                    book.searchBookByAuthor();
                    break;
                case 7:
                    author.createAuthor();
                    break;
                case 8:
                    author.deleteAuthorById();
                    break;
                case 9:
                    author.updateAuthorById();
                    break;
                case 10:
                    book.deleteBookById();
                    break;
                case 11:
                    book.updateBookById();
                    break;
                case 12:
                    borrowBook.borrowingBook();
                    break;
                case 13:
                    bookController.displayNonAvailableBooks();
                    break;
                case 14:
                   borrowBook.returnBook();
                   break;
                case 15:
                    book.statisticBooks();
                case 16:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 16);

        scanner.close();
    }
}
