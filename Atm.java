import java.util.*;

public class Atm {
    
    HashMap<String, Double> accounts = new HashMap<String, Double>();

    public void openAccount(String userID, double amount) {
        if(!accounts.containsKey(userID)) {
            accounts.put(userID, amount);
        }
        else{
            throw new AccountException("account already exists");
        }  
    }

    public void closeAccount(String userID) {
        if(accounts.containsKey(userID) && accounts.get(userID) == 0) 
            accounts.remove(userID);
        else if(accounts.containsKey(userID) && accounts.get(userID) != 0)
            throw new AccountException("You must withdraw your money before closing");
        else
            throw new AccountException("Account not found");
    }

    public double checkBalance(String userID) {
        if(accounts.containsKey(userID))
            return accounts.get(userID);
        else
            throw new AccountException("Account not found");
    }

    public double depositMoney(String userID, double depositAmount) {
        if(accounts.containsKey(userID)) {
            double currentAmount = accounts.get(userID);
            accounts.put(userID, currentAmount+depositAmount);
            return depositAmount;
        }
        else
            throw new AccountException("Ur broke af");
    }

    public double withdrawMoney(String userID, double amount) {
        if(accounts.containsKey(userID)) {
            if(accounts.get(userID) < amount)
                throw new AccountException("ur broke af");
            else {
                double currAmount = accounts.get(userID);
                accounts.put(userID, currAmount - amount);
                return amount;
            }
        }
        else
            throw new AccountException("Account not found");
    }

    public boolean transferMoney(String toAccount, String fromAccount, double amount) {
        if(!accounts.containsKey(fromAccount) || !accounts.containsKey(toAccount))
            throw new AccountException("Account not found");
        if(withdrawMoney(fromAccount, amount) == amount && depositMoney(toAccount, amount) == amount)
           return true;
        else
            return false;
    }
}


