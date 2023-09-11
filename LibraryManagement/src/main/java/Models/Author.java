package Models;

import DbConnection.Myjdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Author {
    Myjdbc conn1 = new Myjdbc();
    Connection connection = conn1.database();
    public void Author(Connection connection){
        // this.connection = connection;
    }
        public int id;
        public String name;
    public void setId(int id) {
        this.id = id;
    }

        public int getId() {
            return id;
        }
    public void setName(String name) {
        this.name = name;
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
                    try {
                        Scanner scanner = new Scanner(System.in);

                        System.out.println("Enter the author's name:");
                        String authorName = scanner.nextLine();

                        String sql = "INSERT INTO author (name) VALUES (?)";

                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                            preparedStatement.setString(1, authorName);

                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Author inserted successfully.");
                            } else {
                                System.out.println("Failed to insert author.");
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


        }
        public List<Author> getAllAuthors(){
            List<Author> authors = new ArrayList<>();
            String sql = "SELECT * FROM author";
            try {
                //Connection connection = conn1.database();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Author author = new Author();
                    author.setId(resultSet.getInt("id"));
                    author.setName(resultSet.getString("name"));
                    authors.add(author);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return authors;
        }
    public void deleteAuthorById() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the ID of the author to delete:");
            int authorId = scanner.nextInt();

            String sql = "DELETE FROM author WHERE id = ?";

            try (//Connection connection = conn1.database();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, authorId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Author with ID " + authorId + " deleted successfully.");
                } else {
                    System.out.println("Author with ID " + authorId + " not found or deletion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAuthorById() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the author to update:");
            int authorId = scanner.nextInt();
            System.out.println("Enter the new name for the author:");
            scanner.nextLine();
            String newName = scanner.nextLine();
            String sql = "UPDATE author SET name = ? WHERE id = ?";
            try (//Connection connection = conn1.database();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, authorId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Author with ID " + authorId + " updated successfully.");
                } else {
                    System.out.println("Author with ID " + authorId + " not found or update failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

