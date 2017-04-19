package Business;

import DataAccess.ClientMapper;

import java.util.ArrayList;

public class ClientManager {

    public static String addClient(String name, int ICN, long PNC, String address) {

        String status=ClientValidator.validateClientData(name,ICN,PNC,address);
        if (status.equals("Valid")) {
            Client client=new Client(name,ICN,PNC,address);
            return ClientMapper.insert(client);
        }
        else return status;
    }

    public static ArrayList<Client> getClients() {
        return ClientMapper.getClients();
    }

    public static String deleteClient(long pnc) {
        if (ClientValidator.isValidPNC(pnc))
        {
            return ClientMapper.delete(pnc);
        }
        else return "Invalid PNC";
    }

    public static Client getClient(long pnc) {
        if (ClientValidator.isValidPNC(pnc))
        return ClientMapper.getClient(pnc);
        else return null;
    }

    public static String updateClient(String name, int ICN, long PNC, String address,long oldPNC) {
        String status=ClientValidator.validateClientData(name,ICN,PNC,address);
        if (status.equals("Valid"))
            if (ClientValidator.isValidPNC(oldPNC))
            {
                Client client=new Client(name,ICN,PNC,address);
               return ClientMapper.update(oldPNC, client);
            }
            else return "Invalid old PNC";
        else return status;
    }
}