package View;

import DbConnection.Myjdbc;
import Controllers.AuthorController;

import Models.Author;

public class Main {
    public static void main(String[] args) {
        Myjdbc myjdbc = new Myjdbc();
        myjdbc.database();
        AuthorController authorController = new AuthorController();
       // authorController.displayAuthor();
        Author author = new Author();
        // author.createAuthor();


       // int authorIdToDelete = 3;
       // author.deleteAuthorById();
        author.updateAuthorById();

    }
}
