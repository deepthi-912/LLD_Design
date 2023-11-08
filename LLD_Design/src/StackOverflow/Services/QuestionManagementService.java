package StackOverflow.Services;

import StackOverflow.Views.AccountActivationStatus;
import StackOverflow.Views.Question;
import StackOverflow.Views.Flag;
import StackOverflow.Views.Previlege;
import StackOverflow.Views.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//Can flag a question and delete it, comment for serious problem/attention
class QuestionManagementService {
    List<Question> questionsList = new ArrayList<>();
    HashMap<String, User> usersList = new HashMap<>();

    public void modifyQuestion(String tag, String description, String userId, String questionId) {
        if (usersList.get(userId).getUserPrivilege() == Previlege.EDIT) {
            for (int i = 0; i < questionsList.size(); i++) {
                if (questionsList.get(i).getQuestionId() == questionId) {
                    ///update descrption
                    ///update tag/add tag
                    ///archive or close for now
                }
            }
        }
    }

    public void flagQuestion(String flagDescription, String userId, String questionId) {
        if (usersList.get(userId).getUserPrivilege() == Previlege.EDIT) {
            for (int i = 0; i < questionsList.size(); i++) {
                if (questionsList.get(i).getQuestionId() == questionId) {
                    Flag flag = new Flag(userId, questionId, flagDescription, new Date());
                }
            }
        }
    }

    public void deleteQuestion(String userId, String questionId) {
        if (usersList.get(userId).getUserPrivilege() == Previlege.EDIT) {
            for (int i = 0; i < questionsList.size(); i++) {
                if (questionsList.get(i).getQuestionId() == questionId) {
                    questionsList.remove(i);
                }
            }
        }
    }
}
