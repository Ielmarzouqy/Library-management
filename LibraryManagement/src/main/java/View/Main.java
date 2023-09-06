package View;

import DbConnection.Myjdbc;
import Controllers.AuthorController;

public class Main {
    public static void main(String[] args) {
        Myjdbc myjdbc = new Myjdbc();
        myjdbc.database();
        AuthorController authorController = new AuthorController();
        authorController.displayAuthor();

    }
}
