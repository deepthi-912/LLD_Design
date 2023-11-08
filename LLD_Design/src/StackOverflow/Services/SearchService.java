package StackOverflow.Services;

import StackOverflow.Views.AccountActivationStatus;
import StackOverflow.Views.Question;

import java.util.HashMap;
import java.util.List;

//Search for questions from all users
class SearchService {
    //mapping and storing list of all questions wrt description key
    HashMap<String, List<Question>> usersQuestionsList = new HashMap<>();

    List<Question> listOfQuestionsByDescription(String description) {
        return usersQuestionsList.get(description);
    }
}
