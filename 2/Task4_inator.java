import java.util.Scanner;

public class Task4_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];

        System.out.println("Введите элементы масива: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double[] normalized = normalizator(numbers);

        System.out.println("Нормализованный массив: ");
        for (double num : normalized) {
            System.out.printf("%.4f ", num);
        }
    }

    public static double[] normalizator(double[] numbers) {
        double min = numbers[0];
        double max = numbers[0];

        for (double num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double[] normalized = new double[numbers.length];

        if (min == max) {
            for (int i = 0; i < numbers.length; i++) {
                normalized[i] = 0;  //Если все элементы одинаковые
            }
        } else {
            // Нормализуем каждый элемент
            for (int i = 0; i < numbers.length; i++) {
                normalized[i] = (numbers[i] - min) / (max - min);
            }
        }

        return normalized;
    }
}