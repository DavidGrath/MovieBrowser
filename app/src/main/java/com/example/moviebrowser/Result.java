package com.example.moviebrowser;

public abstract class Result<T> {
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public abstract int status();
}

