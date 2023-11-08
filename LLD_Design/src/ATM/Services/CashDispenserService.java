package ATM.Services;

import ATM.Views.Account;

import java.util.List;

public class CashDispenserService {
    List<Account> accounts;
    public Double withdrawCash(String userId, Double amount) {
        for(int i=0;i<accounts.size();i++) {
            //lock on account for only one user to access
            if(accounts.get(i).getAccountNumber()==userId && accounts.get(i).getAvailableBalance()>=amount) {
                accounts.get(i).setAvailableBalance(accounts.get(i).getAvailableBalance()-amount);
                return amount;
            }
            //release lock on the account
        }
        return 0.0;
    }
    public Double depositCash(String userId, Double amount) {
        for(int i=0;i<accounts.size();i++) {
            //lock on account for only one user to access
            if(accounts.get(i).getAccountNumber()==userId && amount>0.0) {
                accounts.get(i).setAvailableBalance(accounts.get(i).getAvailableBalance()+amount);
                return accounts.get(i).getAvailableBalance();
            }
            //release lock on the account
        }
        return 0.0; ///here need to returnn balance without updating!! if something went wrong
    }
}
