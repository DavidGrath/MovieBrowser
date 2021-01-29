package com.example.moviebrowser.usecase;

import com.example.moviebrowser.ObservableTemp;
import com.example.moviebrowser.Result;
import com.example.moviebrowser.data.Movie;
import com.example.moviebrowser.data.repositories.MoviesRepository;

import java.util.List;

public class HomeUseCase {
    MoviesRepository moviesRepository;

    public HomeUseCase(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public ObservableTemp<Result<List<Movie>>> getUpcoming() {
        return moviesRepository.getUpcoming();
    }

    public ObservableTemp<Result<List<Movie>>> getPopular() {
        return moviesRepository.getPopular();
    }

    public ObservableTemp<Result<List<Movie>>> getTopRated() {
        return moviesRepository.getTopRated();
    }

    public ObservableTemp<Result<List<Movie>>> getNowPlaying() {
        return moviesRepository.getNowPlaying();
    }
}
