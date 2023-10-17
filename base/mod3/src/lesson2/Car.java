package lesson2;

import java.util.Scanner;

public class Car {

    public void moveCar() throws InterruptedException {
        synchronized (this) {
            System.out.println("Car is moving");
            wait();
        }
    }

    public void stopCar() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Press any key to stop...");
            in.nextLine();
            notify();
            System.out.println("Car stopped.");
        }
    }
}
