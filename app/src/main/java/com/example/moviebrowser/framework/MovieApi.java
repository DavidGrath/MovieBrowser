package com.example.moviebrowser.framework;


import com.example.moviebrowser.data.MovieDetails;
import com.example.moviebrowser.data.MoviesResult;
import com.example.moviebrowser.data.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("movie/upcoming")
    public Call<MoviesResult> getUpcoming(@Query("api_key") String apiKey);

    @GET("movie/popular")
    public Call<MoviesResult> getPopular(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    public Call<MoviesResult> getTopRated(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    public Call<MoviesResult> getNowPlaying(@Query("api_key") String apiKey);

    @GET("/movie/{movieId}")
    public Call<MovieDetails> getMovieDetails(@Query("api_key") String apiKey, @Path("movieId") int movieId);

    @GET("search/movie")
    public Call<SearchResult> searchMovies(@Query("api_key") String apiKey, @Query("query") String query);
}
