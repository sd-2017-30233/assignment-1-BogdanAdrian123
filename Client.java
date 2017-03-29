package Business;

public class Client {
	private int clientID;
	private String name;
	private int ICN;
	private long CNP;
	private String address;
	
	public Client(int clientID,String name, int ICN, long CNP, String address) {
		this.clientID=clientID;
		this.name = name;
		this.ICN = ICN;
		this.CNP = CNP;
		this.address = address;
	}
	
	public Client(){
		
	}
	
	public int getClientID(){
		return clientID;
	}
	
	public void setClientID(int clientID){
		this.clientID=clientID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getICN() {
		return ICN;
	}

	public void setIcn(int ICN) {
		this.ICN = ICN;
	}

	public long getCNP() {
		return CNP;
	}

	public void setCNP(long cNP) {
		CNP = cNP;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
