import java.util.Scanner;
import java.util.Arrays;

public class Task5_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];

        System.out.println("Введите элементы масива: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
        }

        int[] compressed = compressedNums(numbers);

        System.out.print("Сжатый массив: ");
        for (int num : compressed) {
            System.out.print(num + " ");
        }
    }

    public static int[] compressedNums(double[] numbers) {
        return Arrays.stream(numbers)
                     .filter(num -> num != 0)
                     .distinct()
                     .sorted()
                     .mapToInt(num -> (int) num)
                     .toArray();
    }

    
}
