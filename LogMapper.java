package DataAccess;

import Business.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class LogMapper {

    public static String save(Log log) {

        try {
            Connection connection = MySQLConnector.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call insertLog(?,?,?)}");
            callableStatement.setInt("employeeID", log.getEmployeeID());
            callableStatement.setString("action", log.getAction());
            callableStatement.setTimestamp("date", new Timestamp(log.getDate().getTime()));
            callableStatement.executeQuery();
            callableStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Inserted successfully";

    }

    public static ArrayList<Log> getLogs(int employeeID, Date fromDate, Date toDate) {
        try {
            Connection connection = MySQLConnector.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call getLogs(?,?,?)}");
            callableStatement.setInt("employeeID", employeeID);
            callableStatement.setTimestamp("fromDate", new Timestamp(fromDate.getTime()));
            callableStatement.setTimestamp("toDate", new Timestamp(toDate.getTime()));
            ResultSet resultSet = callableStatement.executeQuery();
            ArrayList<Log> logArrayList = new ArrayList<Log>();
            while (resultSet.next()) {
                logArrayList.add(new Log(resultSet.getInt("employeeID"), resultSet.getString("action"), resultSet.getTimestamp("date")));
            }
            callableStatement.close();
            connection.close();
            return logArrayList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}