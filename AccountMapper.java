package DataAccess;
import Business.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountMapper {

    public static String insert(Account account)
    {
        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call insertAccount(?,?,?,?,?)}");
            callableStatement.setInt("ID",account.getID());
            callableStatement.setString("type", account.getType());
            callableStatement.setLong("funds", account.getFunds());
            callableStatement.setLong("ownerPNC", account.getOwnerPNC());
            callableStatement.setTimestamp("creationDate", new Timestamp(account.getCreationDate().getTime()));
            callableStatement.executeQuery();
            callableStatement.close();
            connection.close();
        } catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            if (sqlException.getMessage().contains("foreign key")) return "The owner of the account should already exist as a client";
            else return sqlException.getMessage();
        }
        return "Inserted successfully";
    }

    public static String update(int oldID, Account account) {

        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call updateAccount(?,?,?,?,?)}");
            callableStatement.setInt("oldID",oldID);
            callableStatement.setInt("ID", account.getID());
            callableStatement.setString("type", account.getType());
            callableStatement.setLong("funds", account.getFunds());
            callableStatement.setLong("ownerPNC", account.getOwnerPNC());
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

    public static ArrayList<Account> getAccounts() {
        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call getAccounts()}");
            ResultSet resultSet=callableStatement.executeQuery();
            ArrayList<Account> AccountArrayList=new ArrayList<Account>();
            while (resultSet.next())
            {
                AccountArrayList.add(new Account(resultSet.getInt("ID"),resultSet.getString("type"),resultSet.getLong("funds"),resultSet.getLong("ownerPNC"),resultSet.getTimestamp("creationDate")));
            }
            callableStatement.close();
            connection.close();
            return AccountArrayList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static Account getAccount(int id) {
        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call getAccount(?)}");
            callableStatement.setInt("id",id);
            ResultSet resultSet=callableStatement.executeQuery();
            Account account=null;
            while (resultSet.next())
            {
                account=new Account(resultSet.getInt("ID"),resultSet.getString("type"),resultSet.getLong("funds"),resultSet.getLong("ownerPNC"),resultSet.getTimestamp("creationDate"));
            }
            callableStatement.close();
            connection.close();
            return account;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static String delete(int id) {
        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call deleteAccount(?)}");
            callableStatement.setInt("id",id);
            callableStatement.executeQuery();
            callableStatement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return "Deleted successfully";
    }
}