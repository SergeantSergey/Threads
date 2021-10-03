import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Producer implements Runnable {

    private final BlockingQueue<String> blockingQueue;
    private final Thread consumer;

    public Producer(BlockingQueue<String> blockingQueue, Thread consumer) {
        this.blockingQueue = blockingQueue;
        this.consumer = consumer;
    }

    @Override
    public void run() {

        ArrayList<String> list = null;
        Parser parser = new Parser();
        File file = new File("voyna.txt");
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("страдани[иеяй].?", Pattern.CASE_INSENSITIVE);

        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String finWorld = matcher.group();
                try {
                    blockingQueue.put(finWorld);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        consumer.interrupt();
    }
}
