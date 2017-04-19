package Business;

import DataAccess.AccountMapper;

import java.util.ArrayList;

public class AccountManager {

    private static final int EPAID=111111, GPAID=222222, WPAID=333333;

    public static String addAccount(int ID, String accountType, long funds, long ownerPNC) {

        String status=AccountValidator.checkAccountData(ID,accountType,funds,ownerPNC);
        if(status.equals("Valid"))
        {
            Account account=new Account(ID,accountType,funds,ownerPNC);
            return AccountMapper.insert(account);
        }
        else return status;
    }

    public static String updateAccount(int oldID, int ID, String accountType, long funds, long ownerPNC) {
        String status=AccountValidator.checkAccountData(ID,accountType,funds,ownerPNC);
        if(status.equals("Valid"))
        {
            Account account=new Account(ID,accountType,funds,ownerPNC);
            return AccountMapper.update(oldID,account);
        }
        else return status;
    }

    public static ArrayList<Account> getAccounts() {
      return AccountMapper.getAccounts();
    }

    public static Account getAccount(int id) {
        return AccountMapper.getAccount(id);
    }

    public static String deleteAccount(int id) {
      return  AccountMapper.delete(id);
    }

    public static String transferFunds(int srcID, int dstID, long funds) {

        if (funds<0) return "Funds must be a positive";
        Account srcAccount=AccountMapper.getAccount(srcID);
        Account dstAccount=AccountMapper.getAccount(dstID);
        if(srcAccount!=null)
            if (dstAccount!=null)
                if (srcAccount.getFunds()>funds)
                {
                    srcAccount.setFunds(srcAccount.getFunds() - funds);
                    dstAccount.setFunds(dstAccount.getFunds() + funds);
                     if(AccountMapper.update(srcID,srcAccount).equals("Updated successfully") && AccountMapper.update(dstID,dstAccount).equals("Updated successfully"))
                        return "Funds transferred successfully";
                    else return "An error occurred while transferring funds";
                }
                else return "Not enough funds";
            else return("Invalid destination id");
        else return ("Invalid source id");
    }

    public static String payUtilityBill(int ID, long funds, String utilityType) {
        if (utilityType.equals("Electricity")) {
            transferFunds(ID, EPAID, funds);
            return "Successfully paid electricity bill";
        }

        if (utilityType.equals("Gas")) {
            transferFunds(ID, GPAID, funds);
            return "Successfully paid gas bill";
        }

        if (utilityType.equals("Water")) {
            transferFunds(ID, WPAID, funds);
            return "Successfully paid water bill";
        }

        return "Invalid utility";
    }
}