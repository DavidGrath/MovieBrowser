package com.example.moviebrowser;

import static com.example.moviebrowser.Constants.STATUS_SUCCESS;

public class Success<T> extends Result<T> {
    public Success(T data) {
        super(data);
    }

    @Override
    public int status() {
        return STATUS_SUCCESS;
    }
}
