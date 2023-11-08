package StackOverflow.Views;

public enum AccountActivationStatus {
    ACTIVE, BLOCKED, INACTIVE, DELETED;

    public static class Question {
        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String questionId;
        String tag;
        String description;
    }

}
