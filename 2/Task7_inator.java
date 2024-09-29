import java.util.Scanner;
import java.util.Arrays;

public class Task7_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Введите элементы масива: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Второй по величине элемент: " + secondBiggest(numbers));
    }

    public static int secondBiggest(int[] numbers) {
        int[] copy = numbers.clone();
        Arrays.sort(copy);
        return copy[copy.length - 2];
    }
}