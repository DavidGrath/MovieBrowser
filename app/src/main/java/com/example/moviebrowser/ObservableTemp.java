package com.example.moviebrowser;

import java.util.ArrayList;
import java.util.List;

public class ObservableTemp<T> {
    private T data;
    List<ObserverTemp> observers = new ArrayList();

    public ObservableTemp(T data) {
        this.data = data;
    }

    public void observe(ObserverTemp observer) {
        observers.add(observer);
    }

    public void update(T newValue) {
        this.data = newValue;
        for (ObserverTemp o : observers) {
            o.onUpdate(data);
        }
    }

    public interface ObserverTemp<T> {
        void onUpdate(T newValue);
    }
}
