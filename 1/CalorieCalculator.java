/*2.	Вы пишете программу для квази-фитнес-приложения и хотите создать 
функцию для расчета калорий, сожженных пользователем во время тренировки.
Функция должна принимать время тренировки в минутах и интенсивность,
где 1 – низкая интенсивность, 2 – средняя, 3 – высокая, 
а затем вычислять количество сожженных калорий на основе этой информации. */

import java.util.Scanner;

public class CalorieCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Время тренировки в минутах: ");
        int minutes = scanner.nextInt();
        System.out.print("Интенсивность (1 - низкая, 2 - средняя, 3 - высокая): ");
        int intensity = scanner.nextInt();

        int calories = fitCalc(minutes, intensity);

        System.out.println("Было сожжено " + calories + " калорий.");
    }
    // Функция для расчета сожженных калорий
    public static int fitCalc(int minutes, int intensity) {
        return minutes * intensity;
    }
}