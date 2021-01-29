package com.example.moviebrowser.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResult {

    //    @SerializedName("page")
//    @Expose
//    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Movie> movies = null;
//    @SerializedName("dates")
//    @Expose
//    private DateResult dateResult;
//    @SerializedName("total_pages")
//    @Expose
//    private Integer totalPages;
//    @SerializedName("total_results")
//    @Expose
//    private Integer totalResults;

    /**
     * No args constructor for use in serialization
     */
    public MoviesResult() {
    }

    /**
     * @param totalResults
     * @param totalPages
     * @param dateResult
     * @param page
     * @param movies
     */
    public MoviesResult(Integer page, List<Movie> movies, DateResult dateResult, Integer totalPages, Integer totalResults) {
        super();
//        this.page = page;
        this.movies = movies;
//        this.dateResult = dateResult;
//        this.totalPages = totalPages;
//        this.totalResults = totalResults;
    }

    /*public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }*/

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /*public DateResult getDateResult() {
        return dateResult;
    }

    public void setDateResult(DateResult dateResult) {
        this.dateResult = dateResult;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }*/

}

