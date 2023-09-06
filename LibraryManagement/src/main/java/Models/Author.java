package Models;

import DbConnection.Myjdbc;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Author {
    Myjdbc conn1 = new Myjdbc();
public void Author(Connection connection){
   // this.connection = connection;
}
        public int id;
        public String name;
    //public Author(String name) {
    //    this.name = name;
   // }

   // public Author() {
 //   }
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
        }
        public List<Author> getAllAuthors(){
            List<Author> authors = new ArrayList<>();
            String sql = "SELECT * FROM author";
            try {
                Connection connection = conn1.database();
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

}

