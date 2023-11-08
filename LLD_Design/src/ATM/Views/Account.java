package ATM.Views;

import java.util.Date;

public class Account {
    Person person;
    String accountNumber;
    String password;
    AccountType accountType;
    AccountActivationStatus accountActivationStatus;
    Date accountCreationDate;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountActivationStatus getAccountActivationStatus() {
        return accountActivationStatus;
    }

    public void setAccountActivationStatus(AccountActivationStatus accountActivationStatus) {
        this.accountActivationStatus = accountActivationStatus;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    Double availableBalance;

}
