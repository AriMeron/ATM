import java.util.*;

public class Atm {
    
    HashMap<String, Double> accounts = new HashMap<String, Double>();

    public void openAccount(String userID, double amount) {
        if(!accounts.containsKey(userID)) {
            accounts.put(userID, amount);
        }
        else{
            AccountException ae = new AccountException("account already exists");
            throw ae;
        }
            
    }
}


