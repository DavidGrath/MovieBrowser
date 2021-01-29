package com.example.moviebrowser.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviebrowser.databinding.RecyclerviewErrorBinding;

public class ErrorRecyclerAdapter extends RecyclerView.Adapter<ErrorRecyclerAdapter.ErrorViewHolder> {

    RecyclerviewErrorBinding binding;
    private final String ERROR_TEXT;

    public ErrorRecyclerAdapter(String errorText) {
        this.ERROR_TEXT = errorText;
    }

    @NonNull
    @Override
    public ErrorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RecyclerviewErrorBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ErrorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ErrorViewHolder holder, int position) {
        binding.textviewErrorRecycler.setText(ERROR_TEXT);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ErrorViewHolder extends RecyclerView.ViewHolder {
        public ErrorViewHolder(RecyclerviewErrorBinding binding) {
            super(binding.getRoot());
        }

    }
}
