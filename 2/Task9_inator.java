import java.util.Scanner;

public class Task9_inator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Три целых числа через пробел: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Количество одинаковых чисел: " + equal(a, b, c));
    }

    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        }
        return 0;
    }
}