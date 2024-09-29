import java.util.Scanner;

public class Task2_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Введите элементы масива: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Количество нечетных чисел, кратных 3: " + dividedByThree(numbers));
    }

    public static int dividedByThree(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0 && num % 3 == 0) {
                count++;
            }
        }

        return count;
    }
}