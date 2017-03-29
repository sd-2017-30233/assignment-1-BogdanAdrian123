package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {

	private static final String URL = "jdbc:mysql://localhost/bank";
	private static final String USERNAME = "bogdan";
	private static final String PASSWORD = "bogdan";

	    public static Connection getConnection() {
	        Connection connection = null;

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
      
	        return connection;
	    }
	
}
