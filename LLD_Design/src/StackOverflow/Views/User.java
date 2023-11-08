package StackOverflow.Views;

import java.util.Date;

public class User {
    String userId;
    String password;
    Person person;
    Date dateCreated;
    AccountActivationStatus status;

    public Previlege getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(Previlege userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    Previlege userPrivilege;
    Integer reputationPoints;
}
