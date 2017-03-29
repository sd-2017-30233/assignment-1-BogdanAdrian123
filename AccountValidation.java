package Business;

public class AccountValidation {

	public static String checkAccountData(int accounID , String type , long Amount ,String date){
		if (Amount<0) return "fonduri insuficiente";
		return "Fonduri suficiente";
	}
}
