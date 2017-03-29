package Business;

public class ClientValidation {
	public static String validateClientData(String name , int ICN, long CNP ,String address){
		if (CNP>=1000000000000L && CNP<=9999999999999L) return "Client inexistent";
		else return "Correct";
	}

}
