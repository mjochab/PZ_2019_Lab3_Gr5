package wypozyczalnia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;




public class DBConnector {

    public static Connection getConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

        return connection;
    }
    
}
