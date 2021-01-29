package com.example.moviebrowser;

import static com.example.moviebrowser.Constants.STATUS_FAILURE;

public class Failure<T> extends Result<T> {
    Throwable throwable;

    public Failure(Throwable t) {
        super(null);
        this.throwable = t;
    }

    @Override
    public int status() {
        return STATUS_FAILURE;
    }
}
