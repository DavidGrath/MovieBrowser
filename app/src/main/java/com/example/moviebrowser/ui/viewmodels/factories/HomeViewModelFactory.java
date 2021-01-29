package com.example.moviebrowser.ui.viewmodels.factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviebrowser.ui.viewmodels.HomeViewModel;
import com.example.moviebrowser.usecase.HomeUseCase;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    HomeUseCase useCase;

    public HomeViewModelFactory(HomeUseCase useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(useCase);
    }
}
