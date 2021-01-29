package com.example.moviebrowser.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviebrowser.databinding.FragmentMovieDetailsBinding;
import com.example.moviebrowser.ui.entities.MovieUI;
import com.example.moviebrowser.ui.viewmodels.MainViewModel;
import com.example.moviebrowser.ui.viewmodels.MovieDetailsViewModel;

public class MovieDetailsFragment extends Fragment {
    MovieDetailsViewModel viewModel;
    MainViewModel mainViewModel;
    FragmentMovieDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(MovieDetailsViewModel.class);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.setMovieUIDetails(mainViewModel.getMovieUI());
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieUI movieUI = viewModel.getMovieUI();
        binding.toolbarDetails.setTitle(movieUI.getName());
        binding.synopsisText.setText(movieUI.getDetails());
    }
}
