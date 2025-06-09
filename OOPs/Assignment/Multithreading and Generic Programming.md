# Multithreading in Java: Complete Notes

---

## 1. Introduction to Multithreading and Multitasking

**Definition of Thread (Q1, Q5):**

- A **thread** is the smallest unit of execution within a process. It represents a single path of execution of instructions.
- Threads are sometimes called "lightweight processes" because they run within the context of a process and share its resources (like memory, files, etc.), but each thread has its own stack, program counter, and local variables.
- In Java, threads enable concurrent execution of two or more parts of a program for maximum utilization of CPU. This is useful for tasks like background calculations, handling user input, or performing I/O operations without freezing the main application.
- Technical term: Threads in the same process share the process’s address space, but each thread maintains its own execution context (stack, registers, program counter).

**Definition of Process:**

- A **process** is an independent program in execution, with its own memory space, code, data, and system resources (such as open files and network connections).
- Processes are isolated from each other by the operating system, so one process cannot directly access the memory or resources of another process.
- Communication between processes (Inter-Process Communication, IPC) is more complex and slower compared to threads.

**Multitasking:**

- **Multitasking** is the ability of an operating system or environment to execute multiple tasks (programs or processes) seemingly at the same time by rapidly switching between them.
- There are two main types:

  1. **Process-based multitasking:** Multiple independent programs (processes) run simultaneously. Each process has its own memory and resources. Example: Running a web browser and a text editor at the same time.
  2. **Thread-based multitasking:** Multiple threads within the same program run concurrently, sharing the same memory and resources. Example: A media player playing music (one thread) while downloading album art (another thread).

- Multitasking improves system efficiency and responsiveness, especially on multi-core processors, by allowing better resource utilization and parallelism.
- In Java, thread-based multitasking is commonly used to perform background tasks, improve performance, and keep applications responsive.

**Q2 & Q6: Compare thread-based and process-based multitasking (mutual answer)**

| Feature             | Process-based Multitasking              | Thread-based Multitasking       |
| ------------------- | --------------------------------------- | ------------------------------- |
| Basic Unit          | Process                                 | Thread                          |
| Memory              | Separate for each process               | Shared among threads            |
| Communication       | Slow (IPC needed)                       | Fast (shared memory)            |
| Overhead            | High                                    | Low                             |
| Context Switch      | Slow                                    | Fast                            |
| Example             | Running Word & Chrome                   | Download + play music           |
| Resource Allocation | Allocated per process                   | Shared within process           |
| Failure Impact      | One process crash doesn't affect others | Thread crash may affect process |
| Security/Isolation  | High (isolated by OS)                   | Low (shared address space)      |
| Creation Time       | Slower (more resources)                 | Faster (less resources)         |
| Scalability         | Limited by OS resources                 | More scalable within a process  |
| Use Case            | Running independent apps                | Handling tasks in same app      |

---

## 2. Thread Life Cycle (Q1)

A thread in Java goes through several states during its life:

**Thread States:**

1. **New:** Thread is created but not started yet.
2. **Runnable:** Thread is ready to run and waiting for CPU.
3. **Running:** Thread is currently executing.
4. **Blocked/Waiting:** Thread is waiting for a resource or signal.
5. **Timed Waiting:** Thread is waiting for a specified time.
6. **Terminated (Dead):** Thread has finished execution.

**Diagram: Thread Life Cycle**

