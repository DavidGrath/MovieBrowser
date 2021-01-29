package com.example.moviebrowser;

import static com.example.moviebrowser.Constants.STATUS_PENDING;

public class Pending<T> extends Result<T> {
    public Pending() {
        super(null);
    }

    @Override
    public int status() {
        return STATUS_PENDING;
    }
}
