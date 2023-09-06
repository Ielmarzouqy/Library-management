package View;

import DbConnection.Myjdbc;

public class Main {
    public static void main(String[] args) {
        Myjdbc myjdbc = new Myjdbc();
        myjdbc.database();
    }
}
