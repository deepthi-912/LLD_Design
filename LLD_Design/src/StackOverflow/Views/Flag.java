package StackOverflow.Views;

import java.util.Date;

public class Flag {
    String userId;
    String questionId;
    String flagDescription;
    Date flagTime;

    public Flag(String userId, String questionId, String flagDescription, Date time) {
        this.flagDescription = flagDescription;
        this.flagTime = time;
        this.userId = userId;
        this.questionId = questionId;
    }
}
