package Models;

import DbConnection.Myjdbc;

public class Author {
    Myjdbc myjdbc = new Myjdbc();

        public int id;
        public String name;

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        public Author readAuthor(int id) {
            return null;
        }

        public Author readAuthor(String name) {
            return null;
        }
        public void createAuthor() {

        }
}

