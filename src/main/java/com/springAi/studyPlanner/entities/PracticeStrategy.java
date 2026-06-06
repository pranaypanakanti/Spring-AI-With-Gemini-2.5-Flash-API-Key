package com.springAi.studyPlanner.entities;

import java.util.List;

public class PracticeStrategy {

    private List<String> effectivePracticeMethods;
    private List<String> revisionFrequency;
    private List<String> mockTestsOrProjects;
    private List<String> realWorldImplementationIdeas;
    private List<String> theoryVsPracticeBalance;

    public List<String> getEffectivePracticeMethods() {
        return effectivePracticeMethods;
    }

    public void setEffectivePracticeMethods(List<String> effectivePracticeMethods) {
        this.effectivePracticeMethods = effectivePracticeMethods;
    }

    public List<String> getRevisionFrequency() {
        return revisionFrequency;
    }

    public void setRevisionFrequency(List<String> revisionFrequency) {
        this.revisionFrequency = revisionFrequency;
    }

    public List<String> getMockTestsOrProjects() {
        return mockTestsOrProjects;
    }

    public void setMockTestsOrProjects(List<String> mockTestsOrProjects) {
        this.mockTestsOrProjects = mockTestsOrProjects;
    }

    public List<String> getRealWorldImplementationIdeas() {
        return realWorldImplementationIdeas;
    }

    public void setRealWorldImplementationIdeas(List<String> realWorldImplementationIdeas) {
        this.realWorldImplementationIdeas = realWorldImplementationIdeas;
    }

    public List<String> getTheoryVsPracticeBalance() {
        return theoryVsPracticeBalance;
    }

    public void setTheoryVsPracticeBalance(List<String> theoryVsPracticeBalance) {
        this.theoryVsPracticeBalance = theoryVsPracticeBalance;
    }
}