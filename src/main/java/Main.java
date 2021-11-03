public class Main {

    private static final int MAX_TIME = 15;
    private static final int ONE_SECOND = 1;
    private static final int FIVE_SECOND = 5;
    private static final int SEVEN_SECOND = 7;

    public static void main(String[] args) {

        Chrono chrono = new Chrono(MAX_TIME);

        Thread chronoThread = new Thread(chrono);
        Thread thread1 = new Thread(new Subscriber(chrono, ONE_SECOND));
        Thread thread2 = new Thread(new Subscriber(chrono, FIVE_SECOND));
        Thread thread3 = new Thread(new Subscriber(chrono, SEVEN_SECOND));

        chronoThread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
