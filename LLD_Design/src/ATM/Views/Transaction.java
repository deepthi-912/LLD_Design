package ATM.Views;

import java.sql.Timestamp;

public class Transaction {
    String transactionId;
    String senderAccountNumber;
    String receiverAccountNumber;
    Double transactionAmount;
    TransactionStatus transactionStatus;
    Timestamp transactionDate;
}
