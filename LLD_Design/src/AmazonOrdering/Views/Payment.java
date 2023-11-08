package AmazonOrdering.Views;

import AmazonOrdering.Views.PaymentStatus;

import java.sql.Timestamp;

public class Payment {
    String paymentId;
    Timestamp paymentDate;
    PaymentStatus paymentStatus;
    Double totalCost;
    String checkOutId;
}
