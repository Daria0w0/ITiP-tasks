/* 5.	В Java есть вариация условного оператора – тернарный оператор "? :", 
принимающий три операнда и возвращающий один из них на основе значения условия. 
Он имеет следующую структуру:

условие ? выражение1 : выражение2

Ваша задача создать функцию, которая принимает два числа a и b, 
а затем с помощью тернарного оператора определяет, какое из чисел больше, и возвращает большее число. */


import java.util.Scanner;

public class TernaryEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        int a = scanner.nextInt();
        System.out.print("Второе число: ");
        int b = scanner.nextInt();

        int max = ternaryEvaluation(a, b);

        System.out.println("Большее число: " + max);
    }

    // Функция для определения большего числа с помощью тернарного оператора
    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }
}