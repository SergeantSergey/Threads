import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.interrupted()) return;
                String string = blockingQueue.take();
                System.out.println(string);
            }
        } catch (InterruptedException e) {
            System.out.println("Exit.");
        }
    }
}
