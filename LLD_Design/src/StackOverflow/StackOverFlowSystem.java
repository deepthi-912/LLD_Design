package StackOverflow;

//System requirements
//        1. Posting questions (Edit, Delete)
//        2. Answers —> Upvoting and down voting
//        3. Reputation points —> depending on upvotes user gets
//        4. Acccording to reputation points, users can have privileges and badges
//        5. Search for questions from all users
//        6. View questions and answers
//        7. Can flag a question and delete it, comment for serious problem/attention
//        8. Can close or reopen a question
//        9. Can add tags/description/topic to a question
//        10. Most frequently used tags in the questions

import StackOverflow.Views.*;

import java.util.*;

//    Most frequently used tags in the questions
public class StackOverFlowSystem {
    HashMap<String, List<AccountActivationStatus.Question>> questionsListMap = new HashMap<>();
    List<AccountActivationStatus.Question> getMostFrequentlyTaggedQuestions() {
        int maxNum = 0;
        List<AccountActivationStatus.Question> questionsList = new ArrayList<>();
        for(Map.Entry<String, List<AccountActivationStatus.Question>> entry: questionsListMap.entrySet()) {
            if(entry.getValue().size()>maxNum) {
                questionsList = entry.getValue();
            }
        }
        return questionsList;
    }
}

