package com.example.moviebrowser.framework;

import com.example.moviebrowser.Failure;
import com.example.moviebrowser.ObservableTemp;
import com.example.moviebrowser.Pending;
import com.example.moviebrowser.Result;
import com.example.moviebrowser.Success;
import com.example.moviebrowser.data.ApiBrowser;
import com.example.moviebrowser.data.Movie;
import com.example.moviebrowser.data.MovieDetails;
import com.example.moviebrowser.data.MovieSearchResult;
import com.example.moviebrowser.data.MoviesResult;
import com.example.moviebrowser.data.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiBrowserImpl implements ApiBrowser {

    private MovieApi movieApi;
    private final String API_KEY;

    public ApiBrowserImpl(MovieApi movieApi, String API_KEY) {
        this.movieApi = movieApi;
        this.API_KEY = API_KEY;
    }

    @Override
    public ObservableTemp<Result<List<Movie>>> getUpcoming() {
        ObservableTemp<Result<List<Movie>>> upcoming = new ObservableTemp(new Pending());
        movieApi.getUpcoming(API_KEY).enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                upcoming.update(new Success(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                upcoming.update(new Failure(t));
            }
        });
        return upcoming;
    }

    @Override
    public ObservableTemp<Result<List<Movie>>> getPopular() {
        ObservableTemp<Result<List<Movie>>> popular = new ObservableTemp(new Pending());
        movieApi.getPopular(API_KEY).enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                popular.update(new Success(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                popular.update(new Failure(t));
            }
        });
        return popular;
    }

    @Override
    public ObservableTemp<Result<List<Movie>>> getTopRated() {
        ObservableTemp<Result<List<Movie>>> topRated = new ObservableTemp(new Pending());
        movieApi.getTopRated(API_KEY).enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                topRated.update(new Success(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                topRated.update(new Failure(t));
            }
        });
        return topRated;
    }

    @Override
    public ObservableTemp<Result<List<Movie>>> getNowPlaying() {
        ObservableTemp<Result<List<Movie>>> nowPlaying = new ObservableTemp(new Pending());
        movieApi.getNowPlaying(API_KEY).enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                nowPlaying.update(new Success(response.body().getMovies()));
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                nowPlaying.update(new Failure(t));
            }
        });
        return nowPlaying;
    }

    @Override
    public ObservableTemp<Result<MovieDetails>> getMovieDetails(int movieId) {
        ObservableTemp<Result<MovieDetails>> movieDetails = new ObservableTemp(new Pending());
        movieApi.getMovieDetails(API_KEY, movieId).enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                movieDetails.update(new Success(response.body()));
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                movieDetails.update(new Failure(t));
            }
        });
        return movieDetails;
    }

    @Override
    public ObservableTemp<Result<List<MovieSearchResult>>> searchMovies(String query) {
        ObservableTemp<Result<List<MovieSearchResult>>> searchResults = new ObservableTemp(new Pending());
        movieApi.searchMovies(API_KEY, query).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                searchResults.update(new Success(response.body().getMovieSearchResults()));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                searchResults.update(new Failure(t));
            }
        });
        return searchResults;
    }
}
