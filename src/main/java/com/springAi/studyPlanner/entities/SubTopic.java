package com.springAi.studyPlanner.entities;
public class SubTopic {

    private String subTopicName;
    private String whatToLearn;
    private String keyConcepts;
    private String recommendedPracticeFocus;
    private String estimatedTime;

    public String getSubTopicName() {
        return subTopicName;
    }

    public void setSubTopicName(String subTopicName) {
        this.subTopicName = subTopicName;
    }

    public String getWhatToLearn() {
        return whatToLearn;
    }

    public void setWhatToLearn(String whatToLearn) {
        this.whatToLearn = whatToLearn;
    }

    public String getKeyConcepts() {
        return keyConcepts;
    }

    public void setKeyConcepts(String keyConcepts) {
        this.keyConcepts = keyConcepts;
    }

    public String getRecommendedPracticeFocus() {
        return recommendedPracticeFocus;
    }

    public void setRecommendedPracticeFocus(String recommendedPracticeFocus) {
        this.recommendedPracticeFocus = recommendedPracticeFocus;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}