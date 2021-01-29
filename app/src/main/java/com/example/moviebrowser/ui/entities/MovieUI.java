package com.example.moviebrowser.ui.entities;

public class MovieUI {
    private String name;
    private String uri;
    private String details;

    public MovieUI(String name, String uri, String details) {
        this.name = name;
        this.uri = uri;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
