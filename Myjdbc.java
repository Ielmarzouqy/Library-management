package librarysystem;
import java.sql.*;
import java.sql.ResultSet;

import java.sql.*;

public class Myjdbc {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/librarysystem",
                    "root",
                    ""
            );
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM author");

            while(result.next()){
                System.out.println(result.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
