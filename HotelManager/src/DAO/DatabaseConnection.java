package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?useSSL=false","root","123456");
    }
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
