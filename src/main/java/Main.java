public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    System.out.println("5 seconds");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(7000);
                    System.out.println("7 seconds");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();
        new Thread(new TenSecondsWaiter()).start();
        System.out.println("Main thread");
    }
}
