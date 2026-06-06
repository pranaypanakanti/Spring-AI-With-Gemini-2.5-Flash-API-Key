package com.springAi.studyPlanner.entities;

import java.util.List;

public class SuggestedSchedule {

    private List<String> dailyPlan;
    private List<String> weeklyPlan;
    private List<String> consistencyTips;

    public List<String> getDailyPlan() {
        return dailyPlan;
    }

    public void setDailyPlan(List<String> dailyPlan) {
        this.dailyPlan = dailyPlan;
    }

    public List<String> getWeeklyPlan() {
        return weeklyPlan;
    }

    public void setWeeklyPlan(List<String> weeklyPlan) {
        this.weeklyPlan = weeklyPlan;
    }

    public List<String> getConsistencyTips() {
        return consistencyTips;
    }

    public void setConsistencyTips(List<String> consistencyTips) {
        this.consistencyTips = consistencyTips;
    }
}