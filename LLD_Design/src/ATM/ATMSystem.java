package ATM;

//System Requirements
//ATM Machine
//
//        1. Withdraw money
//        2. Deposit money
//        3. Check for the available balance
//        4. No two users can withdraw cash at once —>lock on the account while depositing & withdrawing
//        5. Transfer funds
//        6. Deposit cheque
//        7. If there’s no money in the ATM, it should display that
//        8. Card reader
//        9. Screen
//        10. CashDispenser
//        11. Keypad
//        12. Printer
//        13. User can have savings and Checking

public class ATMSystem {
    Double availableMoney;
    String atmServiceName;
    Integer hundredDollarCount;
    Integer tenDollarCount;
    Integer oneDollarCount;

    void displayAmount(Double requestedMoney) {
        if(availableMoney<requestedMoney) {
            //go to display service to print that the money is not available
        }
    }
}
