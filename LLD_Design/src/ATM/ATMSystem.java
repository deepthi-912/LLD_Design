package ATM;

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
