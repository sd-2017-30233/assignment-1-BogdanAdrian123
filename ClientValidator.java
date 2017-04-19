package Business;

public class ClientValidator {

    public static String validateClientData(String name, int icn, long cnp, String address) {
        //icn must be 6 digits long
        if (icn <100000 || icn>999999) return "Invalid icn";
        if (!isValidPNC(cnp)) return "Invalid pnc";
        return "Valid";
    }

    public static boolean isValidPNC(long cnp) {
        //pnc must be 13 digits long
        if (cnp>=1000000000000L && cnp<=9999999999999L) return true;
        else return false;
    }
}