/*
Напишите программу на Java, которая будет подсчитывать общую сумму чисел от 0 до 1000.
Суммировать необходимо лишь те числа, которые кратны 3 или 5
 */

package task1;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
