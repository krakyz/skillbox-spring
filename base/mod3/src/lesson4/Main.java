package lesson4;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Course[] objects = {
                new Course(1, "Android"),
                new Course(2, "Kotlin")
        };

        try {
            FileOutputStream fos = new FileOutputStream("file.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(objects);
//                oos.writeObject(kotlin);

                oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
