import java.sql.*;

public class Connections {
    static String url = "jdbc:mysql://localhost:3306/db00";
    static String user = "root";
    static String password = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
