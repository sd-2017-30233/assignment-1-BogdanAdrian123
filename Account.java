package Business;

public class Account {

	private int accountID;
	private String type;
	private long Amount;
	private int clientID;
	private String date;
	
	public Account(int accountID, String type, long Amount,int clientID, String date) {
		this.accountID = accountID;
		this.type = type;
		this.Amount = Amount;
		this.clientID= clientID;
	}

	public Account(){
		
	}
	
	public int getaccountID() {
		return accountID;
	}

	public void setaccountID(int accountID) {
		accountID = accountID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(int Amount) {
		Amount = Amount;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
