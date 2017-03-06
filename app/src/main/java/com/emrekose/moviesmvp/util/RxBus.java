package com.emrekose.moviesmvp.util;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by emrekose on 6.03.2017.
 */

public class RxBus {
    private static RxBus instance = null;
    private final Subject<Object, Object> _bus;
    private final Subject<Object, Object> _stickyBus;

    public RxBus() {
        _bus = new SerializedSubject(PublishSubject.create());
        _stickyBus = new SerializedSubject(BehaviorSubject.create());
    }

    public static RxBus getInstance() {
        if (instance == null)
            instance = new RxBus();
        return instance;
    }

    public void post(Object event) {
        _bus.onNext(event);
    }

    public void postSticky(Object event) {
        _stickyBus.onNext(event);
    }

    public <T> Observable<T> toObserverable() {
        return (Observable<T>) _bus.asObservable().onBackpressureBuffer();
    }

    public <T> Observable<T> toStickyObservable() {
        return (Observable<T>) _stickyBus.asObservable().share().onBackpressureBuffer();
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }

    public boolean hasStickyObservers() {
        return _stickyBus.hasObservers();
    }

}
