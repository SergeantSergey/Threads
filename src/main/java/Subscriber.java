public class Subscriber implements Runnable {

    private final Chrono chrono;
    private final int shareTime;

    public Subscriber(Chrono chrono, int shareTime) {
        this.chrono = chrono;
        this.shareTime = shareTime;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (chrono) {

                try {
                    chrono.wait();
                } catch (InterruptedException e) {
                }

                if (Thread.interrupted()) return;

                if (chrono.time % this.shareTime == 0) {
                    System.out.println("Поток деления на " + this.shareTime + " здесь! Время: " + chrono.time);
                }

                if (chrono.maxTime == chrono.time) {
                    return;
                }
            }
        }
    }
}
