package Controllers;

import Models.Author;
import java.util.List;
import java.sql.*;

public class AuthorController {

    public static void displayAuthor(){
        List<Author> authors = new Author().getAllAuthors();

        for( Author author :authors){
            System.out.println(author.getName());
        }
    }



}
