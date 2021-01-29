package com.example.moviebrowser.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviebrowser.Result;
import com.example.moviebrowser.TempMapperUtil;
import com.example.moviebrowser.data.Movie;
import com.example.moviebrowser.databinding.FragmentHomeBinding;
import com.example.moviebrowser.ui.adapters.EmptyRecyclerAdapter;
import com.example.moviebrowser.ui.adapters.ErrorRecyclerAdapter;
import com.example.moviebrowser.ui.adapters.LoadingRecyclerAdapter;
import com.example.moviebrowser.ui.adapters.MovieTileRecyclerAdapter;
import com.example.moviebrowser.ui.entities.MovieUI;
import com.example.moviebrowser.ui.viewmodels.HomeViewModel;
import com.example.moviebrowser.ui.viewmodels.MainViewModel;
import com.example.moviebrowser.ui.viewmodels.factories.HomeViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import static com.example.moviebrowser.Constants.STATUS_FAILURE;
import static com.example.moviebrowser.Constants.STATUS_PENDING;
import static com.example.moviebrowser.Constants.STATUS_SUCCESS;

public class HomeFragment extends Fragment {

    public interface HomeFragmentCallbackTemp {
        public void onMovieClicked(MovieUI movieUI);
    }

    HomeFragmentCallbackTemp homeFragmentCallbackTemp = null;
    HomeViewModel viewModel;
    MainViewModel mainViewModel;
    FragmentHomeBinding fragmentHomeBinding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeFragmentCallbackTemp = (HomeFragmentCallbackTemp) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel = new ViewModelProvider(this, new HomeViewModelFactory(mainViewModel.getHomeUseCase())).get(HomeViewModel.class);

        final MovieTileRecyclerAdapter upcomingAdapter = new MovieTileRecyclerAdapter(new ArrayList());
        final MovieTileRecyclerAdapter popularAdapter = new MovieTileRecyclerAdapter(new ArrayList());
        final MovieTileRecyclerAdapter topRatedAdapter = new MovieTileRecyclerAdapter(new ArrayList());
        final MovieTileRecyclerAdapter nowPlayingAdapter = new MovieTileRecyclerAdapter(new ArrayList());
        final LoadingRecyclerAdapter loadingAdapter = new LoadingRecyclerAdapter();
        final EmptyRecyclerAdapter emptyRecyclerAdapter = new EmptyRecyclerAdapter("No Items!");
        final ErrorRecyclerAdapter errorRecyclerAdapter = new ErrorRecyclerAdapter("An error occurred. Try later");

        fragmentHomeBinding.homefragMovielistUpcoming.setAdapter(upcomingAdapter);
        fragmentHomeBinding.homefragMovielistPopular.setAdapter(popularAdapter);
        fragmentHomeBinding.homefragMovielistToprated.setAdapter(topRatedAdapter);
        fragmentHomeBinding.homefragMovielistNowplaying.setAdapter(nowPlayingAdapter);

