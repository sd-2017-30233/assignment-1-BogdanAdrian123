package Business;

import java.util.ArrayList;

import DataAccess.AccountMapper;
import DataAccess.ClientMapper;

public class AccountManager {

	public static String addAccount(int accountID, String type , long Amount, int clientID,String date ){
		
	String add=AccountValidation.checkAccountData(accountID,type,Amount,date);
	
	if (add.equals("Valid")){
		Account account=new Account(accountID,type,Amount,clientID,date);
		return AccountMapper.insert(account);
	}
	else return add;
	}
	
	public static String deleteAccount(int Id_account){
		return AccountMapper.delete(Id_account);

	}
	
	public static String updateAccount(int accountID,String type , long Amount,int clientID,String date){
		String update=AccountValidation.checkAccountData(accountID, type, Amount, date);
		if (update.equals("fonduri suficiente")){
			Account account=new Account(accountID, type, Amount,clientID ,date);
			return AccountMapper.update(account);
		}
		else return update;
	}
	
	
	public static ArrayList<Account> getAccounts(){
		return AccountMapper.getAccounts();
	}
	
	public static Account getAccount(int accountID, String type, long Amount , String date){
	
		String get=AccountValidation.checkAccountData(accountID,type , Amount, date);
		if (get.equals("Fonduri suficiente")){
			return AccountMapper.getAccount(accountID,type,Amount,date);
		}
		else return null;
	}
	
}
