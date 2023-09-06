package DbConnection;

import java.sql.*;

public class Myjdbc {
    Connection connection = null;

    public Connection database() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/librarysystem",
                    "root",
                    ""
            );
            /*String sql = "SELECT * FROM author";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
