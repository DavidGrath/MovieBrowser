package com.example.moviebrowser.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviebrowser.databinding.RecyclerviewDefaultEmptyBinding;

public class EmptyRecyclerAdapter extends RecyclerView.Adapter<EmptyRecyclerAdapter.EmptyViewHolder> {

    RecyclerviewDefaultEmptyBinding binding;
    String emptyMessage;

    public EmptyRecyclerAdapter(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }

    @NonNull
    @Override
    public EmptyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding =
                RecyclerviewDefaultEmptyBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new EmptyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmptyViewHolder holder, int position) {
        binding.textviewEmptyRecycler.setText(emptyMessage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(RecyclerviewDefaultEmptyBinding binding) {
            super(binding.getRoot());
        }
    }
}
