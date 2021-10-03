public class Chrono implements Runnable {

    public int time = 1;
    public int maxTime;
    private static final int TIMER_SLEEP = 1000;

    public Chrono(int maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxTime; i++) {
            try {
                Thread.sleep(TIMER_SLEEP);
                synchronized (this) {
                    time++;
                    this.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("Ошибка в прерывании!");
            }
        }
    }
}
