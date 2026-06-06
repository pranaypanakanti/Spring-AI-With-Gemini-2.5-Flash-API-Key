package com.springAi.studyPlanner.entities;

import java.util.List;

public class ResourceSection {

    private List<Resource> articles;
    private List<Resource> youtubeResources;
    private List<Resource> additionalResources;

    public List<Resource> getArticles() {
        return articles;
    }

    public void setArticles(List<Resource> articles) {
        this.articles = articles;
    }

    public List<Resource> getYoutubeResources() {
        return youtubeResources;
    }

    public void setYoutubeResources(List<Resource> youtubeResources) {
        this.youtubeResources = youtubeResources;
    }

    public List<Resource> getAdditionalResources() {
        return additionalResources;
    }

    public void setAdditionalResources(List<Resource> additionalResources) {
        this.additionalResources = additionalResources;
    }
}