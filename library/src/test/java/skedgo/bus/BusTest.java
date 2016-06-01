package skedgo.bus;

import org.junit.Test;

import rx.observers.TestSubscriber;

public class BusTest {
  @Test public void postAndListen() {
    final Bus bus = new Bus();
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
}