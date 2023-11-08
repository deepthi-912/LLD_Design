package ATM.Services;

import ATM.Views.Account;
import ATM.Views.Card;
import ATM.Views.CardScanStatus;

import java.util.List;

public class DisplayService {
    List<Account> listOfAccounts;
    public void displayDetails(CardScanStatus cardScanStatus, Card card) {
        if(cardScanStatus==CardScanStatus.CARD_FOUND) {
            // display options to select
        } else if(cardScanStatus==CardScanStatus.SWIPE_AGAIN) {
            // display message to swipe again
        } else if(cardScanStatus==CardScanStatus.CANNOT_FIND) {
            //display that the card is expired or not found
        }
    }
    Double displayAvailableBalance(String accountId) {
        for(int i=0;i<listOfAccounts.size();i++) {
            if(accountId == listOfAccounts.get(i).getAccountNumber()) {
                return listOfAccounts.get(i).getAvailableBalance();
            }
        }
        return 0.0;
    }
}
