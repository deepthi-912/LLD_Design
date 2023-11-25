package StackOverflowNew;

import java.util.List;

enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED, DISABLED;
}
enum BadgeType {
    SILVER, GOLD, BRONZE;
}
enum ParentType {
    COMMENT, QUESTION, ANSWER;
}
enum QuestionStatus {
    CLOSED, DELETED, OPEN, ANSWERED;
}
class Account {
    String accountId;
    String password;
    Person personId;
    Address address;
    AccountStatus status;
}
class Moderator {
    Account account;
    void deleteQuestion(String questionId) {

    }
    void undeleteQuestion(String questionId) {

    }
    void blockMember(String memberId) {

    }
}
class Member {
    Account account;
    BadgeType badge;
}
class Badge {
    BadgeType badgeType;
    String accountId;
    String badgeDescription;
}
class Person {
    String personId;
    String name;
    String email;
    String phoneNumber;
}
class Address {
    String street;
    String apartment;
    String country;
    String state;
    String pincode;
}
class Question {
    String questionId;
    String accountId;
    String questionDescription;
    String tagName;
    Double bountyAmount;
    Integer totalUpvotes;
    Integer totalDownvotes;
    QuestionStatus status;
    void addBountyAmount(Double amount) {

    }
}
class Answer {
    String answerId;
    String questionId;
    String answer;
    String accountId;
    Integer totalUpvotes;
    Integer totalDownvotes;
}
class Comment {
    String commentId;
    ParentType parentType;
    String comment;
    String memberId;
}
class Upvote {
    String upvoteId;
    ParentType parentType;
    String parentId;
    String userId;
}
class Downvote {
    String downvote;
    ParentType parentType;
    String parentId;
    String userId;
}

interface SearchService {
    default List<Question> searchQuestionsByTag(String tagname) {
        return null;
    }
    default List<Question> searchQuestionsByMember() {
        return null;
    }
}
interface NotificationService {

}
class
public class StackOverflowEdit {
}
