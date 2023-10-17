package lesson2;

public class Process extends Thread {
    private volatile boolean isRun = true;

    public void run() {
        while (isRun) {
            System.out.println("Hi");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void exit() {
        isRun = false;
    }
}
