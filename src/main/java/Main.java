import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        Consumer consumer = new Consumer(blockingQueue);
        Thread consumerThread = new Thread(consumer);

        Producer producer = new Producer(blockingQueue, consumerThread);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        consumerThread.start();

        // ждем пока потоки умрут
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
