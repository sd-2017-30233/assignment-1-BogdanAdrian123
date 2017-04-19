package DataAccess;

import Business.Client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientMapper {


    public static String insert(Client client)  {

        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call insertClient(?,?,?,?)}");
            callableStatement.setString("name",client.getName());
            callableStatement.setInt("icn", client.getIcn());
            callableStatement.setLong("pnc", client.getPnc());
            callableStatement.setString("address",client.getAddress());
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

    public static ArrayList<Client> getClients() {

        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call getClients()}");
            ResultSet resultSet=callableStatement.executeQuery();
            ArrayList<Client> clientArrayList=new ArrayList<Client>();
            while (resultSet.next())
            {
                clientArrayList.add(new Client(resultSet.getString("name"),resultSet.getInt("icn"),resultSet.getLong("pnc"),resultSet.getString("address")));
            }
            callableStatement.close();
            connection.close();
            return clientArrayList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static Client getClient(long pnc) {
        Connection connection = MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call getClient(?)}");
            callableStatement.setLong("pnc",pnc);
            ResultSet resultSet=callableStatement.executeQuery();
            Client client=null;
            while (resultSet.next())
               client=new Client(resultSet.getString("name"),resultSet.getInt("icn"),resultSet.getLong("pnc"),resultSet.getString("address"));
            callableStatement.close();
            connection.close();
            return client;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static String update(long pnc, Client client) {
        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call updateClient(?,?,?,?,?)}");
            callableStatement.setLong("oldPNC",pnc);
            callableStatement.setString("name",client.getName());
            callableStatement.setInt("icn", client.getIcn());
            callableStatement.setLong("pnc", client.getPnc());
            callableStatement.setString("address",client.getAddress());
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

    public static String delete(long pnc) {
        Connection connection= MySQLConnector.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call deleteClient(?)}");
            callableStatement.setLong("pnc",pnc);
            callableStatement.executeQuery();
            callableStatement.close();
            connection.close();
        } catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Deleted successfully";
    }
}