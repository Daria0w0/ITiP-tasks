//1.	Создайте функцию, которая принимает целое число галлонов и преобразует его в литры.

import java.util.Scanner;

public class GallonsToLiters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество галлонов: ");
        int gallons = scanner.nextInt();

        double liters = convert(gallons);

        System.out.println(gallons + " галлонов равно " + liters + " литров.");
    }

    public static double convert(int gallons) {
        return gallons * 3.78541; //перевод из галлонов в литры
    }
}