package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private static String jdbcURL;
    private static String jdbcUserName;
    private static String jdbcPassword;
    private static Connection jdbcConnection;

    public DbHelper() {
        DbHelper.jdbcURL = "jdbc:mysql://localhost:3306/servletjsp_db";
        DbHelper.jdbcUserName = "root";
        DbHelper.jdbcPassword = "";
    }

    public void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}
