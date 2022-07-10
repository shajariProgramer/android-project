package com.example.newapplocation.core;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class EventBus {

    private static EventBus instance;
    private PublishSubject<Object> bus = PublishSubject.create();

    private EventBus() {
    }

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
