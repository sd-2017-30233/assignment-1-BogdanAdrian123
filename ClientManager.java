package Business;

import java.util.ArrayList;

import DataAccess.ClientMapper;

public class ClientManager {

	public static String addClient(int clientID ,String name, int ICN, long CNP,String address){
		String add=ClientValidation.validateClientData(name, ICN, CNP, address);
		if (add.equals("Valid")){
			Client client= new Client(clientID,name,ICN,CNP,address);
			return ClientMapper.insert(client);
		}
		else return add;
	}
	
	public static String deleteClient(String name, int ICN, long CNP,String address){
		String delete=ClientValidation.validateClientData(name, ICN, CNP, address);
		if (delete.equals("Valid")){
			return ClientMapper.delete(CNP);
		}
		else return "Clientul nu exista";
	}
	
	public static String updateClient(int clientID,String name, int ICN, long CNP,String address){
		String update=ClientValidation.validateClientData(name, ICN, CNP, address);
		if (update.equals("Valid")){
			Client client=new Client( clientID,name,ICN,CNP,address);
			return ClientMapper.update(client);
		}
		else return update;
	}
	
	public static ArrayList <Client> getClients(){
		return ClientMapper.getClients();
	}
	
	public static Client getClient(String name, int ICN, long CNP,String address){
		String get=ClientValidation.validateClientData(name, ICN, CNP, address);
		if (get.equals("Valid")){
			return ClientMapper.getClient(name,ICN,CNP,address);
		}
		else return null;
	}
	
	
	
}
