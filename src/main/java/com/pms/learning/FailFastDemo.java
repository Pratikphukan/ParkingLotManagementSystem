package com.pms.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/*
🔐 Thread Safety Approaches
Synchronized Collections: Achieve thread safety using synchronized wrappers (e.g., Collections.synchronizedList()).

Concurrent Collections: Use advanced mechanisms like segmentation (ConcurrentHashMap) or copy-on-write (CopyOnWriteArrayList).

⚙️ Performance and Scalability
Synchronized Collections:

Use object-level locking — entire collection is locked during operations.
Iterators are not thread-safe; must use manual synchronization.
Poor scalability with increasing size or iteration time.

Concurrent Collections:

Use fine-grained locking (e.g., segment-level in ConcurrentHashMap).
Allow concurrent reads and controlled writes (CopyOnWriteArrayList).
Better performance and scalability under high concurrency.

🛠️ Use Case Suitability
Synchronized Collections:

Simpler, familiar to developers using synchronized blocks.
Easily retrofit thread safety into existing code.
Suitable for low-concurrency scenarios.

Concurrent Collections:

Designed for high-concurrency applications.
Best when collections need to scale and handle many threads.
Ideal when reads dominate writes (especially CopyOnWriteArrayList).

⚖️ Trade-offs
Copy-on-write collections are inefficient for frequent writes due to high cost of copying.
No one-size-fits-all — the choice depends on concurrency level, modification frequency, and compatibility needs.

✅ Conclusion
Understand the trade-offs and choose:

Synchronized for simplicity and legacy compatibility.

Concurrent for better performance and scalability in multi-threaded environments.
 */
public class FailFastDemo {

    private final List<Integer> list;

    private final List<Integer> threadSafeList;

    public FailFastDemo() {
        this.list = new ArrayList<>();
        this.threadSafeList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            threadSafeList.add(i);
        }
    }

    public void iterateThreadSafeList() {
        Thread thread = new Thread(() -> {
            ListIterator<Integer> iterator = threadSafeList.listIterator();
            synchronized (threadSafeList) {
                // Synchronizing the list to prevent concurrent modification exceptions
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        });
        thread.start();
    }

    public void iterateList() {
        Thread thread = new Thread(() -> {
            ListIterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        });
        thread.start();
    }

    public void modifyThreadSafeList() {
        Thread thread = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                synchronized (threadSafeList) {
                    // Synchronizing the list to prevent concurrent modification exceptions
                    threadSafeList.add(i);
                }
            }
        });
        thread.start();
    }

    public void modifyList() {
        Thread thread = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                list.add(i);
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        FailFastDemo demo = new FailFastDemo();
        demo.iterateThreadSafeList();
        demo.modifyThreadSafeList();
//        demo.iterateList();
//        demo.modifyList();
    }

}

