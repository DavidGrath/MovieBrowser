package com.example.moviebrowser;

import com.example.moviebrowser.data.Movie;
import com.example.moviebrowser.data.MovieSearchResult;
import com.example.moviebrowser.ui.entities.MovieUI;

public class TempMapperUtil {
    public static MovieUI movieToMovieUI(Movie result) {
        return new MovieUI(result.getTitle(), result.getPosterPath(), result.getOverview());
    }

    public static MovieUI movieSearchToMovieUI(MovieSearchResult result) {
        return new MovieUI(result.getTitle(), result.getPosterPath(), result.getOverview());
    }
}
