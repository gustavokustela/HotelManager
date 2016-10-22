package Serializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Gabriel Quadrado on 24/09/2016.
 */
public class DatabaseConnection {
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanager");
    }
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
