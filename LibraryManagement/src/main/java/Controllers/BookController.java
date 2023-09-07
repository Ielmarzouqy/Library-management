package Controllers;

import java.util.List;

import Models.Book;

public class BookController {
    public static void displayBook(){
        List<Book> books = new Book().getAllBooks();

        for( Book book :books){
            //System.out.println(book.getId());
            System.out.println("Book ID: " + book.getId());
            System.out.println("Collection ID: " + book.getCollection());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Is Lost: " + book.getIsLost());
            System.out.println("Available: " + book.getAvailable());
            System.out.println();
        }

    }
    public static void displayAvailableBooks() {
        List<Book> availableBooks = new Book().getAvailableBooks();
        for( Book book :availableBooks){
            //System.out.println(book.getId());
            System.out.println("Book ID: " + book.getId());
            System.out.println("Collection ID: " + book.getCollection());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Is Lost: " + book.getIsLost());
            System.out.println("Available: " + book.getAvailable());
            System.out.println();
        }
    }
}
