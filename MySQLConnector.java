package DataAccess;

import java.sql.*;
public class MySQLConnector {


    public static Connection getConnection() {
       // Connection connection = null;

        try {
        	String driver="com.mysql.jdbc.Driver";
        	String url = "jdbc:mysql://localhost/assignment1";
        	String username = "root";
        	String password = "bogdan";
           Class.forName(driver);
          Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Conectare reusita");
        return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}