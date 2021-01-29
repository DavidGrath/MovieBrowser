package com.example.moviebrowser.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviebrowser.R;

public class LoadingRecyclerAdapter extends RecyclerView.Adapter<LoadingRecyclerAdapter.LoadingViewHolder> {
    @NonNull
    @Override
    public LoadingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_default_loading, parent, false);
        return new LoadingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LoadingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
