package com.SpringAI.studyPlanner.entities;

import java.util.List;

public class StudyPlanResponse {

    private GoalOverview goalOverview;
    private List<MainTopic> learningRoadmap;
    private PracticeStrategy practiceStrategy;
    private SuggestedSchedule suggestedSchedule;
    private List<String> advantages;
    private List<String> recommendedNextTopics;
    private List<String> finalRecommendations;

    public GoalOverview getGoalOverview() {
        return goalOverview;
    }

    public void setGoalOverview(GoalOverview goalOverview) {
        this.goalOverview = goalOverview;
    }

    public List<MainTopic> getLearningRoadmap() {
        return learningRoadmap;
    }

    public void setLearningRoadmap(List<MainTopic> learningRoadmap) {
        this.learningRoadmap = learningRoadmap;
    }

    public PracticeStrategy getPracticeStrategy() {
        return practiceStrategy;
    }

    public void setPracticeStrategy(PracticeStrategy practiceStrategy) {
        this.practiceStrategy = practiceStrategy;
    }

    public SuggestedSchedule getSuggestedSchedule() {
        return suggestedSchedule;
    }

    public void setSuggestedSchedule(SuggestedSchedule suggestedSchedule) {
        this.suggestedSchedule = suggestedSchedule;
    }

    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }

    public List<String> getRecommendedNextTopics() {
        return recommendedNextTopics;
    }

    public void setRecommendedNextTopics(List<String> recommendedNextTopics) {
        this.recommendedNextTopics = recommendedNextTopics;
    }

    public List<String> getFinalRecommendations() {
        return finalRecommendations;
    }

    public void setFinalRecommendations(List<String> finalRecommendations) {
        this.finalRecommendations = finalRecommendations;
    }
}