package Models;
import DbConnection.Myjdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collection {
    Myjdbc conn1 = new Myjdbc();
        public int id;
        public String title;
        public Author author;
        public int quantity;

        /*public  Collection(int isbn, Author author,  String title, int quantity) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }*/

        public void setAuthor(Author author) {
            this.author = author;

        }
        public void setId(int id) {
            this.id = id;

        }
        public Author getAuthor() {
            return author;
        }
        public int getId() {
            return id;
        }
        public void setTitle(String title) {
            this.title = title;

        }
        public String getTitle() {
            return title;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;

        }
        public int getQuantity() {
            return quantity;
        }


        public Collection[] readCollectios(String text) {
            if(text == null) {

            }else {

            }
            return null ;
        }
    /*public void insertCollection(Collection collection) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the title of the collection:");
            String collectionTitle = scanner.nextLine();
            System.out.println("Enter the quantity of the collection:");
            String collectionQuantity = scanner.nextLine();

            System.out.println("Enter the author's ID for the collection:");
            int authorId = scanner.nextInt();

            String sql = "INSERT INTO collection (id, title, quantity,  author) VALUES (?, ?,?, ?)";

            try (Connection connection = conn1.database();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, collection.getId());
                preparedStatement.setString(1, collection.getTitle());
                preparedStatement.setInt(1, collection.getQuantity());
                preparedStatement.setInt(2, collection.getAuthor().getId());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Collection inserted successfully.");
                } else {
                    System.out.println("Failed to insert collection.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
