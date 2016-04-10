package com.skedgo.bus;

import rx.Observable;
import rx.subjects.PublishSubject;

public abstract class Bus {
  public static Bus create() {
    return new Impl();
  }

  public abstract <T> void post(T event);
  public abstract Observable<Object> listen();

  final static class Impl extends Bus {
    private final PublishSubject<Object> subject = PublishSubject.create();

    @Override public <T> void post(T event) {
      subject.onNext(event);
    }

    @Override public Observable<Object> listen() {
      return subject.asObservable();
    }
  }
}