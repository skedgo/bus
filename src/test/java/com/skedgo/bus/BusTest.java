package com.skedgo.bus;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;
import rx.subjects.Subject;

import static org.assertj.core.api.Assertions.assertThat;

public class BusTest {
  private Bus bus;

  @Before public void before() {
    bus = Bus.create();
  }

  @Test public void postAndListen() {
    final TestSubscriber<String> subscriber1 = new TestSubscriber<>();
    bus.listen().ofType(String.class).subscribe(subscriber1);
    bus.post("1");
    subscriber1.assertValue("1");
    bus.post("2");
    subscriber1.assertValues("1", "2");
    final TestSubscriber<String> subscriber2 = new TestSubscriber<>();
    bus.listen().ofType(String.class).subscribe(subscriber2);
    subscriber2.assertNoValues();
    bus.post("3");
    subscriber1.assertValues("1", "2", "3");
    subscriber2.assertValue("3");
  }

  @Test public void convertToObservable() {
    assertThat(bus.listen()).isNotInstanceOf(Subject.class);
  }
}