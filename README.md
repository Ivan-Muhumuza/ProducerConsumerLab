[loom-video-link](https://www.loom.com/share/7ceb1d8cadfe40b4898501448994f477)

# Producer-Consumer Pattern Lab


### **Project Structure**

```
ProducerConsumerLab/
├── src/
│   ├── BasicProducerConsumer.java   # Basic producer-consumer implementation with wait()/notify()
│   ├── BlockingQueueDemo.java       # Producer-consumer implementation using BlockingQueue
│   ├── PerformanceComparison.java   # Performance benchmarking for different implementations
└── README.md                        # Project description and usage guide
```

### **Files Explanation**

- **BasicProducerConsumer.java**:
    - Implements a simple producer-consumer pattern using threads and manual synchronization with `wait()` and `notify()`.
    - **Producer** generates items and adds them to a shared buffer.
    - **Consumer** retrieves and processes items from the buffer.
    - Demonstrates thread synchronization using explicit `synchronized` blocks.

- **BlockingQueueDemo.java**:
    - Implements the producer-consumer pattern using the `BlockingQueue` class for automatic synchronization.
    - Simplifies the synchronization process as the queue manages waiting and signaling internally.
    - Uses `ArrayBlockingQueue` to store the produced items, making the implementation more efficient.

- **PerformanceComparison.java**:
    - Compares the performance of both implementations (basic and `BlockingQueue`).
    - Measures and displays the time taken to run the basic producer-consumer implementation versus the `BlockingQueue`-based implementation.

## **How to Run the Project**

1. **Compile the Java Files**:
   Navigate to the `src/` directory from the terminal and compile each of the Java files:
   ```bash
   cd src/
   javac BasicProducerConsumer.java
   javac BlockingQueueDemo.java
   javac PerformanceComparison.java
   ```

2. **Run the Implementations**:

    - **Basic Producer-Consumer**:
      ```bash
      java BasicProducerConsumer
      ```
      This will run the basic implementation using `wait()` and `notify()`.

    - **BlockingQueue Implementation**:
      ```bash
      java BlockingQueueDemo
      ```
      This will run the implementation using `BlockingQueue`.

    - **Performance Comparison**:
      ```bash
      java PerformanceComparison
      ```
      This will run both implementations and display the time taken by each, allowing you to compare performance.
