package skedgo.bus;

import rx.Observable;
import rx.subjects.PublishSubject;

public class Bus {
  private final PublishSubject<Object> subject = PublishSubject.create();

  public <T> void post(T event) {
    subject.onNext(event);
  }

  public Observable<Object> listen() {
    return subject.asObservable();
  }
}