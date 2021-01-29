package com.example.moviebrowser.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviebrowser.R;
import com.example.moviebrowser.ui.entities.MovieUI;
import com.example.moviebrowser.ui.fragments.HomeFragment;
import com.example.moviebrowser.ui.fragments.MovieDetailsFragment;
import com.example.moviebrowser.ui.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeFragmentCallbackTemp {

    MainViewModel viewModel;
    MovieDetailsFragment movieDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        HomeFragment homeFragment = new HomeFragment();
        movieDetailsFragment = new MovieDetailsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_main, homeFragment)
                .commit();

    }

    @Override
    public void onMovieClicked(MovieUI movieUI) {
        viewModel.setMovieUIDetails(movieUI);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_main, movieDetailsFragment)
                .addToBackStack(null)
                .commit();
    }
}