public class BasicProducerConsumer {

    // Shared buffer and buffer size
    private static final int BUFFER_SIZE = 10;
    private static final int[] buffer = new int[BUFFER_SIZE];
    private static int count = 0;

    public static void main(String[] args) {
        // Create and start producer and consumer threads
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            // Wait for both threads to finish
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Producer class
    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) { // Example: produce 20 items
                synchronized (buffer) {
                    while (count == BUFFER_SIZE) {
                        try {
                            buffer.wait(); // Wait if buffer is full
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[count++] = i;
                    System.out.println("Produced: " + i);
                    buffer.notify(); // Notify consumer
                }
            }
        }
    }

    // Consumer class
    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) { // Example: consume 20 items
                synchronized (buffer) {
                    while (count == 0) {
                        try {
                            buffer.wait(); // Wait if buffer is empty
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int item = buffer[--count];
                    System.out.println("Consumed: " + item);
                    buffer.notify(); // Notify producer
                }
            }
        }
    }
}
