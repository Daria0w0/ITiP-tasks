// 8.	Создайте функцию, которая находит наибольший общий делитель двух чисел.

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        int a = scanner.nextInt();
        System.out.print("Второе число: ");
        int b = scanner.nextInt();

        int gcd = gcd(a, b);

        System.out.println("Наибольший общий делитель: " + gcd);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}