![Thread Life Cycle](https://www.tutorialspoint.com/java/images/thread_life_cycle.jpg)

**Explanation:**

- A thread starts in the New state, moves to Runnable when `start()` is called, and then to Running when scheduled by the CPU.
- It can move to Blocked/Waiting if it needs a resource or is waiting for another thread.
- It returns to Runnable when notified or resource is available.
- It ends in Terminated after `run()` completes.

---

## 3. Creating Threads in Java (Q3, Q5, Q7)

There are two main ways to create a thread in Java:

### a) By Extending the Thread Class (Q7)

- Create a class that extends `Thread`.
- Override the `run()` method.
- Create an object and call `start()`.

**Example:**

```java
// Q7: Creating a thread by extending Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}
public class Test {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

### b) By Implementing the Runnable Interface (Q3, Q5)

- Create a class that implements `Runnable`.
- Override the `run()` method.
- Pass an object of your class to a `Thread` object and call `start()`.

**Example:**

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running");
    }
}
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```


**Runnable vs Thread**

| Feature        | Extending Thread              | Implementing Runnable         |
| -------------- | ---------------------------- | ---------------------------- |
| Inheritance    | Can't extend another class   | Can extend another class      |
| Code Reuse     | Less                         | More                         |
| Flexibility    | Less                         | More                         |
| Use Case       | Simple threads               | When you need inheritance     |


---

## 4. Synchronizing Threads (Q4)

**What is Synchronization?**

- Synchronization is a mechanism that ensures only one thread can access a shared resource (like a variable, object, or file) at a time.
- It is essential when multiple threads modify or read shared data, to prevent problems like data inconsistency, race conditions, or corrupted results.
- Without synchronization, two or more threads could simultaneously update the same data, leading to unpredictable outcomes.

**Why Synchronization is Needed:**

- Imagine two threads incrementing the same counter variable at the same time. Without synchronization, both threads might read the same value before either writes back, causing one increment to be lost.
- Synchronization ensures that only one thread can execute a critical section (the part of code that accesses shared resources) at a time.

**How to Synchronize:**

- In Java, you can use the `synchronized` keyword to mark a method or a block of code as synchronized.
- When a thread enters a synchronized method or block, it acquires a lock (monitor) on the object. Other threads trying to enter any synchronized method/block on the same object will be blocked until the lock is released.

**Ways to Synchronize:**

1. **Synchronized Methods:**  
    The entire method is locked for one thread at a time.
    ```java
    class Counter {
         private int count = 0;
         public synchronized void increment() {
              count++;
         }
    }
    ```
2. **Synchronized Blocks:**  
    Only a specific block of code is locked, allowing finer control and potentially better performance.
    ```java
    class Counter {
         private int count = 0;
         public void increment() {
              synchronized(this) {
                    count++;
              }
         }
    }
    ```

**Key Points:**

- Synchronization can be applied to static methods as well, locking the class object.
- Overusing synchronization can lead to performance issues or deadlocks if not managed carefully.

---

## 5. Daemon Threads (Q4)

**What is a Daemon Thread?**

- A daemon thread is a special type of thread that runs in the background to perform tasks such as garbage collection, monitoring, or housekeeping.
- Daemon threads are low-priority threads that do not prevent the JVM from exiting. When all user (non-daemon) threads finish, the JVM will terminate, even if daemon threads are still running.
- Typical uses include background services, timers, or cleanup tasks that should not block application shutdown.

**How to Create a Daemon Thread:**

- You can make any thread a daemon by calling `setDaemon(true)` before starting the thread.
- Once started, you cannot change a thread's daemon status.

**Example:**

```java
class MyDaemon extends Thread {
     public void run() {
          while (true) {
                System.out.println("Daemon thread running...");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
          }
     }
}

public class TestDaemon {
     public static void main(String[] args) {
          MyDaemon daemon = new MyDaemon();
          daemon.setDaemon(true); // Must be called before start()
          daemon.start();

          System.out.println("Main thread finished.");
          // JVM will exit after main thread ends, stopping the daemon
     }
}
```

**Key Points:**

- Daemon threads are useful for background tasks that should not block application exit.
- If only daemon threads remain, the JVM will shut down automatically.
- Always set a thread as daemon before calling `start()`, otherwise an `IllegalThreadStateException` will be thrown.

---

---

## 6. Inter-thread Communication

**Why Needed?**

- Sometimes threads need to coordinate their actions, such as in the producer-consumer problem, where one thread produces data and another consumes it.
- Without proper communication, a consumer might try to consume data before it is produced, or a producer might overwrite data before it is consumed.

**How to Communicate:**

- Java provides the `wait()`, `notify()`, and `notifyAll()` methods for inter-thread communication.
- These methods must be called from within a synchronized context (inside a synchronized method or block).
    - `wait()`: Causes the current thread to release the lock and wait until another thread calls `notify()` or `notifyAll()` on the same object.
    - `notify()`: Wakes up one waiting thread.
    - `notifyAll()`: Wakes up all waiting threads.

**Example (Producer-Consumer Concept):**

- **Producer thread** calls `produce()`, puts data in the buffer, and calls `notify()` to wake up the consumer.
- **Consumer thread** calls `consume()`, waits if no data is available, and calls `notify()` after consuming to wake up the producer.

**Key Points:**

- Always use `wait()`, `notify()`, and `notifyAll()` inside synchronized blocks/methods to avoid `IllegalMonitorStateException`.
- Inter-thread communication helps avoid busy-waiting and enables efficient thread cooperation.
- Common use cases: producer-consumer, reader-writer, and thread pools.


---

## 7. Thread Groups

**What is a Thread Group?**

- A thread group is a way to group multiple threads into a single object for easier management.
- You can start, interrupt, or set priorities for all threads in a group at once.
- Useful for organizing threads in large applications, monitoring, or applying common operations.

**How to Create and Use:**

```java
// Creating a thread group
ThreadGroup group = new ThreadGroup("MyGroup");

// Creating threads in the group
Thread t1 = new Thread(group, "Thread1") {
    public void run() {
        System.out.println("Thread1 running in group: " + Thread.currentThread().getThreadGroup().getName());
    }
};
Thread t2 = new Thread(group, "Thread2") {
    public void run() {
        System.out.println("Thread2 running in group: " + Thread.currentThread().getThreadGroup().getName());
    }
};

// Starting threads
t1.start();
t2.start();
```

**Key Points:**

- You can enumerate, interrupt, or set priorities for all threads in a group.
- Thread groups can be nested (a group can have subgroups).
- Modern Java often uses thread pools (`ExecutorService`) instead of thread groups for advanced management.

---

## 8. Summary Table

| Topic                | Key Points / Technical Terms                                                                                   |
|----------------------|---------------------------------------------------------------------------------------------------------------|
| Thread               | Smallest unit of execution within a process; shares memory, has its own stack and execution context           |
| Process              | Independent program in execution; has its own memory space and resources; isolated from other processes        |
| Multitasking         | Running multiple tasks seemingly at once; includes process-based and thread-based multitasking                 |
| Thread Life Cycle    | States: New, Runnable, Running, Blocked/Waiting, Timed Waiting, Terminated; transitions managed by JVM         |
| Creating Threads     | Two ways: extend Thread class or implement Runnable interface; use `start()` to begin execution                |
| Synchronization      | Mechanism to control access to shared resources; uses `synchronized` keyword to prevent race conditions        |
| Daemon Thread        | Background thread; JVM exits when only daemon threads remain; set with `setDaemon(true)` before `start()`      |
| Inter-thread Comm.   | Coordination between threads using `wait()`, `notify()`, `notifyAll()`; must be used in synchronized context   |
| Thread Group         | Organizes multiple threads for collective management; can start, interrupt, or set priorities for a group      |
| Use Cases            | Examples: background tasks, producer-consumer, thread pools, resource sharing, responsive applications         |

