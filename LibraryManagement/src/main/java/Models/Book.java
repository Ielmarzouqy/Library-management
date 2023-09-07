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
    public boolean available;
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
    public boolean getAvailable() {
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
    public void deleteBook() {

    }
    





}
