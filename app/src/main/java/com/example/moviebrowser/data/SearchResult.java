package com.example.moviebrowser.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<MovieSearchResult> movieSearchResults = null;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    /**
     * No args constructor for use in serialization
     */
    public SearchResult() {
    }

    /**
     * @param totalResults
     * @param totalPages
     * @param page
     * @param movieSearchResults
     */
    public SearchResult(Integer page, List<MovieSearchResult> movieSearchResults, Integer totalResults, Integer totalPages) {
        super();
        this.page = page;
        this.movieSearchResults = movieSearchResults;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieSearchResult> getMovieSearchResults() {
        return movieSearchResults;
    }

    public void setMovieSearchResults(List<MovieSearchResult> movieSearchResults) {
        this.movieSearchResults = movieSearchResults;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}

