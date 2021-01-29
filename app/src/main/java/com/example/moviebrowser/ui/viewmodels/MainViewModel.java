package com.example.moviebrowser.ui.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.moviebrowser.data.ApiBrowser;
import com.example.moviebrowser.data.repositories.MoviesRepository;
import com.example.moviebrowser.framework.ApiBrowserImpl;
import com.example.moviebrowser.framework.MovieApi;
import com.example.moviebrowser.framework.RetrofitHelper;
import com.example.moviebrowser.ui.entities.MovieUI;
import com.example.moviebrowser.usecase.HomeUseCase;

import retrofit2.Retrofit;

import static com.example.moviebrowser.Constants.API_KEY;

public class MainViewModel extends ViewModel {

    public MainViewModel() {
        Retrofit retrofit = RetrofitHelper.retrofitInstance();
        MovieApi movieApi = retrofit.create(MovieApi.class);
        ApiBrowser apiBrowser = new ApiBrowserImpl(movieApi, API_KEY);
        MoviesRepository moviesRepository = new MoviesRepository(apiBrowser);
        homeUseCase = new HomeUseCase(moviesRepository);
    }

    private HomeUseCase homeUseCase;

    public HomeUseCase getHomeUseCase() {
        return homeUseCase;
    }

    private MovieUI movieUI;

    public void setMovieUIDetails(MovieUI movieUI) {
        this.movieUI = movieUI;
    }

    public MovieUI getMovieUI() {
        return movieUI;
    }
}
