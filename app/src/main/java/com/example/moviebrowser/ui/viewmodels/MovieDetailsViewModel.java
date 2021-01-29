package com.example.moviebrowser.ui.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.moviebrowser.ui.entities.MovieUI;

public class MovieDetailsViewModel extends ViewModel {

    private MovieUI movieUI;

    public void setMovieUIDetails(MovieUI movieUI) {
        this.movieUI = movieUI;
    }

    public MovieUI getMovieUI() {
        return movieUI;
    }

}
