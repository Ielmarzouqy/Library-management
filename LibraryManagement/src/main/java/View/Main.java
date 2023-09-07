package View;

import DbConnection.Myjdbc;

import java.sql.SQLException;

import Controllers.AuthorController;
import Controllers.BookController;

import Models.Author;
import Models.Book
        ;

import Models.Collection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Myjdbc myjdbc = new Myjdbc();
        myjdbc.database();
        AuthorController authorController = new AuthorController();
        authorController.displayAuthor();
        Author author = new Author();

        BookController bookController = new BookController();
         //bookController.displayBook();
        //bookController.displayAvailableBooks();

        Book book = new Book();
        //book.createBook();

        //book.searchBookByTitle();
        //book.searchBookByAuthor();
        //author.createAuthor();
        //authorController.showAuthor();


        // author.deleteAuthorById();
        //author.updateAuthorById();
        // author.setId(1); // Set the author's ID
        // Collection collection = new Collection();
        //collection.insertCollection();
        //collection.setTitle("My Collection");
        //collection.setAuthor(author);
    }
}
