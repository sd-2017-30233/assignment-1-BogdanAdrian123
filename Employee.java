package Business;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccess.MySQLConnector;

public class Employee {

	private static int employeeID;
	
	
	 public static String insert(int employeeID,String username,String password,String name,int role)
	    {
	        Connection connection= MySQLConnector.getConnection();
	        try {
	            CallableStatement callableStatement = connection.prepareCall("{call insertEmployee(?,?,?,?,?)}");
	            callableStatement.setInt("employeeID",employeeID);
	            
	            callableStatement.setString("username", username);
	            callableStatement.setString("password", password);
	            callableStatement.setString("name", name);
	            callableStatement.setInt("role", role);
	            callableStatement.executeQuery();
	            callableStatement.close();
	            connection.close();
	        } catch (SQLException sqlException)
	        {
	            sqlException.printStackTrace();
	            return sqlException.getMessage();
	        }
	        return "Inserted successfully";
	    }
	 
	 public static String delete(int employeeID) {
	        Connection connection = MySQLConnector.getConnection();
	        try {
	            CallableStatement callableStatement = connection.prepareCall("{call deleteEmployee(?)}");
	            callableStatement.setInt("employeeID",employeeID);
	            callableStatement.executeQuery();
	            callableStatement.close();
	            connection.close();
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            return null;
	        }
	        return "Deleted successfully";
	    }
	 
	 public static String update(int employeeID,String username,String password,String name,int role) {

	        Connection connection= MySQLConnector.getConnection();
	        try {
	            CallableStatement callableStatement = connection.prepareCall("{call updateEmployee(?,?,?,?,?)}");
	            callableStatement.setInt("employeeID",employeeID);
	    
	            callableStatement.setString("username", username);
	            callableStatement.setString("password", password);
	            callableStatement.setString("name", name);
	            callableStatement.setInt("role", role);
	            callableStatement.executeQuery();
	            callableStatement.close();
	            connection.close();
	        } catch (SQLException sqlException)
	        {
	            sqlException.printStackTrace();
	            return sqlException.getMessage();
	        }
	        return "Updated successfully";
	    }
	 
	 public static String login(String username, String password)
	    {
	        Connection connection= MySQLConnector.getConnection();
	        try{
	            CallableStatement cs = connection.prepareCall("{call login(?,?)}");
	            cs.setString("username",username);
	            cs.setString("password", password);
	            ResultSet rs = cs.executeQuery();

	            while(rs.next()){
	               setEmployeeID(rs.getInt("employeeID"));
	                if (rs.getInt("role")==1) return "Admin logged in";
	                else return "User logged in";
	            }
	            rs.close();
	            cs.close();
	        }
	        catch(SQLException sqlException)

	        {
	            sqlException.printStackTrace();
	        }
	        return "invalid login";
	    }
	 
	 public static int getEmployeeID() {
	        return employeeID;
	    }

	    public static void setEmployeeID(int employeeID) {
	        Employee.employeeID = employeeID;
	    }
	    
	    public  static Object[][] getEmployees()
	    {
	        try {
	            Connection connection=MySQLConnector.getConnection();
	            CallableStatement callableStatement = connection.prepareCall("{call getEmployees()}");
	            ResultSet resultSet=callableStatement.executeQuery();
	            int n=0;
	            while (resultSet.next()) n++; 
	            resultSet.beforeFirst();
	            Object[][] data=new Object[n][5];
	            int i=0;
	            while (resultSet.next())
	            {
	                data[i][0]=resultSet.getInt("employeeID");
	                data[i][1]=resultSet.getString("username");
	                data[i][2]=resultSet.getString("password");
	                data[i][3]=resultSet.getString("name");
	                data[i][4]=resultSet.getInt("role");
	                i++;
	            }
	            callableStatement.close();
	            connection.close();
	            return data;
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            return null;
	        }
	    }

	    public static Object[][] getEmployee(int id) {
	        try {
	            Connection connection = MySQLConnector.getConnection();
	            CallableStatement callableStatement = connection.prepareCall("{call getEmployee(?)}");
	            callableStatement.setInt("ID",id);
	            ResultSet resultSet=callableStatement.executeQuery();
	            Object[][] data=new Object[1][5];
	            int i=0;
	            while (resultSet.next())
	            {
	            	    data[i][0]=resultSet.getInt("employeeID");
		                data[i][1]=resultSet.getString("username");
		                data[i][2]=resultSet.getString("password");
		                data[i][3]=resultSet.getString("name");
		                data[i][4]=resultSet.getInt("role");
	            }
	            callableStatement.close();
	            connection.close();
	            return data;
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            return null;
	        }
	    }
}
