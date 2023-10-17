package task;

import lesson4.Course;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введетие имя: ");
        String username = scanner.nextLine();
        System.out.print("Введите логин: ");
        String nickname = scanner.nextLine();
        System.out.print("Введите возраст: ");
        byte age = scanner.nextByte();
        scanner.nextLine();
        System.out.print("Введите хобби через запятую: ");
        String[] hobbies = scanner.nextLine().split(",");


        User user = new User(username, nickname, age, hobbies);

        try {
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(user);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User outputText = (User) ois.readObject();
            System.out.println(outputText);

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
