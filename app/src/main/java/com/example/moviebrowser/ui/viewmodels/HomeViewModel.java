package com.example.moviebrowser.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviebrowser.Result;
import com.example.moviebrowser.data.Movie;
import com.example.moviebrowser.usecase.HomeUseCase;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private HomeUseCase useCase;

    public HomeViewModel(HomeUseCase useCase) {
        this.useCase = useCase;
    }

    public LiveData<Result<List<Movie>>> getUpcoming() {
        MutableLiveData<Result<List<Movie>>> upcomingLiveData = new MutableLiveData();
        useCase.getUpcoming().observe(newValue -> {
            Result result = (Result<List<Movie>>) newValue;
            upcomingLiveData.postValue(result);
        });
        return upcomingLiveData;
    }

    public LiveData<Result<List<Movie>>> getPopular() {
        MutableLiveData<Result<List<Movie>>> popularLiveData = new MutableLiveData();
        useCase.getPopular().observe(newValue -> {
            Result result = (Result<List<Movie>>) newValue;
            popularLiveData.postValue(result);
        });
        return popularLiveData;
    }

    public LiveData<Result<List<Movie>>> getTopRated() {
        MutableLiveData<Result<List<Movie>>> topRatedLiveData = new MutableLiveData();
        useCase.getTopRated().observe(newValue -> {
            Result result = (Result<List<Movie>>) newValue;
            topRatedLiveData.postValue(result);
        });
        return topRatedLiveData;
    }

    public LiveData<Result<List<Movie>>> getNowPlaying() {
        MutableLiveData<Result<List<Movie>>> nowPlayingLiveData = new MutableLiveData();
        useCase.getUpcoming().observe(newValue -> {
            Result result = (Result<List<Movie>>) newValue;
            nowPlayingLiveData.postValue(result);
        });
        return nowPlayingLiveData;
    }

}
