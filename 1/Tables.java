/* 10.	Создайте функцию, которая принимает целое число студентов и количество парт в аудитории. 
Функция должна определить, сколько столов не хватает для размещения всех студентов, 
если за одним столом помещается два студента. */

import java.util.Scanner;

public class Tables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество студентов: ");
        int students = scanner.nextInt();
        System.out.print("Количество парт: ");
        int tables = scanner.nextInt();

        int missingTables = tables(students, tables);

        System.out.println("Не хватает столов: " + missingTables);
    }

    public static int tables(int students, int tables) {
        int neededTables = (students + 1) / 2; // За одним столом помещается два студента
        return Math.max(0, neededTables - tables);
    }
}