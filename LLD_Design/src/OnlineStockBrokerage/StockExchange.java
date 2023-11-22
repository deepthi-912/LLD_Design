package OnlineStockBrokerage;

import ATM.Views.Transaction;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

enum AccountStatus {
    ACTIVE, BLOCKED, INACTIVE;
}
enum OrderType {
    MARKET, LIMIT, STOP_LOSS, STOP_LIMIT;
}
enum StockLotStatus {
    SOLD, NEW, PURCHASED, WATCHLISTED;
}
class User {
    String userId;
    String userName;
    String email;
    String address;
    String password;
    AccountStatus status;
}

class Stock {
    String stockId;
    String companyName;
    Double stockPrice;
    String stockName;
    Date updatedDate;
    Integer unitsLeft;
}
class StockLot {
    String stockLotId;
    String stockId;
    String userId;
    Integer stockNumber;
    Double stockPrice;
    Date purchasedDate;
    Date soldDate;

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Date getStockSoldDate() {
        return stockSoldDate;
    }

    public void setStockSoldDate(Date stockSoldDate) {
        this.stockSoldDate = stockSoldDate;
    }

    public StockLotStatus getStatusOfStock() {
        return statusOfStock;
    }

    public void setStatusOfStock(StockLotStatus statusOfStock) {
        this.statusOfStock = statusOfStock;
    }

    Double soldPrice;
    Date stockSoldDate;
    StockLotStatus statusOfStock;
    public StockLot(String stockId, String userId, Integer stockNumber, Double stockPrice, Date purchasedDate) {
        this.stockId = stockId;
        this.userId = userId;
        this.stockNumber = stockNumber;
        this.stockPrice = stockPrice;
        this.purchasedDate = purchasedDate;
    }

    public String getStockLotId() {
        return stockLotId;
    }

    public void setStockLotId(String stockLotId) {
        this.stockLotId = stockLotId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
}
class Watchlist {
    String watchlistId;
    String userId;
    List<String> listOfQuoteIds;
}
class Order {
    String orderId;
    String orderDescription;
    String userId;
    Date orderPurchaseDate;
    OrderType orderType;
    Transaction transactionDetails;
}
interface WithdrawTransaction {
    default Double withdrawMoney() {
        return 0.0;
    }
}
interface DepositMoneyTransaction {
    default Double depositMoney() {
        return 0.0;
    }
}
class Check implements DepositMoneyTransaction, WithdrawTransaction {
    Double amount;
    public Double withdrawMoney(Double money) {
        //lock on account
        if(amount>=money) {
            amount-=money;
        }
        return this.amount;
        //release lock on account
    }
    public Double depositMoney(Double money) {
        //lock on account
        this.amount = this.amount + money;
        //release lock on amount
        return this.amount;
    }
}
class Wire implements DepositMoneyTransaction, WithdrawTransaction {
    Double amount;
    public Double withdrawMoney(Double money) {
        //lock on account
        if(amount>=money) {
            amount-=money;
        }
        return this.amount;
        //release lock on account
    }
    public Double depositMoney(Double money) {
        //lock on account
        this.amount = this.amount + money;
        //release lock on amount
        return this.amount;
    }
}
class ElectronicTransfer implements DepositMoneyTransaction, WithdrawTransaction {
    Double amount;
    public Double withdrawMoney(Double money) {
        //lock on account
        if(amount>=money) {
            amount-=money;
        }
        return this.amount;
        //release lock on account
    }
    public Double depositMoney(Double money) {
        //lock on account
        this.amount = this.amount + money;
        //release lock on amount
        return this.amount;
    }
}
class Quote {
    String quoteId;
    String stockLotId;
    String userId;
    Double quotePrice;
    String quoteDescription;
    Date quotedDate;
}
interface Reports {
    default void generateReport() {

    }
}
class QuarterlyReports implements Reports {
    @Override
    public void generateReport() {

    }
}
class YearlyReports implements Reports {
    @Override
    public void generateReport() {

    }
}
public class StockExchange {

}
class StocksModificationService {
    HashMap<String, StockLot> mapOfStocksLot;
    HashMap<String, Stock> listOfStocks;
    //buy stock
    String buyStock(String stockId, Integer numberOfStocks, String userId, Double stockPrice, Integer stockNumber) {
        StockLot stockLot = new StockLot(stockId, userId, stockNumber, stockPrice, new Date());
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        mapOfStocksLot.put(generatedString, stockLot);
        mapOfStocksLot.get(generatedString).setStatusOfStock(StockLotStatus.PURCHASED);
        NotificationService.generateNotification("Stock Purchased");
        return generatedString;
    }
    //sell stock
    void sellStock(String stockId, Double price) {
        mapOfStocksLot.get(stockId).setStatusOfStock(StockLotStatus.SOLD);
        mapOfStocksLot.get(stockId).setSoldPrice(price);
        mapOfStocksLot.get(stockId).setStockSoldDate(new Date());
        NotificationService.generateNotification("Stock Sold");
    }
}
class NotificationService {
    static void generateNotification(String message) {
        System.out.println("Generated notification" + message);
    }
}
