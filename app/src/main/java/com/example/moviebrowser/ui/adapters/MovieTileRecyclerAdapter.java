package com.example.moviebrowser.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviebrowser.R;
import com.example.moviebrowser.ui.entities.MovieUI;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.moviebrowser.Constants.IMAGE_URL;

public class MovieTileRecyclerAdapter extends RecyclerView.Adapter<MovieTileRecyclerAdapter.MovieTileViewHolder> {

    public interface RecyclerItemClickListener {
        public void onItemClicked(MovieUI movieUI, int position);
    }

    public void setItemClickListener(RecyclerItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    RecyclerItemClickListener itemClickListener = null;

    public void setMovies(List<MovieUI> movies) {
        this.movies = movies;
    }

    List<MovieUI> movies;

    public MovieTileRecyclerAdapter(List<MovieUI> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieTileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_movie_tile, parent, false);
        return new MovieTileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTileViewHolder holder, int position) {
        final MovieUI movie = movies.get(position);
        holder.movieTitle.setText(movie.getName());
        Picasso.with(holder.itemView.getContext())
                .load(IMAGE_URL + movie.getUri())
                .fit()
                .into(holder.movieProfile);
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClicked(movie, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieTileViewHolder extends RecyclerView.ViewHolder {
        final TextView movieTitle;
        final ImageView movieProfile;

        public MovieTileViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.textview_movie_title);
            movieProfile = itemView.findViewById(R.id.movie_tile_profile);
        }
    }
}
