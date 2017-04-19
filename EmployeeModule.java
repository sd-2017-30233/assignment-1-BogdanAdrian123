package Business;

import DataAccess.MySQLConnector;

import java.sql.*;

public class EmployeeModule {

    private static int currentEmployeeID;

    public static String login(String username, String password)
    {
        Connection connection= MySQLConnector.getConnection();
        try{
            CallableStatement cs = connection.prepareCall("{call login(?,?)}");
            cs.setString("username",username);
            cs.setString("password", password);
            ResultSet rs = cs.executeQuery();

            while(rs.next()){
               setCurrentEmployeeID(rs.getInt("ID"));
                if (rs.getInt("admin")==1) return "Admin logged in";
                else return "Employee logged in";
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

    public static String insert(int ID,String name,String username,String password,int admin)
    {
        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call insertEmployee(?,?,?,?,?)}");
            callableStatement.setInt("ID",ID);
            callableStatement.setString("name", name);
            callableStatement.setString("username", username);
            callableStatement.setString("password", password);
            callableStatement.setInt("admin", admin);
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

    public static String update(int oldID,int ID,String name,String username,String password,int admin) {

        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call updateEmployee(?,?,?,?,?,?)}");
            callableStatement.setInt("oldID",oldID);
            callableStatement.setInt("ID",ID);
            callableStatement.setString("name", name);
            callableStatement.setString("username", username);
            callableStatement.setString("password", password);
            callableStatement.setInt("admin", admin);
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

    public  static Object[][] getEmployees()
    {
        try {
            Connection connection=MySQLConnector.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call getEmployees()}");
            ResultSet resultSet=callableStatement.executeQuery();
            int n=0;
            while (resultSet.next()) n++; //n=no. of rows
            resultSet.beforeFirst();
            Object[][] data=new Object[n][4];
            int i=0;
            while (resultSet.next())
            {
                data[i][0]=resultSet.getInt("ID");
                data[i][1]=resultSet.getString("name");
                data[i][2]=resultSet.getString("username");
                data[i][3]=resultSet.getInt("admin");
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
            Object[][] data=new Object[1][4];
            while (resultSet.next())
            {
                data[0][0]=resultSet.getInt("ID");
                data[0][1]=resultSet.getString("name");
                data[0][2]=resultSet.getString("username");
                data[0][3]=resultSet.getInt("admin");
            }
            callableStatement.close();
            connection.close();
            return data;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static String delete(int id) {
        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call deleteEmployee(?)}");
            callableStatement.setInt("ID",id);
            callableStatement.executeQuery();
            callableStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return "Deleted successfully";
    }

    public static int getCurrentEmployeeID() {
        return currentEmployeeID;
    }

    public static void setCurrentEmployeeID(int currentEmployeeID) {
        EmployeeModule.currentEmployeeID = currentEmployeeID;
    }
}