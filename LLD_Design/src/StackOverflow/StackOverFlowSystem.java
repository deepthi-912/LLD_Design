package StackOverflow;

enum AccountActivationStatus {
    ACTIVE, BLOCKED, INACTIVE, DELETED;
}
class Address {
    String street;
    String apartmentNumber;
    String country;
    String state;
    String pincode;
}

class Person {
    String id;
    String personName;
    String email;
    String phoneNum;
    Address address;
}
class User {
    String userId;
    String password;
    Person person;
    AccountActivationStatus status;
}

class Question {
    String questionId;
    String tag;
    String description;

}

class UpVote {
    String upVoteId;
    String userId;
    String questionId;
    String answerId;
}

class DownVote {
    String downVoteId;
    String userId;
    String questionId;
    String answerId;
}

class Answer {
    String answer;
    String questionId;
    String userId;
}

class Reputation {

}
public class StackOverFlowSystem {

}
