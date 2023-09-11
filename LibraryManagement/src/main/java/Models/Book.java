package Models;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import DbConnection.Myjdbc;

public class Book {

    Myjdbc conn1 = new Myjdbc();

    public int id;
    public Collection collection;
    public float price;
    public static boolean available ;
    public boolean islost;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCollection(int cllection) {
        this.collection = collection;

    }
    public Collection getCollection(){
        return collection;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
    public void setAvailable(Boolean available2) {
        this.available = available2;
    }
    public static boolean  getAvailable() {

        return 	available;
    }
    public void setIsLost(boolean islost) {
        this.islost = islost;
    }
    public boolean getIsLost() {
        return islost;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT b.*, c.id AS isbn FROM book b " +
                "INNER JOIN collection c ON b.isbn = c.id";
        try {
            Connection connection = conn1.database();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setCollection(resultSet.getInt("isbn"));
                book.setPrice(resultSet.getFloat("price"));
                book.setIsLost(resultSet.getBoolean("lostbook"));
                book.setAvailable(resultSet.getBoolean("available"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book readBook(int id) {
        return null;
    }

    public Book readBook(String SBIN) {
        return null;
    }
    public void createBook() throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);

            //System.out.println("Is the book available? (true/false): ");
           // boolean available = scanner.nextBoolean();
          //  System.out.println("Is the book islost? (true/false): ");
           // boolean islost = scanner.nextBoolean();
            System.out.println("Enter Price: ");
            float price = scanner.nextFloat();
            System.out.println("Enter Collection ID: ");
            int collectionId = scanner.nextInt();
            String sql = "INSERT INTO book ( `price`, `available`, `lostbook`, `isbn`) VALUE (?,true,false,?)";
            try(
                Connection connection = conn1.database();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setFloat(1, price);
               // preparedStatement.setBoolean(2,available);
               // preparedStatement.setBoolean(3, islost);
                preparedStatement.setInt(2, collectionId);
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected>0) {
                    System.out.println("book added succcessfuly");
                }else {
                    System.out.println("failed to add book");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchBookByTitle() {
        Book book = null;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the title of the book:");
            String title = scanner.nextLine();
            String sql = "SELECT * FROM `book` inner join collection  on book.isbn = collection.id INNER join author on collection.author = author.id where title =?";

            try ( Connection connection = conn1.database();
                  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, title);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    book = new Book();
                    //book.collection(resultSet.getCollection());
                    book.setId(resultSet.getInt("id"));

                    int bookId = resultSet.getInt("book.id");
                    float bookPrice = resultSet.getFloat("book.price");
                    System.out.println("Book ID: " + bookId);
                    System.out.println("Book price: " + bookPrice);
                }
            }} catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchBookByAuthor() {
        Book book = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the author of the book:");
            String name = scanner.nextLine();
            String sql = "SELECT * FROM `book` inner join collection  on book.isbn = collection.id INNER join author on collection.author = author.id where name =?";
            try ( Connection connection = conn1.database();
                  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    book = new Book();
                    //book.collection(resultSet.getCollection());
                    book.setId(resultSet.getInt("id"));
                    int bookId = resultSet.getInt("book.id");
                    float bookPrice = resultSet.getFloat("book.price");
                    System.out.println("Book ID: " + bookId);
                    System.out.println("Book price: " + bookPrice);
                }
            }} catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `book` WHERE available =  true";
            try(
                    Connection connection = conn1.database();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setCollection(resultSet.getInt("isbn"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setIsLost(resultSet.getBoolean("lostbook"));
                    book.setAvailable(resultSet.getBoolean("available"));
                    availableBooks.add(book);
                }
            }} catch (SQLException e) {
            e.printStackTrace();
        }
        return availableBooks;
    }
    public void deleteBookById() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the ID of the book to delete:");
            int bookId = scanner.nextInt();

            String sql = "DELETE FROM book WHERE id = ?";

            try (Connection connection = conn1.database();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setInt(1, bookId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Author with ID " + bookId + " deleted successfully.");
                } else {
                    System.out.println("Author with ID " + bookId + " not found or deletion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBookById() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the ID of the book to update:");
            int bookId = scanner.nextInt();

            System.out.println("Enter the new price for the book:");
            scanner.nextLine();
            float newPrice = scanner.nextFloat();
            System.out.println("Enter the new availability for the book:");
            scanner.nextLine();
            boolean newstatus = scanner.nextBoolean();

            System.out.println("Enter the book is messing for the book:");
            scanner.nextLine();
            boolean lostBook = scanner.nextBoolean();
            System.out.println("Enter the new isbn for the book:");
            scanner.nextLine();
            int newIsbn = scanner.nextInt();

            String sql = "UPDATE book SET price =?, available=?,lostbook=?,isbn=?  WHERE id = ?";

            try (Connection connection = conn1.database();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setFloat(1, newPrice);
                preparedStatement.setBoolean(2, newstatus);
                preparedStatement.setBoolean(3, lostBook);
                preparedStatement.setInt(4, newIsbn);
                preparedStatement.setInt(5, bookId);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Author with ID " + bookId + " updated successfully.");
                } else {
                    System.out.println("Author with ID " + bookId + " not found or update failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Book> getNonAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `book` WHERE available =  false";
            try(
                    Connection connection = conn1.database();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setCollection(resultSet.getInt("isbn"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setIsLost(resultSet.getBoolean("lostbook"));
                    book.setAvailable(resultSet.getBoolean("available"));
                    availableBooks.add(book);
                }
            }} catch (SQLException e) {
            e.printStackTrace();
        }
        return availableBooks;
    }

    public void statisticBooks() {
        try {
            Connection connection = conn1.database();

            String availableBooksQuery = "SELECT COUNT(*) FROM book WHERE available = ?";
            PreparedStatement availableBooksStatement = connection.prepareStatement(availableBooksQuery);
            availableBooksStatement.setBoolean(1, true);
            ResultSet availableBooksResult = availableBooksStatement.executeQuery();
            int availableBookCount = 0;

            if (availableBooksResult.next()) {
                availableBookCount = availableBooksResult.getInt(1);
            }
            String borrowedBooksQuery = "SELECT COUNT(*) FROM book WHERE available = ?";
            PreparedStatement borrowedBooksStatement = connection.prepareStatement(borrowedBooksQuery);
            borrowedBooksStatement.setBoolean(1, false);
            ResultSet borrowedBooksResult = borrowedBooksStatement.executeQuery();
            int borrowedBookCount = 0;

            if (borrowedBooksResult.next()) {
                borrowedBookCount = borrowedBooksResult.getInt(1);
            }

            System.out.println("Book Statistics:");
            System.out.println("Available Books: " + availableBookCount);
            System.out.println("Borrowed Books: " + borrowedBookCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void messingBooksCount(){
        String missingBooksql = "SELECT COUNT(*) FROM book WHERE lostbook = ?";

        try(
                Connection connection = conn1.database();

                PreparedStatement missingBooksStatement = connection.prepareStatement(missingBooksql);

        ) {
            missingBooksStatement.setBoolean(1, true);
            ResultSet availableBooksResult = missingBooksStatement.executeQuery();
            int lostbooks =0;
            if(availableBooksResult.next()){
                lostbooks = availableBooksResult.getInt(1);
                System.out.println("missing Books: " + lostbooks);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
}
