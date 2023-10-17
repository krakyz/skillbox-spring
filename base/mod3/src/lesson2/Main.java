package lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Process obj = new Process();
//        obj.start();
//
//        System.out.println("Press any key...");
//        Scanner in = new Scanner(System.in);
//        in.nextLine();
//
//        obj.exit();

        final Car car = new Car();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    car.moveCar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    car.stopCar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
