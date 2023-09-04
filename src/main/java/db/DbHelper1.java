package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper1 {
	public Connection getConnection() {
        Connection conn;
        try {
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletjsp_db", "root", "");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DbHelper1().getConnection());
    }
}
