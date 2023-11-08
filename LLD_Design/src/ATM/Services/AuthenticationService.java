package ATM.Services;

import ATM.Views.Card;
import ATM.Views.Cheque;
import ATM.Views.Account;

import java.util.List;

public class AuthenticationService {
    List<Card> cards;
    List<Account> accounts;
    boolean  authenticateCard(Card card, String passcode) {
        if(card.getPasscode()==passcode) {
            return true;
        } else {
            return false;
        }
    }

    boolean authenticateCheque(Cheque cheque) {
        //authenticate the account id, name and signature of the cheque with the matched account details
        return true;
    }

    boolean authenticateAccount(String accountNum, String password) {
        //authenticate the account id and password
        return true;
    }

}
