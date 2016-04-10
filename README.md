# Bus
Bus is a reactive implementation for the Event Bus pattern. Bus is designed particularly for Android usages. This should mainly be used for communication between views, view controllers (e.g. Views, Fragments, Activities).
## Usage
```java
Bus bus = Bus.create();
```
## Publishing
```java
bus.post(ItemSelectedEvent.of(position));
```
## Subscribing
```java
// Subscription can be unsubscribed via some tools like RxLifecycle.
bus.listen()
  .ofType(ItemSelectedEvent.class)
  .subscribe(new Action1<ItemSelectedEvent>() {
    @Override public void call(ItemSelectedEvent event) {
      // TODO: Handle the event.
    }
  }, ErrorHandlers.trackError());
```
