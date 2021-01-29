package com.example.moviebrowser.data.repositories;

import com.example.moviebrowser.ObservableTemp;
import com.example.moviebrowser.Result;
import com.example.moviebrowser.data.ApiBrowser;
import com.example.moviebrowser.data.Movie;

import java.util.List;

public class MoviesRepository {

    private ApiBrowser apiBrowser;

    public MoviesRepository(ApiBrowser apiBrowser) {
        this.apiBrowser = apiBrowser;
    }

    public ObservableTemp<Result<List<Movie>>> getUpcoming() {
        return apiBrowser.getUpcoming();
    }

    public ObservableTemp<Result<List<Movie>>> getPopular() {
        return apiBrowser.getPopular();
    }

    public ObservableTemp<Result<List<Movie>>> getTopRated() {
        return apiBrowser.getTopRated();
    }

    public ObservableTemp<Result<List<Movie>>> getNowPlaying() {
        return apiBrowser.getNowPlaying();
    }

}
