# Bus
`Bus` is a reactive implementation for the Event Bus pattern. `Bus` is designed particularly for Android usages. This should mainly be used for communication between views, view controllers (e.g. Views, Fragments, Activities).
## Usage
```java
final Bus bus = new Bus();
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
License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
