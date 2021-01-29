package com.example.moviebrowser.data;

import com.example.moviebrowser.ObservableTemp;
import com.example.moviebrowser.Result;

import java.util.List;

public interface ApiBrowser {
    ObservableTemp<Result<List<Movie>>> getUpcoming();

    ObservableTemp<Result<List<Movie>>> getPopular();

    ObservableTemp<Result<List<Movie>>> getTopRated();

    ObservableTemp<Result<List<Movie>>> getNowPlaying();

    ObservableTemp<Result<MovieDetails>> getMovieDetails(int movieId);

    ObservableTemp<Result<List<MovieSearchResult>>> searchMovies(String query);
}