        fragmentHomeBinding.homefragMovielistUpcoming.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        fragmentHomeBinding.homefragMovielistPopular.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        fragmentHomeBinding.homefragMovielistToprated.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        fragmentHomeBinding.homefragMovielistNowplaying.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));

        upcomingAdapter.setItemClickListener((movieUI, position) -> {
            if (homeFragmentCallbackTemp != null) {
                homeFragmentCallbackTemp.onMovieClicked(movieUI);
            }
        });
        viewModel.getUpcoming().observe(this, new Observer<Result<List<Movie>>>() {
            @Override
            public void onChanged(Result<List<Movie>> listResult) {
                switch (listResult.status()) {
                    case STATUS_SUCCESS:
                        List<MovieUI> results = new ArrayList();
                        for (Movie m : listResult.getData()) {
                            results.add(TempMapperUtil.movieToMovieUI(m));
                        }
                        upcomingAdapter.setMovies(results);
                        upcomingAdapter.notifyDataSetChanged();
                        fragmentHomeBinding.homefragMovielistUpcoming.setAdapter(upcomingAdapter);
                        break;
                    case STATUS_PENDING:
                        fragmentHomeBinding.homefragMovielistUpcoming.setAdapter(loadingAdapter);
                        break;
                    case STATUS_FAILURE:
                        fragmentHomeBinding.homefragMovielistUpcoming.setAdapter(errorRecyclerAdapter);
                        break;
                    default:
                        fragmentHomeBinding.homefragMovielistUpcoming.setAdapter(errorRecyclerAdapter);
                        break;
                }
            }
        });
        popularAdapter.setItemClickListener((movieUI, position) -> {
            if (homeFragmentCallbackTemp != null) {
                homeFragmentCallbackTemp.onMovieClicked(movieUI);
            }
        });
        viewModel.getPopular().observe(this, new Observer<Result<List<Movie>>>() {
            @Override
            public void onChanged(Result<List<Movie>> listResult) {
                switch (listResult.status()) {
                    case STATUS_SUCCESS:
                        List<MovieUI> results = new ArrayList();
                        for (Movie m : listResult.getData()) {
                            results.add(TempMapperUtil.movieToMovieUI(m));
                        }
                        popularAdapter.setMovies(results);
                        popularAdapter.notifyDataSetChanged();
                        fragmentHomeBinding.homefragMovielistPopular.setAdapter(popularAdapter);
                        break;
                    case STATUS_PENDING:
                        fragmentHomeBinding.homefragMovielistPopular.setAdapter(loadingAdapter);
                        break;
                    case STATUS_FAILURE:
                        fragmentHomeBinding.homefragMovielistPopular.setAdapter(errorRecyclerAdapter);
                        break;
                    default:
                        fragmentHomeBinding.homefragMovielistPopular.setAdapter(errorRecyclerAdapter);
                        break;
                }
            }
        });
        topRatedAdapter.setItemClickListener((movieUI, position) -> {
            if (homeFragmentCallbackTemp != null) {
                homeFragmentCallbackTemp.onMovieClicked(movieUI);
            }
        });
        viewModel.getTopRated().observe(this, new Observer<Result<List<Movie>>>() {
            @Override
            public void onChanged(Result<List<Movie>> listResult) {
                switch (listResult.status()) {
                    case STATUS_SUCCESS:
                        List<MovieUI> results = new ArrayList();
                        for (Movie m : listResult.getData()) {
                            results.add(TempMapperUtil.movieToMovieUI(m));
                        }
                        topRatedAdapter.setMovies(results);
                        topRatedAdapter.notifyDataSetChanged();
                        fragmentHomeBinding.homefragMovielistToprated.setAdapter(topRatedAdapter);
                        break;
                    case STATUS_PENDING:
                        fragmentHomeBinding.homefragMovielistToprated.setAdapter(loadingAdapter);
                        break;
                    case STATUS_FAILURE:
                        fragmentHomeBinding.homefragMovielistToprated.setAdapter(errorRecyclerAdapter);
                        break;
                    default:
                        fragmentHomeBinding.homefragMovielistToprated.setAdapter(errorRecyclerAdapter);
                        break;
                }
            }
        });
        nowPlayingAdapter.setItemClickListener((movieUI, position) -> {
            if (homeFragmentCallbackTemp != null) {
                homeFragmentCallbackTemp.onMovieClicked(movieUI);
            }
        });
        viewModel.getNowPlaying().observe(this, new Observer<Result<List<Movie>>>() {
            @Override
            public void onChanged(Result<List<Movie>> listResult) {
                switch (listResult.status()) {
                    case STATUS_SUCCESS:
                        List<MovieUI> results = new ArrayList();
                        for (Movie m : listResult.getData()) {
                            results.add(TempMapperUtil.movieToMovieUI(m));
                        }
                        nowPlayingAdapter.setMovies(results);
                        nowPlayingAdapter.notifyDataSetChanged();
                        fragmentHomeBinding.homefragMovielistNowplaying.setAdapter(nowPlayingAdapter);
                        break;
                    case STATUS_PENDING:
                        fragmentHomeBinding.homefragMovielistNowplaying.setAdapter(loadingAdapter);
                        break;
                    case STATUS_FAILURE:
                        fragmentHomeBinding.homefragMovielistNowplaying.setAdapter(errorRecyclerAdapter);
                        break;
                    default:
                        fragmentHomeBinding.homefragMovielistNowplaying.setAdapter(errorRecyclerAdapter);
                        break;
                }
            }
        });

    }
}
